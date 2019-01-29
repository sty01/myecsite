package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.ItemInfoDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;
public class ItemUpdateAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;

	private String id;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String itemInfo;

	private BuyItemDTO buyItemDTO = new BuyItemDTO();

	public String execute(){
		ItemInfoDAO itemInfoDAO =new ItemInfoDAO();
		buyItemDTO = itemInfoDAO.getItemInfo(id);

		this.itemName=buyItemDTO.getItemName();
		this.itemPrice=buyItemDTO.getItemPrice();
		this.itemStock=buyItemDTO.getItemStock();
		this.itemInfo=buyItemDTO.getItemInfo();

		System.out.println(buyItemDTO.getItemName());
		System.out.println(buyItemDTO.getItemPrice());
		System.out.println(buyItemDTO.getItemStock());
		System.out.println(buyItemDTO.getItemInfo());

		return SUCCESS;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BuyItemDTO getBuyItemDTO() {
		return buyItemDTO;
	}
	public void setBuyItemDTO(BuyItemDTO buyItemDTO) {
		this.buyItemDTO = buyItemDTO;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemStock() {
		return itemStock;
	}
	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}
	public String getItemInfo() {
		return itemInfo;
	}
	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}
}

