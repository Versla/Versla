package com.wise.versla.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wise.versla.dto.Category;
//import com.wise.versla.dto.Moderator;
//import com.wise.versla.dto.User;
//import com.wise.versla.dto.User;
import com.wise.versla.util.DBUtility;

public class CategoryDAO {
	public int insert(Category category){
		final String QUERY = "insert into category(name,logo,moderator_id) values(?,?,?)";
		int status=0;
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()){
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, category.getName());
			preparedStatement.setString(2, category.getLogo());
			System.out.println("hii");
			preparedStatement.setInt(3,category.getModerator().getId());
			status = preparedStatement.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtility.close(preparedStatement);
		}
		return status;
	}
	
	public int delete(int categoryId){
		final String QUERY = "update category set delete_category='"+1+"' where id=?";
		int status=0;
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()){
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, categoryId);
			status = preparedStatement.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtility.close(preparedStatement);
		}
		return status;
	}
	
	/*public Category getCategoryById(Int id){
		final String QUERY = "select * from category where delete_category="+0+" and name=";

		
	} */
	
	public Category getCategoryByName(String name){
		final String QUERY = "select * from category where name=? and _delete=0";
		ResultSet resultSet = null; 
		PreparedStatement preparedStatement = null;
		Category category = new Category() ;
		try(Connection connection = DBUtility.getConnection()){
		preparedStatement = connection.prepareStatement(QUERY);
		preparedStatement.setString(1,name);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			category.setId(resultSet.getInt(1));
			category.setName(resultSet.getString(2));
			}
	}catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		DBUtility.close(resultSet,preparedStatement);
	}
	return category;
	}
	
	public List<Category> getAllCategory(){
		final String QUERY = "select * from category where _delete="+0+"";
		ResultSet resultSet = null; 
		PreparedStatement preparedStatement = null;
		List<Category> categoryList = null;
		try(Connection connection = DBUtility.getConnection()){
		preparedStatement = connection.prepareStatement(QUERY);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			categoryList = new ArrayList<Category>();
			do{
			Category category = new Category();
			category.setId(resultSet.getInt(1));
			category.setName(resultSet.getString(2));
			category.setLogo(resultSet.getString(3));
			categoryList.add(category);
			}while(resultSet.next());
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		DBUtility.close(resultSet,preparedStatement);
	}
	return categoryList;
	}
}
