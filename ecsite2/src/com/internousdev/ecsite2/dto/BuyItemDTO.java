package com.internousdev.ecsite2.dto;

public class BuyItemDTO implements Comparable<BuyItemDTO>{
	private int id;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String itemTransactionId;
	private String count;
	private String totalPrice;
	private String totalCount;
	private String userMasterId;
	private String pay;
	private String itemInfo;

	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getCount() {
		return count;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public String getUserMasterId() {
		return userMasterId;
	}
	public void setUserMasterId(String userMasterId) {
		this.userMasterId = userMasterId;
	}
	public void setCount(String count) {
		this.count = count;
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
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getItemStock() {
		return itemStock;
	}
	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}
	public String getItemTransactionId() {
		return itemTransactionId;
	}
	public void setItemTransactionId(String itemTransactionId) {
		this.itemTransactionId = itemTransactionId;
	}
	public String getItemInfo() {
		return itemInfo;
	}
	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}
	@Override
	public int compareTo(BuyItemDTO o) {
		return this.id - o.id;
	}

}

