package com.internousdev.ecsite2.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordAction extends ActionSupport {

	public Map<String,Object> session;
	public String execute(){

		return SUCCESS;
	}
}
