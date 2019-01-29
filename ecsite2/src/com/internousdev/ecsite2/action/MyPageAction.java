package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.MyPageDAO;
import com.internousdev.ecsite2.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;


public class MyPageAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private MyPageDAO myPageDAO = new MyPageDAO();
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;
	private String myPass;

	private ArrayList<String> myUserInfoList = new ArrayList<String>();

	public String execute() throws SQLException{
		if(!session.containsKey("login_user_id")){
			return ERROR;
		}
		if(deleteFlg == null){
			String user_master_id = session.get("login_user_id").toString();

			myPageList = myPageDAO.getMyPageUserInfo(user_master_id);

			myUserInfoList = myPageDAO.getMyUserInfo(user_master_id);
			myPass = myUserInfoList.get(2);
			session.put("myPass",myPass);

		}else if(deleteFlg.equals("1")){
			delete();


			String user_master_id = session.get("login_user_id").toString();
			myUserInfoList = myPageDAO.getMyUserInfo(user_master_id);
			myPass = myUserInfoList.get(2);
			session.put("myPass",myPass);
			}
		String result =SUCCESS;
		return result;

	}



	public void delete() throws SQLException{
		String user_master_id = session.get("login_user_id").toString();

		int res = myPageDAO.buyItemHistoryDelete(user_master_id);

		if(res > 0){
			myPageList = null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res == 0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;

	}

	public ArrayList<String> getMyUserInfoList() {
		return myUserInfoList;
	}

	public void setMyUserInfoList(ArrayList<String> myUserInfoList) {
		this.myUserInfoList = myUserInfoList;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public ArrayList<MyPageDTO> getMyPageList(){
		return this.myPageList;
	}

	public String getMessage(){
		return this.message;
	}

	public void setMessage(String message){
		this.message = message;
	}


}
