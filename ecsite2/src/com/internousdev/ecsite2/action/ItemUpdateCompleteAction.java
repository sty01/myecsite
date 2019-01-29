package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.ItemUpdateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemUpdateCompleteAction extends ActionSupport implements SessionAware{


	private String id;
	public Map<String,Object> session;
	private ItemUpdateCompleteDAO itemUpdateCompleteDAO = new ItemUpdateCompleteDAO();

	public String execute() throws SQLException{
		itemUpdateCompleteDAO.updateItem(session.get("itemName").toString(),session.get("itemPrice").toString(),session.get("itemStock").toString(),session.get("itemInfo").toString(),id);

		System.out.println(session.get("itemName")+"***");
		System.out.println(session.get("itemPrice")+"***");
		System.out.println(session.get("itemStock")+"***");
		System.out.println(session.get("itemInfo")+"***");
		System.out.println(id+"***");
		String result = SUCCESS;
		return result ;
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
}
