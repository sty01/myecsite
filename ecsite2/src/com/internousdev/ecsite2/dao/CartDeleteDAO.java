package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;

public class CartDeleteDAO {

	public int deleteCart(String userMasterId) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "DELETE FROM cart WHERE user_master_id = ?";
		PreparedStatement ps;

		int result =0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, userMasterId);
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return result;
	}

}
