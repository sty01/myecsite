package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.CartDAO;
import com.internousdev.ecsite2.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -7787951498734562406L;
	private List<ItemInfoDTO> cartList= new ArrayList<ItemInfoDTO>();
	private String selectedRow;
	private String pay;//支払い方法
	private Collection<String> checkList;
	private String count;//	アイテム購入個数
	private String itemPrice;
	private String itemStock;
	private String id;
	int totalPrice = 0;

	private String errorMessage;
	private String Message;
	public Map<String,Object> session;

	public String execute() throws SQLException{
		String result = "login";
		if(session.containsKey("login_user_id")){
			result = ERROR;
			String userMasterId = session.get("login_user_id").toString();

			String[] countList=count.split(", ",0);
			String[] itemPriceList=itemPrice.split(", ",0);
			String[] idList=id.split(", ",0);
			String[] itemStockList=itemStock.split(", ",0);
			String[] selectedRowList=selectedRow.split(", ",0);

			CartDAO cartDAO = new CartDAO();
			if(checkList==null){
				setErrorMessage("商品が選択されていません。");
				result = ERROR;
				return result;
			}

			for(String s:selectedRowList){
				if(countList[Integer.parseInt(s)].equals("選択してください")){
					setErrorMessage("購入個数を選択してください");
					result=ERROR;
					return result;
				}
			}

			for(String s:selectedRowList){
				if(Integer.parseInt(countList[Integer.parseInt(s)])+cartDAO.getCartItemCount(userMasterId,Integer.parseInt(idList[Integer.parseInt(s)]))
				>(Integer.parseInt(itemStockList[Integer.parseInt(s)]))){
					setErrorMessage("在庫数を超えて購入しようとしている商品があります。");
					result=ERROR;
					return result;
				}
			}

			int i = 0;

			for(String check : checkList){
				int intSelectedRow = Integer.parseInt(selectedRowList[i]);
				int price = Integer.parseInt(itemPriceList[intSelectedRow]);
				System.out.println(intSelectedRow +"値段"+price);
				int count = Integer.parseInt(countList[intSelectedRow]);
				System.out.println(intSelectedRow +"個数"+count);
				int subtotal = price * count;

				cartDAO.execute(Integer.parseInt(check),count,userMasterId,subtotal,pay);
				System.out.println(":::::::::::*"+check);
				i++;
			}
			cartList = cartDAO.getCart(userMasterId);
			for(ItemInfoDTO dto : cartList){
				totalPrice += Integer.parseInt(dto.getSubtotal());

			}
			setMessage(i+"点の商品がカートに追加されました");
			result=SUCCESS;
		}
		return result;
	}

	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public List<ItemInfoDTO> getCartList() {
		return cartList;
	}
	public void setCartList(List<ItemInfoDTO> cartList) {
		this.cartList = cartList;
	}
	public Collection<String> getCheckList() {
		return checkList;
	}
	public void setCheckList(Collection<String> checkList) {
		this.checkList = checkList;
	}
	public String getSelectedRow() {
		return selectedRow;
	}
	public void setSelectedRow(String selectedRow) {
		this.selectedRow = selectedRow;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getItemStock() {
		return itemStock;
	}

	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
}
