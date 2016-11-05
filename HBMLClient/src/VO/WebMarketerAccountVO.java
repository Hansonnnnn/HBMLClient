package VO;

import java.io.Serializable;
import java.util.List;

import VO.WebMarketerVO;

public class WebMarketerAccountVO implements Serializable{
	String name;
	String password;
	List<WebMarketerVO> webMarketerList;
	
	
	public WebMarketerAccountVO(String a,String p,List<WebMarketerVO> wM
			){
		name=a;
		password=p;
		webMarketerList=wM;	
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<WebMarketerVO> getWebMarketerList() {
		return webMarketerList;
	}


	public void setWebMarketerList(List<WebMarketerVO> webMarketerList) {
		this.webMarketerList = webMarketerList;
	}
}
