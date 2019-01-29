package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;

public class ItemUpdateCompleteDAO {

	private DateUtil dateUtil = new DateUtil();
	private String sql = "UPDATE item_info_transaction SET item_name=?,item_price=?,item_stock=?,item_info=?,update_date=? WHERE id=?";

	public void updateItem(String itemName,String itemPrice,String itemStock, String itemInfo,String id) throws SQLException{

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, itemName);
			preparedStatement.setInt(2, Integer.parseInt(itemPrice));
			preparedStatement.setInt(3, Integer.parseInt(itemStock));
			preparedStatement.setString(4,itemInfo);
			preparedStatement.setString(5, dateUtil.getDate());
			preparedStatement.setInt(6, Integer.parseInt(id));

			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}

	private String sql2 = "UPDATE item_info_transaction SET item_stock=item_stock-?,update_date=? WHERE id=?";
	public void updateItem(String itemStock,String id) throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql2);

			preparedStatement.setInt(1, Integer.parseInt(itemStock));
			preparedStatement.setString(2, dateUtil.getDate());
			preparedStatement.setInt(3, Integer.parseInt(id));

			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}
}

