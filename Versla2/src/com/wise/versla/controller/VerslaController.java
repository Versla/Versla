package com.wise.versla.controller;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
//import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;

//import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.wise.versla.dao.CategoryDAO;
import com.wise.versla.dao.ItemDAO;
//import com.wise.versla.dao.CategoryDAO;
import com.wise.versla.dao.ModeratorDAO;
import com.wise.versla.dao.SubCategoryDAO;
import com.wise.versla.dao.UserDAO;
import com.wise.versla.dto.Category;
import com.wise.versla.dto.Item;
import com.wise.versla.dto.Moderator;
import com.wise.versla.dto.SubCategory;
import com.wise.versla.dto.User;
//import com.wise.versla.util.DBUtility;
//import com.wise.versla.util.DateUtility;
import com.wise.versla.util.DBUtility;

/**
 * Servlet implementation class VerslaController
 */
@WebServlet("/VerslaController")
public class VerslaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY1="category";
	private final String UPLOAD_DIRECTORY2="subCategory";
//	private final String UPLOAD_DIRECTORY3="item";
	private final int THRESHOLD_SIZE=1024*1024*3;
	private final int MAX_FILE_SIZE=1024*1024*40;
	private final int MAX_REQUEST_SIZE=1024*1024*50;
	String uploadDirectory = null;
	String action = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerslaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("here");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(action == "Category" || action =="SubCategory"){
			response.sendRedirect("./moderator.jsp");
		}
		else if(action==null){
			response.sendRedirect("./home.jsp");
		}
		//else if(action=="Item"){
		//	response.sendRedirect("./item.jsp");
		//}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
			FileUpload(request).forward(request,response);
		}
		String action = request.getParameter("action");
		
		if(action.equals("RegisterUser")){
			register(request).forward(request,response);
		}
		else if(action.equals("User"))
				loginUser(request).forward(request,response);
		else if(action.equals("Moderator"))
				loginModerator(request).forward(request,response);
		//else if(action.equals("logout")){
			//	response.sendRedirect("./logout.jsp");
			//}
		//else if(action.equals("Category"))
			//addCategory(request).forward(request,response);	
		else
			response.sendRedirect("./home.jsp");
		}
	
	
	private RequestDispatcher register(HttpServletRequest request){
		UserDAO userdao = new UserDAO();
		String name = request.getParameter("username");
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		String phone  =  request.getParameter("phone");
		//String dateOfBirth =request.getParameter("dob");
		User user = new User();
		user.setEmailId(emailId);
		user.setPassword(MD5(password));
		user.setUserName(name);
		user.setPhone(Long.parseLong(phone));
		//user.setDateOfBirth(DateUtility.StringToUtil(dateOfBirth));
		userdao.insertUser(user);
		return request.getRequestDispatcher("./home.jsp");
	}
	private RequestDispatcher loginUser(HttpServletRequest request){
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
			User user = new User();
			UserDAO userdao = new UserDAO();
			user = userdao.getUserByEmailId(emailId);
			if(password.equals(user.getPassword()))
				return request.getRequestDispatcher("./userhome.jsp");
		return request.getRequestDispatcher("./home.jsp");
	}
	
	private RequestDispatcher loginModerator(HttpServletRequest request){
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		Moderator moderator = new Moderator();
		ModeratorDAO moderatordao = new ModeratorDAO();
		moderator = moderatordao.getModeratorByEmailId(emailId);
		if(password.equals(moderator.getPassword())){
			HttpSession session = request.getSession();
			moderator = moderatordao.getModeratorByEmailId(emailId);
			session.setAttribute("id",moderator.getId());
			
			return request.getRequestDispatcher("./moderator.jsp");
		}
		return request.getRequestDispatcher("./home.jsp");
	}
	
	public RequestDispatcher FileUpload(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		System.out.println(session);
		List  items =null;
		String logo_name = null;
		String name=null;
	
		try	{
		    DiskFileItemFactory factory = new DiskFileItemFactory();
		   factory.setSizeThreshold(THRESHOLD_SIZE);
		   factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		    // Create a new file upload handler
		    ServletFileUpload upload = new ServletFileUpload(factory);
		    upload.setFileSizeMax(MAX_FILE_SIZE);
		    upload.setSizeMax(MAX_REQUEST_SIZE);
		    System.out.println("oyy1");
		    // Parse the request
		    items = upload.parseRequest(request);
		    System.out.println("oyy");
		    Iterator iter = items.iterator();
		    String subcategory_name = null;
		    String category_name = null;
		    while (iter.hasNext()) {
		        FileItem item = (FileItem) iter.next();
		        if(item.isFormField()){
		        	if(item.getFieldName().equals("action")){
		        		action = item.getString(); 
		        		if(action.equals("Category")){
		        			uploadDirectory = UPLOAD_DIRECTORY1;
		        		}
		        		else if(action.equals("subCategory")){
		        			uploadDirectory = UPLOAD_DIRECTORY2;
		        		}
		        	}
		        }
		        if(item.getFieldName().equals("name"))	{
	        		name = item.getString();
	        		System.out.println(name);	        		
	        	}
		        else if(item.getFieldName().equals("subcategory")){
		        	subcategory_name  = item.getString();
		        }
		        else if(item.getFieldName().equals("categoryInSubCategory")){
		        	category_name = item.getString();
		        }
		        
		    }
		    Iterator itere = items.iterator();
		    while (itere.hasNext()) {
		        FileItem item = (FileItem) itere.next();
		       // System.out.println(uploadDirectory);
		        if (!item.isFormField()) {
		        	String uploadFolder = getServletContext().getInitParameter("imageupload")
							+File.separator+uploadDirectory;
				    File uploadDir=new File(uploadFolder);
				    if(!uploadDir.exists()){
				    	uploadDir.mkdir();
				    }
		        	String fileName = new File(item.getName()).getName();
		        	String filePath = uploadFolder + File.separator + fileName;
                    File uploadedFile = new File(filePath);
                   
                    item.write(uploadedFile);
                  //  HttpSession session = request.getSession(false);
                    System.out.println(session);
                    if (session != null) {
                    	// System.out.println("came");
                    	if (session.getAttribute("id") != null) {
            				if(action.equals("Category")){
            				System.out.println("hdshsbvkbvkjs");
            				Category category = new Category();
            				CategoryDAO categoryDAO = new CategoryDAO();
            				category.setName(name);
            				category.setLogo(item.getName());
            				System.out.println(category);
            				Moderator moderator = new Moderator();
            				moderator.setId((int) session.getAttribute("id"));
            				category.setModerator(moderator);
            				System.out.println(moderator.getId());
            				categoryDAO.insert(category);            				
            			} 
                    	if(action.equals("subCategory")){
                				System.out.println("hdshsbvkbvkjs");
                    			SubCategory subcategory = new SubCategory();
                    			Category category = new Category();
                    			CategoryDAO categorydao = new CategoryDAO();
                    			category = categorydao.getCategoryByName(category_name);
                    			System.out.println(category);
                    			SubCategoryDAO subcategorydao = new SubCategoryDAO();
                				Moderator moderator = new Moderator();
                				session.setAttribute("categoryID",category.getId());
                				moderator.setId((int) session.getAttribute("id"));
                				category.setId((int)session.getAttribute("categoryID"));
                    			subcategory.setName(subcategory_name);
                				subcategory.setImage(item.getName());
                				subcategory.setModerator(moderator);
                				subcategory.setCategory(category);
                				subcategorydao.insert(subcategory);
                			} 
                    	}
                    }
		        
		        
		        }
		    }
       }
       catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();			   
		    }
       return request.getRequestDispatcher("./moderator.jsp");
	}
	
	private String MD5(String password){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest=md.digest(password.getBytes());
			BigInteger num = new BigInteger(1,messageDigest);
			String hashtext = num.toString(16);
			while(hashtext.length()<32){
				hashtext = "0"+hashtext;
			}
			return hashtext;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	} 
	
	
	/*private RequestDispatcher subCategory(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		return null;
	}*/

	/*public RequestDispatcher addCategory(HttpServletRequest request){	
		HttpSession session = request.getSession();
		if(session!=null){
			if(session.getAttribute("email")=)
		}
		CategoryDAO categorydao = new CategoryDAO();
		Category  category = new Category();
		//category.setName(name);
		//category.setLogo(logo);00000
		categorydao.insert(category);
		]
		 <select >
              <option label = "Preethi">Preethi</option>
              <option label = "Manasa">Manasa</option>
              <option label = "Hema">Hema</option>
              <option label = "Vineela">Vineela</option>
              
              </select><br>

		return request.getRequestDispatcher("./moderator.jsp");
	}
	*/

	       }
	
