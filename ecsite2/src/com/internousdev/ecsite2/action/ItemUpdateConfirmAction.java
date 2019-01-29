package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.ItemInfoDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemUpdateConfirmAction extends ActionSupport implements SessionAware {

	private String id;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String itemInfo;
	public Map<String,Object> session;
	private String errorMessage;
	ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
	BuyItemDTO buyItemDTO = new BuyItemDTO();

	public String execute(){
		String result = SUCCESS;

		BuyItemDTO buyItemDTO = itemInfoDAO.getItemInfo(id);

		if(!(itemName.equals(""))){
			session.put("itemName",itemName);

		}else{
			session.put("itemName",buyItemDTO.getItemName());
		}
		if( !(itemPrice.equals(""))){
			session.put("itemPrice", itemPrice);
		}else{
			session.put("itemPrice",buyItemDTO.getItemPrice());

		}
		if( !(itemStock.equals(""))){
			session.put("itemStock", itemStock);
		}else{
			session.put("itemStock",buyItemDTO.getItemStock());

		}
		if( !(itemInfo.equals(""))){
			session.put("itemInfo", itemInfo);
		}else{
			session.put("itemInfo",buyItemDTO.getItemInfo());
		}

		if(!(itemPrice.matches("\\d*")) || !(itemStock.matches("\\d*"))){
			setErrorMessage("値段または在庫に数字以外が入力されています");
			result = ERROR;
		}
		System.out.println(session.get("itemName"));
		System.out.println(session.get("itemPrice"));
		System.out.println(session.get("itemStock"));
		System.out.println(session.get("itemInfo"));

		return result;
	}

	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	public String getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice = itemPrice;

	}
	public String getItemStock(){
		return itemStock;
	}
	public void setItemStock(String itemStock){
		this.itemStock = itemStock;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}
}

