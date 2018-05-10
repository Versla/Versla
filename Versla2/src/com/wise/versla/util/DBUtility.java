package com.wise.versla.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;


public class DBUtility {
	static Connection connection = null;
	public static Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/versla?useSSL = true","root","root");		
		}catch(SQLException | ClassNotFoundException exception){
			exception.printStackTrace();
		}
		return connection;
	}
	public static void close(Object ...args){
		try{
		for(Object arg :args){
			if(arg instanceof ResultSet){
				((ResultSet) arg).close();
			}
			if(arg instanceof PreparedStatement){
				((PreparedStatement) arg).close();
			}
			if(arg instanceof Statement){
				((Statement) arg).close();
			}
			if(arg instanceof Connection){
				((Connection) arg).close();
			}
		}
		}
		catch(SQLException exception){
			exception.printStackTrace();
		}
		
	}
	public static java.util.Date sqlToUtil(java.sql.Date sqlDate) {
		java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
		return utilDate;
	}
	
	public static java.sql.Date utilToSql(java.util.Date utilDate) {
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	
	public static String UtilToString(java.util.Date utilDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String string = formatter.format(utilDate);
		return string;
	}
	
	public static java.util.Date StringToUtil(String string) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date utilDate = null;
			try {
				utilDate = formatter.parse(string);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return utilDate;
	}
}
