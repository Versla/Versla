package com.wise.versla.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wise.versla.dto.Item;
import com.wise.versla.dto.Moderator;
import com.wise.versla.util.DBUtility;

public class ItemDAO {
	public int insertItem(Item item){
		final String QUERY = "insert into Item(description,old_months,price,sold,max_price,min_price,locality,city,area,item_date) values(?,?,?,?,?,?,?,?,?,?)";
		int status=0;
		PreparedStatement preparedStatement = null;
		try(Connection connection = DBUtility.getConnection()){
		    preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, item.getDescription());
			preparedStatement.setLong(2, item.getOldMonths());
			preparedStatement.setInt(3, item.getPrice());
			preparedStatement.setString(4, item.getSold());
			preparedStatement.setInt(5, item.getMaxPrice());
			preparedStatement.setInt(6, item.getMinPrice());
			preparedStatement.setString(7, item.getLocality());
			preparedStatement.setString(8, item.getCity());
			preparedStatement.setString(9, item.getArea());
			preparedStatement.setDate(10,(Date) item.getDate());

			status = preparedStatement.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtility.close(preparedStatement);
		}
		return status;
	}
	
	public Item getItemById(int itemId){
		final String QUERY = "select * from item where id=? and sold='"+"No"+"'";
		ResultSet resultSet = null; 
		PreparedStatement preparedStatement = null;
		Item item = new Item();
		try(Connection connection = DBUtility.getConnection()){
		preparedStatement = connection.prepareStatement(QUERY);
		preparedStatement.setInt(1,itemId);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			item.setId(resultSet.getInt(1));
			item.setDescription(resultSet.getString(2));
			item.setOldMonths(resultSet.getInt(3));
			item.setPrice(resultSet.getInt(4));
			item.setSold(resultSet.getString(5));
			item.setMaxPrice(resultSet.getInt(6));
			item.setMinPrice(resultSet.getInt(7));
			item.setLocality(resultSet.getString(8));
			item.setCity(resultSet.getString(9));
			item.setArea(resultSet.getString(10));
			item.setDate(resultSet.getDate(11));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		DBUtility.close(resultSet,preparedStatement);
	}
	return item;
	}
	
	public int updateItem(int itemId){
		final String QUERY="update item set description=?,price=? where id=?";
		int status=0;
		Item item = new Item();
		try(Connection connection =DBUtility.getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1,item.getDescription());
			preparedStatement.setInt(2,item.getPrice());
			preparedStatement.setInt(3,itemId);
			status = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return status; 
	}
	
	public List<Item> getAllItems(){ 
		final String QUERY = "select * from item where sold="+"No"+"";
		ResultSet resultSet = null; 
		PreparedStatement preparedStatement = null;
		List<Item> itemList = null;
		try(Connection connection = DBUtility.getConnection()){
		preparedStatement = connection.prepareStatement(QUERY);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			itemList = new ArrayList<Item>();
			do{
				Item item = new Item();
				item.setId(resultSet.getInt(1));
				item.setDescription(resultSet.getString(2));
				item.setOldMonths(resultSet.getInt(3));
				item.setPrice(resultSet.getInt(4));
				item.setSold(resultSet.getString(5));
				item.setMaxPrice(resultSet.getInt(6));
				item.setMinPrice(resultSet.getInt(7));
				item.setLocality(resultSet.getString(8));
				item.setCity(resultSet.getString(9));
				item.setArea(resultSet.getString(10));
				item.setDate(resultSet.getDate(11));
			itemList.add(item);
			}while(resultSet.next());
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		DBUtility.close(resultSet,preparedStatement);
	}
	return itemList;
	}

	
	public int delete(int itemId ){
		final String QUERY = "update item set sold='"+"Yes"+"' where id=?";
		int status=0;
		try(Connection connection = DBUtility.getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, itemId);
			status = preparedStatement.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status; 
	}
	
	
	public List<Item> getAllItemsByUserId(int userId){ 
		final String QUERY = "select * from item where user_id=? and sold="+"No"+"";
		ResultSet resultSet = null; 
		PreparedStatement preparedStatement = null;
		Item item = new Item();
		List<Item> itemList = new ArrayList<Item>();
		try(Connection connection = DBUtility.getConnection()){
		preparedStatement = connection.prepareStatement(QUERY);
		preparedStatement.setInt(1, userId);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			do{
				item.setId(resultSet.getInt(1));
				item.setDescription(resultSet.getString(2));
				item.setOldMonths(resultSet.getInt(3));
				item.setPrice(resultSet.getInt(4));
				item.setSold(resultSet.getString(5));
				item.setMaxPrice(resultSet.getInt(6));
				item.setMinPrice(resultSet.getInt(7));
				item.setLocality(resultSet.getString(8));
				item.setCity(resultSet.getString(9));
				item.setArea(resultSet.getString(10));
				item.setDate(resultSet.getDate(11));
			itemList.add(item);
			}while(resultSet.next());
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		DBUtility.close(resultSet,preparedStatement);
	}
	return itemList;
	}	
	
	
	public List<Item> getAllItemsBySubCategoryId(int subcategoryId){ 
		final String QUERY = "select * from item where sub_category_id=? and sold="+"No"+"";
		ResultSet resultSet = null; 
		PreparedStatement preparedStatement = null;
		Item item = new Item();
		List<Item> itemList = new ArrayList<Item>();
		try(Connection connection = DBUtility.getConnection()){
		preparedStatement = connection.prepareStatement(QUERY);
		preparedStatement.setInt(1, subcategoryId);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			do{
				item.setId(resultSet.getInt(1));
				item.setDescription(resultSet.getString(2));
				item.setOldMonths(resultSet.getInt(3));
				item.setPrice(resultSet.getInt(4));
				item.setSold(resultSet.getString(5));
				item.setMaxPrice(resultSet.getInt(6));
				item.setMinPrice(resultSet.getInt(7));
				item.setLocality(resultSet.getString(8));
				item.setCity(resultSet.getString(9));
				item.setArea(resultSet.getString(10));
				item.setDate(resultSet.getDate(11));
			itemList.add(item);
			}while(resultSet.next());
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		DBUtility.close(resultSet,preparedStatement);
	}
	return itemList;
	}	
	
	
	public List<Item> getNotApprovedItems(){
		final String QUERY = "select * from item where approved_id='"+null+"'";
		ResultSet resultSet = null; 
		PreparedStatement preparedStatement = null;
		List<Item> itemList = null;
		try(Connection connection = DBUtility.getConnection()){
		preparedStatement = connection.prepareStatement(QUERY);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			itemList = new ArrayList<Item>();
			do{
				Item item = new Item();
				item.setId(resultSet.getInt(1));
				item.setDescription(resultSet.getString(2));
				item.setOldMonths(resultSet.getInt(3));
				item.setPrice(resultSet.getInt(4));
				item.setSold(resultSet.getString(5));
				item.setMaxPrice(resultSet.getInt(6));
				item.setMinPrice(resultSet.getInt(7));
				item.setLocality(resultSet.getString(8));
				item.setCity(resultSet.getString(9));
				item.setArea(resultSet.getString(10));
				item.setDate(resultSet.getDate(11));
			itemList.add(item);
			}while(resultSet.next());
		}
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		DBUtility.close(resultSet,preparedStatement);
	}
	return itemList;
	}
	
	
	public List<Item> getApprovedItems(){
		final String QUERY = "select * from item where approved_id <> '"+null+"'";
		ResultSet resultSet = null; 
		PreparedStatement preparedStatement = null;
		List<Item> itemList = null;
		try(Connection connection = DBUtility.getConnection()){
		preparedStatement = connection.prepareStatement(QUERY);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			itemList = new ArrayList<Item>();
			do{
				Item item = new Item();
				item.setId(resultSet.getInt(1));
				item.setDescription(resultSet.getString(2));
				item.setOldMonths(resultSet.getInt(3));
				item.setPrice(resultSet.getInt(4));
				item.setSold(resultSet.getString(5));
				item.setMaxPrice(resultSet.getInt(6));
				item.setMinPrice(resultSet.getInt(7));
				item.setLocality(resultSet.getString(8));
				item.setCity(resultSet.getString(9));
				item.setArea(resultSet.getString(10));
				item.setDate(resultSet.getDate(11));
			itemList.add(item);
			}while(resultSet.next());
		}
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		DBUtility.close(resultSet,preparedStatement);
	}
	return itemList;
	}
	
	
	public int approveItem(int itemId){
		final String QUERY="update item set approved_id=? where id=?";
		int status=0;
		Moderator moderator = new Moderator();
		try(Connection connection =DBUtility.getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1,moderator.getId());
			preparedStatement.setInt(2,itemId);
			status = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return status; 
	}
	
	public int insertImage(int itemId,List<String> image){
		final String QUERY = "insert into item_image(image) values(?)";
		int status=0;
		Item item =new Item();
		try(Connection connection = DBUtility.getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1,item.getImage());

			status = preparedStatement.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public Item getImageById(int itemId){
		final String QUERY = "select * from item where id=? and sold='"+"No"+"'";
		ResultSet resultSet = null; 
		PreparedStatement preparedStatement = null;
		Item item = new Item();
		try(Connection connection = DBUtility.getConnection()){
		preparedStatement = connection.prepareStatement(QUERY);
		preparedStatement.setInt(1,itemId);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			item.setId(resultSet.getInt(1));
			item.setImage(item.getImage());
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		DBUtility.close(resultSet,preparedStatement);
	}
	return item;
	}
	
	
	//public 
	public static void main(String args[]){
		ItemDAO userdao = new ItemDAO();
		 //Item user = new Item();
		 //user = userdao.getItemById(1);
		 System.out.println(userdao.getAllItems());
		}
}
