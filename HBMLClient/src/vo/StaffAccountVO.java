package vo;

import java.io.Serializable;
import java.util.List;

public class StaffAccountVO implements Serializable{
	String name;
	String password;
	List<StaffVO> staffList;
	
	public StaffAccountVO(String n,String p,List<StaffVO> sL){
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

	public List<StaffVO> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<StaffVO> staffList) {
		this.staffList = staffList;
	}
	
}
