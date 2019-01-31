package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware{

	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String itemInfo;
	public Map<String,Object> session;
	private ItemCreateCompleteDAO itemCreateCompleteDAO = new ItemCreateCompleteDAO();

	public String execute() throws SQLException{
		itemCreateCompleteDAO.createItem(
				session.get("itemName").toString(),
				session.get("itemPrice").toString(),
				session.get("itemStock").toString(),
				session.get("itemInfo").toString());

		String result = SUCCESS;

		return result ;
	}
	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	public String getitemPrice(){
		return itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice = itemPrice;
	}
	public String getStock(){
		return itemStock;
	}
	public void setItemStock(String itemStock){
		this.itemStock = itemStock;
	}
	public String getItemInfo() {
		return itemInfo;
	}
	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
