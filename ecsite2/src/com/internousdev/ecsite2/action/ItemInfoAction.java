package com.internousdev.ecsite2.action;

import com.internousdev.ecsite2.dao.ItemInfoDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemInfoAction extends ActionSupport {


	private String id;
	private BuyItemDTO buyItemDTO = new BuyItemDTO();


	public String execute(){
		ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
		buyItemDTO = itemInfoDAO.getItemInfo(id);

		System.out.println(buyItemDTO.getItemName());
		System.out.println(buyItemDTO.getItemPrice());
		System.out.println(buyItemDTO.getItemStock());

		return SUCCESS;
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
}