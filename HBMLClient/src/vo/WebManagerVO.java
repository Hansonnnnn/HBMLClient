package vo;

import java.io.Serializable;

public class WebManagerVO implements Serializable{
	String name;
		String id;
		String contactInfo;
		public WebManagerVO(String n,String i,String cI){
			name=n;
			id=i;
			contactInfo=cI;
		}
		public WebManagerVO(String n){
			name=n;
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
