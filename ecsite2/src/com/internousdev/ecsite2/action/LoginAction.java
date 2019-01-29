package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.LoginDAO;
import com.internousdev.ecsite2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	public Map<String,Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private String errorMessage;


	public String execute(){
		String result = ERROR;

		loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser",loginDTO);

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);
			session.put("loginUser",loginDTO);
			session.put("login_user_id",loginDTO.getLoginId());

			setErrorMessage("ログインしました");

			//		}else if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			//			result = SUCCESS;
			//			session.put("login_user_id",loginDTO.getLoginId());
			//
			//			BuyItemDAO buyItemDAO = new BuyItemDAO();
			//

			//			List<BuyItemDTO> buyItemDTOList = buyItemDAO.getBuyItemInfo();
			//			session.put("buyItemDTOList", buyItemDTOList);

			if(loginDTO.getAdminFlg().equals("1")){
				result = "admin";
			}
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
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}

