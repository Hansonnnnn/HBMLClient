package po;

import java.awt.Image;
import java.io.Serializable;

public class PersonalInfoPO implements Serializable{
	String name;
	String contactInfo;
	Image portrait;
	public PersonalInfoPO(String name,String contact,Image image){
		this.name=name;
		this.contactInfo=contact;
		this.portrait=image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public Image getPortrait() {
		return portrait;
	}
	public void setPortrait(Image portrait) {
		this.portrait = portrait;
	}
	
}
