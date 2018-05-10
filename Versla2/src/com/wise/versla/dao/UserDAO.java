 package com.wise.versla.dao;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.wise.versla.dto.User;
import com.wise.versla.util.DBUtility;

public class UserDAO {
	public int insertUser(User user){
		final String QUERY = "insert into user(name,phone_number,email_id,password) values(?,?,?,?)";
		int status=0;
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()){
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setLong(2, user.getPhone());
			preparedStatement.setString(3, user.getEmailId());
			preparedStatement.setString(4, user.getPassword());
			//preparedStatement.setDate(5,DBUtility.utilToSql(user.getDateOfBirth()));
			status = preparedStatement.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtility.close(preparedStatement);
		}
		return status;
	}
	
	
	public User getUserByEmailId(String emailId){
		final String QUERY = "select * from user where email_id=? and unsubscribe=0";
		ResultSet resultSet = null; 
		PreparedStatement preparedStatement = null;
		User user = new User();
		try(Connection connection = DBUtility.getConnection()){
		preparedStatement = connection.prepareStatement(QUERY);
		preparedStatement.setString(1,emailId);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			user.setUserId(resultSet.getInt(1));
			user.setUserName(resultSet.getString(2));
			user.setPhone(resultSet.getLong(3));
			user.setEmailId(resultSet.getString(4));
			user.setPassword(resultSet.getString(5));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		DBUtility.close(resultSet,preparedStatement);
	}
	return user;
	}
	
	
	public User getUserByUserId(int userId){
		final String QUERY = "select * from user where id=? and unsubscribe=0";
		ResultSet resultSet = null; 
		PreparedStatement preparedStatement = null;
		User user = new User();
		try(Connection connection = DBUtility.getConnection()){
		preparedStatement = connection.prepareStatement(QUERY);
		preparedStatement.setInt(1,userId);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			user.setUserId(resultSet.getInt(1));
			user.setUserName(resultSet.getString(2));
			user.setPhone(resultSet.getLong(3));
			user.setEmailId(resultSet.getString(4));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		DBUtility.close(resultSet,preparedStatement);
	}
	return user;
	}
	 
	
	public int updateUser(int userId){
		final String QUERY="update user set email_id=?,phone_number=?,password=? where id=?";
		int status=0;
		User user = new User();
		PreparedStatement preparedStatement = null;
		try(Connection connection =DBUtility.getConnection()){
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1,user.getEmailId());
			preparedStatement.setLong(2,user.getPhone());
			preparedStatement.setString(3,user.getPassword());
			preparedStatement.setInt(4,userId);
			status = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtility.close(preparedStatement);
		}
		return status; 
	}
	
	
	public List<User> getAllUsers(){
		final String QUERY = "select * from user where unsubscribe=0";
		ResultSet resultSet = null; 
		PreparedStatement preparedStatement = null;
		List<User> userList = null;
		try(Connection connection = DBUtility.getConnection()){
		preparedStatement = connection.prepareStatement(QUERY);
		resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				userList= new ArrayList<User>();
				do{
					User user = new User();
					user.setUserId(resultSet.getInt(1));
					user.setUserName(resultSet.getString(2));
					user.setPhone(resultSet.getLong(3));
					user.setEmailId(resultSet.getString(4));
					userList.add(user);
				}while(resultSet.next());
			}
		}
	catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		DBUtility.close(resultSet,preparedStatement);
	}
	return userList;
	}
	
	public static void main(String args[]){
	UserDAO userdao = new UserDAO();
	//List<User> user = new ArrayList<User>();
	System.out.println(userdao.getAllUsers());
	}
}

