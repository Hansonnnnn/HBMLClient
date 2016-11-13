package vo;

import java.io.Serializable;
import java.util.List;

public class WebMarketerAccountVO implements Serializable{
	String name;
	String password;
	List<UserVO> webMarketerList;
	
	
	public WebMarketerAccountVO(String a,String p,List<UserVO> wM
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


	public List<UserVO> getWebMarketerList() {
		return webMarketerList;
	}


	public void setWebMarketerList(List<UserVO> webMarketerList) {
		this.webMarketerList = webMarketerList;
	}
}
