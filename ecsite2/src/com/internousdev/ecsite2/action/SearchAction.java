package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.SearchDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport implements SessionAware{

	private String searchWord;
	private String sw;

	List<BuyItemDTO> searchResultList = new ArrayList<BuyItemDTO>();
	List<BuyItemDTO> resultList = new ArrayList<BuyItemDTO>();
	private String errorMessage;

	public Map<String,Object> session;

	public String execute() throws SQLException{
		sw = searchWord.replaceAll("　"," ").replaceAll("\\s+"," ").trim();
		String result = SUCCESS;
		if(sw.equals("")){
			setErrorMessage("検索ワードが入力されていません");
			session.remove("resultList");
			return result;
		}
		if(sw.contains(" ")){
			String[] sws = sw.split(" ");
			for(String value :sws){
				SearchDAO searchDAO = new SearchDAO();
				searchResultList = searchDAO.getSearchResult(value);

				for(BuyItemDTO x :searchResultList){
					int flg =0;
					for(BuyItemDTO y :resultList){
						if(y.getId() == x.getId()){
							flg ++;
							break;
						}
					}
					if(flg==0){
						resultList.add(x);
					}
				}
			}Collections.sort(resultList);
			session.put("resultList",resultList);
			System.out.println("検索ワード：");
			for(String w : sws){
				System.out.println("・"+w);
			}
		}
		else{
			SearchDAO searchDAO = new SearchDAO();
			resultList = searchDAO.getSearchResult(sw);

			session.put("resultList", resultList);
			System.out.println("検索ワード："+sw);
		}

		System.out.println("ヒット数:"+ resultList.size()  );
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
	public Map<String,Object>getSession(){
		return this.session;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public List<BuyItemDTO> getSearchResultList() {
		return searchResultList;
	}

	public void setSearchResultList(List<BuyItemDTO> searchResultList) {
		this.searchResultList = searchResultList;
	}

	public List<BuyItemDTO> getResultList() {
		return resultList;
	}

	public void setResultList(List<BuyItemDTO> resultList) {
		this.resultList = resultList;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public String getSw() {
		return sw;
	}


	public void setSw(String sw) {
		this.sw = sw;
	}

}
