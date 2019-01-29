package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dto.MyPageDTO;
import com.internousdev.ecsite2.util.DBConnector;


public class MyPageDAO {
	public ArrayList<MyPageDTO> getMyPageUserInfo(String user_master_id)throws SQLException{

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();
		String sql=
				"SELECT ubit.id,iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.user_master_id = ? ORDER BY insert_date DESC";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_master_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){

				MyPageDTO dto = new MyPageDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setTotalPrice(resultSet.getString("total_price"));
				dto.setTotalCount(resultSet.getString("total_count"));
				dto.setPayment(resultSet.getString("pay"));
				dto.setInsert_date(resultSet.getString("insert_date"));

				myPageDTO.add(dto);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return myPageDTO;
	}

	public ArrayList<String> getMyUserInfo(String user_master_id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

//		String userName;
//		String loginId;
//		String loginPass;
//		String adminFlg;
//		String insert_date;
//		String updated_date_;

		ArrayList<String> myUserInfoList = new ArrayList<String>();


		String sql=
				"SELECT * FROM login_user_transaction WHERE login_id = ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_master_id);



			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){

				myUserInfoList.add(resultSet.getString("user_name"));
				myUserInfoList.add(resultSet.getString("login_id"));
				myUserInfoList.add(resultSet.getString("login_pass"));
				myUserInfoList.add(resultSet.getString("user_name"));
				myUserInfoList.add(resultSet.getString("admin_flg"));
				myUserInfoList.add(resultSet.getString("insert_date"));
				myUserInfoList.add(resultSet.getString("updated_date_"));



//				userName =resultSet.getString("user_name");
//				loginId = resultSet.getString("login_id");
//				loginPass =resultSet.getString("login_pass");
//				userName =resultSet.getString("user_name");
//				adminFlg =resultSet.getString("admin_flg");
//				insert_date =resultSet.getString("insert_date");
//				updated_date_ = resultSet.getString("updated_date_");


				}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return myUserInfoList;
	}



	public int buyItemHistoryDelete(String user_master_id)throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql =
				"DELETE FROM user_buy_item_transaction WHERE user_master_id = ?";

		int result = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_master_id);
			result = preparedStatement.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result;
	}
}