package com.wise.versla.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.wise.versla.dto.SubCategory;
import com.wise.versla.util.DBUtility;

public class SubCategoryDAO {
	public int insert(SubCategory subcategory){
		final String QUERY = "insert into sub_category(name,image,moderator_id,category_id) values(?,?,?,?)";
		int status=0;
		//System.out.println("completed1");
		try(Connection connection = DBUtility.getConnection()){
			System.out.println("completed");
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, subcategory.getName());
			preparedStatement.setString(2, subcategory.getImage());
			preparedStatement.setInt(3,subcategory.getModerator().getId());
			preparedStatement.setInt(4,subcategory.getCategory().getId());
			status = preparedStatement.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public int delete(int subcategoryId){
		final String QUERY = "update sub_category set delete_subcategory='"+1+"' where id=?";
		int status=0;
		try(Connection connection = DBUtility.getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, subcategoryId);
			status = preparedStatement.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public List<SubCategory> getAllSubCategory(){
		final String QUERY = "select * from sub_category where delete_subcategory="+0+"";
		ResultSet resultSet = null; 
		PreparedStatement preparedStatement = null;
		SubCategory subcategory = new SubCategory();
		List<SubCategory> subcategoryList = new ArrayList<SubCategory>();
		try(Connection connection = DBUtility.getConnection()){
		preparedStatement = connection.prepareStatement(QUERY);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			do{
			subcategory.setId(resultSet.getInt(1));
			subcategory.setName(resultSet.getString(2));
			subcategory.setImage(resultSet.getString(3));
			subcategoryList.add(subcategory);
			}while(resultSet.next());
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		DBUtility.close(resultSet,preparedStatement);
	}
	return subcategoryList;
	}
	
	public List<SubCategory> getAllByCategoryId(int categoryId){
		final String QUERY = "select * from sub_category where delete_subcategory="+0+" and category_id=?";
		ResultSet resultSet = null; 
		PreparedStatement preparedStatement = null;
		SubCategory subcategory = new SubCategory();
		List<SubCategory> subcategoryList = new ArrayList<SubCategory>();
		try(Connection connection = DBUtility.getConnection()){
		preparedStatement = connection.prepareStatement(QUERY);
		preparedStatement.setInt(1,categoryId);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			do{
			subcategory.setId(resultSet.getInt(1));
			subcategory.setName(resultSet.getString(2));
			subcategory.setImage(resultSet.getString(3));
			subcategoryList.add(subcategory);
			}while(resultSet.next());
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		DBUtility.close(resultSet,preparedStatement);
	}
	return subcategoryList;
	}
	public static void main(String args[]){
		 SubCategoryDAO userdao = new SubCategoryDAO();
		 //Category user = new Category();
		// user = userdao.delete(1);
		 System.out.println(userdao.delete(1));
		}
	
}
