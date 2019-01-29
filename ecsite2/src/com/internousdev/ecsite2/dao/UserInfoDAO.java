package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dto.UserInfoDTO;
import com.internousdev.ecsite2.util.DBConnector;


public class UserInfoDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	public ArrayList<UserInfoDTO> getUserList()throws SQLException{
		ArrayList<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();
		String sql=
				"SELECT * FROM login_user_transaction";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){

				UserInfoDTO dto = new UserInfoDTO();

				dto.setId(resultSet.getString("id"));
				dto.setLoginId(resultSet.getString("login_id"));
				dto.setLoginPassword(resultSet.getString("login_pass"));
				dto.setUserName(resultSet.getString("user_name"));
				dto.setUpdate_date(resultSet.getString("updated_date_"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				dto.setAdminFlg(resultSet.getString("admin_flg"));

				userInfoDTOList.add(dto);

			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return userInfoDTOList;
	}
}
