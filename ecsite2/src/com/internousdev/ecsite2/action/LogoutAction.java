package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {
	private String errorMessage;

	public Map<String,Object> session;

	public String execute(){
		session.clear();

		setErrorMessage("ログアウトしました");
		return SUCCESS;
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

	}

