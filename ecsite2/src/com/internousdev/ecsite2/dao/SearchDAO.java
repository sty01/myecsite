package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class SearchDAO{

	private List<BuyItemDTO> searchResultList = new ArrayList<BuyItemDTO>();

	public List<BuyItemDTO> getSearchResult(String searchWord) throws SQLException{
		 DBConnector dbConnector = new DBConnector();
		 Connection con = dbConnector.getConnection();

		String sql = "SELECT * FROM item_info_transaction WHERE item_name LIKE ? OR item_info LIKE ?";
		try{
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, "%"+searchWord+"%");
			preparedStatement.setString(2, "%"+searchWord+"%");

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				BuyItemDTO buyItemDTO = new BuyItemDTO();
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
				buyItemDTO.setItemStock(resultSet.getString("item_stock"));

				searchResultList.add(buyItemDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return searchResultList;
	}

	}


