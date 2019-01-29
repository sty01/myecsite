package com.internousdev.ecsite2.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;


public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;

	public String execute(){

		BuyItemDAO buyItemDAO = new BuyItemDAO();
		List<BuyItemDTO> buyItemDTOList = buyItemDAO.getBuyItemInfo();
		session.put("buyItemDTOList", buyItemDTOList);
		String result = SUCCESS;
		//		}

		return result;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
	public Map<String,Object>getSession(){
		return this.session;
	}
}

