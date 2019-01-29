package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.CartDAO;
import com.internousdev.ecsite2.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoCartAction extends ActionSupport implements SessionAware {

	private int totalPrice;
	public Map<String,Object> session;
	private String errorMessage;
	private String userMasterId;
	private List<ItemInfoDTO> cartList = new ArrayList<ItemInfoDTO>();

	public String execute(){
		String result = ERROR;
		if(session.containsKey("login_user_id")){
			CartDAO cartDAO = new CartDAO();
			result = SUCCESS;
			userMasterId = session.get("login_user_id").toString();

			try{
				cartList=cartDAO.getCart(userMasterId);
				for(ItemInfoDTO dto : cartList){
					totalPrice += Integer.parseInt(dto.getSubtotal());
				}

			}catch(SQLException e){
				e.printStackTrace();
			}

		}
		return result;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
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

	public String getUserMasterId() {
		return userMasterId;
	}

	public void setUserMasterId(String userMasterId) {
		this.userMasterId = userMasterId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}

