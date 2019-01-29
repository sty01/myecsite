package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordConfirmAction extends ActionSupport implements SessionAware {

	private String pass;
	private String newPass1;
	private String newPass2;
//	private String ;

	public Map<String,Object> session;
	private String errorMessage;

	public String execute(){
		String result = SUCCESS;
		if((pass.equals(""))|| (newPass1.equals(""))|| (newPass2.equals(""))){
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}else if(!(pass.equals(((LoginDTO) session.get("loginUser")).getLoginPassword()))){
			setErrorMessage("元のパスワードが違います");
			result = ERROR;
		}else if(!(newPass1.matches("[a-zA-Z_0-9]{4,16}"))){
			setErrorMessage("パスワードは４文字以上16文字以内の半角英数字で設定してください");
			result = ERROR;
		}else if(!(newPass1.equals(newPass2.toString()))){
			setErrorMessage("新しいパスワードと確認用パスワードが一致しません");
			result = ERROR;
		}else if(newPass1.equals(pass.toString())){
			setErrorMessage("元のパスワードと違うパスワードを設定してください");
			result = ERROR;


		}else{

			session.put("newPass1", newPass1);
		}
		return result;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public String getNewPass1() {
		return newPass1;
	}



	public void setNewPass1(String newPass1) {
		this.newPass1 = newPass1;
	}



	public String getNewPass2() {
		return newPass2;
	}



	public void setNewPass2(String newPass2) {
		this.newPass2 = newPass2;
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

