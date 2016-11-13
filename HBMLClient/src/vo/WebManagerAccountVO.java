package vo;

import java.io.Serializable;
import java.util.List;

public class WebManagerAccountVO implements Serializable{
	String account;
	String password;
	List<UserVO> webManagerList;
	
	public WebManagerAccountVO(String a,String p,List<UserVO> wM
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

	public List<UserVO> getWebManagerList() {
		return webManagerList;
	}

	public void setWebManagerList(List<UserVO> webManagerList) {
		this.webManagerList = webManagerList;
	}
}
