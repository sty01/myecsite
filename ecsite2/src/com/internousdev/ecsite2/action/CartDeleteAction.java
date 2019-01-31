package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.CartDeleteDAO;
import com.internousdev.ecsite2.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartDeleteAction extends ActionSupport implements SessionAware{

	private String message;
	private Map<String,Object> session ;
	private String umi ;
	private List<ItemInfoDTO> cartList = new ArrayList<ItemInfoDTO>();

	public String execute() throws SQLException {
		String result = ERROR;
		umi = session.get("login_user_id").toString();
		CartDeleteDAO cartDeleteDAO = new CartDeleteDAO();

		int res = cartDeleteDAO.deleteCart(umi);
		cartList.clear();

		if (res > 0) {
			setMessage("カート情報を正しく削除しました。");
		} else {
			setMessage("カート情報の削除に失敗しました。");
		}
		result = SUCCESS;
		return result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public List<ItemInfoDTO> getCartList() {
		return cartList;
	}
	public void setCartList(List<ItemInfoDTO> cartList) {
		this.cartList = cartList;
	}
}