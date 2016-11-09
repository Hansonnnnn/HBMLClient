package po;

import java.io.Serializable;

import vo.WebMarketerVO;

public class WebMarketerPO implements Serializable{
	String name;
	String id;
	String contactInfo;
	public WebMarketerPO(String n,String i,String cI){
		name=n;
		id=i;
		contactInfo=cI;
	}

	public WebMarketerPO(String i){
		id=i;
	}
	public WebMarketerPO(){

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	
}
