package VO;

import java.io.Serializable;
import java.util.List;

import VO.WebManagerVO;

public class WebManagerAccountVO implements Serializable{
	String account;
	String password;
	List<WebManagerVO> webManagerList;
	
	public WebManagerAccountVO(String a,String p,List<WebManagerVO> wM
			){
		account=a;
		password=p;
		webManagerList=wM;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<WebManagerVO> getWebManagerList() {
		return webManagerList;
	}

	public void setWebManagerList(List<WebManagerVO> webManagerList) {
		this.webManagerList = webManagerList;
	}
}
