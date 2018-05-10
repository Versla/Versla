package com.wise.versla.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wise.versla.dto.Moderator;
import com.wise.versla.util.DBUtility;

public class ModeratorDAO {
	public int insertModerator(Moderator moderator){
		final String QUERY = "insert into Moderator(name,password,email,phone_number) values(?,?,?,?)";
		PreparedStatement preparedStatement = null;
		int status=0;
		try(Connection connection = DBUtility.getConnection()){
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, moderator.getName());
			preparedStatement.setString(2, moderator.getPassword());
			preparedStatement.setString(3, moderator.getEmailId());
			preparedStatement.setLong(4, moderator.getPhone());
			status = preparedStatement.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtility.close(preparedStatement);
		}
		return status;
	}
	
	public Moderator getModeratorByEmailId(String emailId){
		final String QUERY = "select * from moderator where email= ?";
		ResultSet resultSet = null; 
		PreparedStatement preparedStatement = null;
		Moderator moderator = new Moderator();
		try(Connection connection = DBUtility.getConnection()){
		preparedStatement = connection.prepareStatement(QUERY);
		preparedStatement.setString(1,emailId);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			moderator.setId(resultSet.getInt(1));
			moderator.setName(resultSet.getString(2));
			moderator.setPhone(resultSet.getLong(5));
			moderator.setEmailId(resultSet.getString(4));
			moderator.setPassword(resultSet.getString(3));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		DBUtility.close(resultSet,preparedStatement);
	}
	return moderator;
	}
	

	public Moderator getModeratorByUserId(int moderatorId){
		final String QUERY = "select * from moderator where id=?";
		ResultSet resultSet = null; 
		PreparedStatement preparedStatement = null;
		Moderator moderator = new Moderator();
		try(Connection connection = DBUtility.getConnection()){
		preparedStatement = connection.prepareStatement(QUERY);
		preparedStatement.setInt(1,moderatorId);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			//user.setId(resultSet.getInt(1));
			moderator.setName(resultSet.getString(2));
			moderator.setPhone(resultSet.getLong(3));
			moderator.setEmailId(resultSet.getString(4));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		DBUtility.close(resultSet,preparedStatement);
	}
	return moderator;
	}
	
	public int updateUser(int moderatorid){
		final String QUERY="update user set email=?,phone_number=?,password=? where id=?";
		int status=0;
		Moderator moderator = new Moderator();
		PreparedStatement preparedStatement = null;
		try(Connection connection =DBUtility.getConnection()){
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1,moderator.getEmailId());
			preparedStatement.setLong(2,moderator.getPhone());
			preparedStatement.setString(3,moderator.getPassword());
			preparedStatement.setInt(4,moderator.getId());
			status = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtility.close(preparedStatement);
		}
		return status; 
	}
	
	
}
