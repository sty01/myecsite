package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.ItemInfoDTO;
import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;


public class CartDAO {

	private List<ItemInfoDTO> cartList = new ArrayList<ItemInfoDTO>();


	private DateUtil dateUtil = new DateUtil();
	private String sql = "INSERT INTO cart (item_id,item_count,user_master_id,subtotal,pay,insert_date) VALUES(?,?,?,?,?,?)";
	private String sql2 = "select cart.cart_id as cart_id,cart.item_id as item_id, cart.item_count  as item_count,cart.subtotal as subtotal, cart.pay as pay, cart.insert_date as insert_date, item_info_transaction.item_name as item_name,item_info_transaction.item_price as item_price FROM cart LEFT JOIN item_info_transaction ON item_info_transaction.id = cart.item_id WHERE user_master_id=?";

	public void execute(int item_id,int item_count,String user_master_id,int subtotal,String pay) throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();


		try{

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, item_id);
			preparedStatement.setInt(2, item_count);
			preparedStatement.setString(3, user_master_id);
			preparedStatement.setInt(4, subtotal);
			preparedStatement.setString(5, pay);
			preparedStatement.setString(6, dateUtil.getDate());

			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}

	public List<ItemInfoDTO> getCart(String user_master_id) throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setString(1, user_master_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){

				ItemInfoDTO dto = new ItemInfoDTO();
				dto.setCartId(resultSet.getString("cart_id"));
				dto.setId(resultSet.getString("item_id"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemCount(resultSet.getString("item_count"));
				dto.setSubtotal(resultSet.getString("subtotal"));
				dto.setPay(resultSet.getString("pay"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				dto.setItemName(resultSet.getString("item_name"));

				cartList.add(dto);

				System.out.println(cartList.get(0).getId());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return cartList;
	}

	private String sql3 = "SELECT item_count FROM cart WHERE user_master_id=? AND item_id=?";
	public int getCartItemCount(String user_master_id,int id) throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int totalCount = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql3);
			preparedStatement.setString(1, user_master_id);
			preparedStatement.setInt(2, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				int itemCount = 0;
				itemCount = resultSet.getInt("item_count");

				totalCount += itemCount;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}

		System.out.println("DAO:"+totalCount);
		return totalCount;
	}
}

