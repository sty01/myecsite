package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;

public class ChangePasswordCompleteDAO {
	private DateUtil dateUtil = new DateUtil();
	private String sql = "UPDATE login_user_transaction SET login_pass=? ,updated_date_=? WHERE login_id=?";
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public void updatePass(String newPass1,String login_user_id) throws SQLException{
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, newPass1);
			preparedStatement.setString(2, dateUtil.getDate());
			preparedStatement.setString(3, login_user_id);

			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}
}

