package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.ChangePasswordCompleteDAO;
import com.internousdev.ecsite2.dao.LoginDAO;
import com.internousdev.ecsite2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordCompleteAction extends ActionSupport implements SessionAware{

	private String newPass1;

	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();

	public Map<String,Object> session;
	private ChangePasswordCompleteDAO changePasswordCompleteDAO = new ChangePasswordCompleteDAO();

	public String execute() throws SQLException{

		changePasswordCompleteDAO.updatePass(newPass1,session.get("login_user_id").toString());

		loginDTO = loginDAO.getLoginUserInfo(session.get("login_user_id").toString(),newPass1);
		session.put("loginUser",loginDTO);

		String result = SUCCESS;

		return result ;
	}

	public String getNewPass1() {
		return newPass1;
	}

	public void setNewPass1(String newPass1) {
		this.newPass1 = newPass1;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
