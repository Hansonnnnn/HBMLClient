package vo;

import java.io.Serializable;
import java.util.List;

public class StaffAccountVO implements Serializable{
	String name;
	String password;
	List<UserVO> staffList;
	
	public StaffAccountVO(String n,String p,List<UserVO> sL){
		name=n;
		password=p;
		staffList=sL;
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

	public List<UserVO> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<UserVO> staffList) {
		this.staffList = staffList;
	}
	
}
