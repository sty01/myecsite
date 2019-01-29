package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class ItemInfoDAO{
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public BuyItemDTO getItemInfo(String id){
		String sql = "SELECT * FROM item_info_transaction WHERE id=?";
		BuyItemDTO buyItemDTO = new BuyItemDTO();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(id));

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){

				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
				buyItemDTO.setItemStock(resultSet.getString("item_stock"));
				buyItemDTO.setItemInfo(resultSet.getString("item_info"));

			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemDTO;
	}
	}


