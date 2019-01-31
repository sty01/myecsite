package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private String adminFlg;
	public Map<String,Object> session;
	private String errorMessage;

	public String execute(){
		String result = SUCCESS;
		if((loginUserId.equals(""))|| (loginPassword.equals(""))|| (userName.equals(""))){
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}else if(!(loginPassword.matches("[a-zA-Z_0-9]{4,16}"))){
				setErrorMessage("パスワードは４文字以上16文字以内の半角英数字でお願いします。");
				result = ERROR;
		}else{

			session.put("loginUserId",loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);
			session.put("adminFlg", adminFlg);
	}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
		}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;

	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getAdminFlg() {
		return adminFlg;
	}

	public void setAdminFlg(String adminFlg) {
		this.adminFlg = adminFlg;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
}


}

