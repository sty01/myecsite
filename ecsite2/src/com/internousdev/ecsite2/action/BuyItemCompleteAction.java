package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemCompleteDAO;
import com.internousdev.ecsite2.dao.CartDAO;
import com.internousdev.ecsite2.dao.CartDeleteDAO;
import com.internousdev.ecsite2.dao.ItemUpdateCompleteDAO;
import com.internousdev.ecsite2.dto.ItemInfoDTO;
//import com.internousdev.ecsite2.dto.ItemInfoTransactionDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware {

	private String userMasterId;
	private String errorMessage;
	private List<ItemInfoDTO> cartList = new ArrayList<ItemInfoDTO>();

	public Map<String,Object> session;

	public String execute() throws SQLException{
		String result = SUCCESS;
		CartDAO cartDAO = new CartDAO();
		ItemUpdateCompleteDAO itemUpdateCompleteDAO = new ItemUpdateCompleteDAO();

		userMasterId = session.get("login_user_id").toString();
		cartList = cartDAO.getCart(userMasterId);

		BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
		for(ItemInfoDTO dto :cartList){

			String item_transaction_id = dto.getId();
			String total_price =   dto.getSubtotal();
			String total_count = dto.getItemCount();
			String pay = dto.getPay();
			buyItemCompleteDAO.buyItemInfo(item_transaction_id, total_price, total_count, userMasterId, pay);
			itemUpdateCompleteDAO.updateItem(total_count, item_transaction_id); //在庫を減らす
		}
		CartDeleteDAO cartDeleteDAO = new CartDeleteDAO();//カートを空にする
		cartDeleteDAO.deleteCart(userMasterId);

		return result;
	}

	public String getUserMasterId() {
		return userMasterId;
	}
	public void setUserMasterId(String userMasterId) {
		this.userMasterId = userMasterId;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
