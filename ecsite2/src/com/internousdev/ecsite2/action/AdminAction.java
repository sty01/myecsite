package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;
	private String errorMessage;


	public String execute(){
		String result = SUCCESS;
		if(!session.containsKey("login_user_id")){
			result = ERROR;
			return result;
		}else if(!(((LoginDTO)session.get("loginUser")).getAdminFlg().equals("1"))){
		 result = ERROR;
		}
		return result;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}
}
