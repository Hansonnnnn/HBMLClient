package vo;

import java.util.Date;
import message.AppealStateMessage;
import model.DateHelper;
;

public class AppealVO {
	private DateHelper dateHelper=new DateHelper();

	int appealID;
	int orderID;
	int userID;
	int webMarketerID;
	Date appealTime;
	String appealTimeString;
	String content;
	AppealStateMessage appealState;


	public AppealVO(int appealID, int orderID, int userID, int webMarketerID, Date appealTime, String content,
					AppealStateMessage appealState) {
		super();
		this.appealID = appealID;
		this.orderID = orderID;
		this.userID = userID;
		this.webMarketerID = webMarketerID;
		this.appealTime = appealTime;
		this.content = content;
		this.appealState = appealState;
		appealTimeString=dateHelper.dateToString(appealTime);
	}


	public int getAppealID() {
		return appealID;
	}


	public void setAppealID(int appealID) {
		this.appealID = appealID;
	}


	public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public int getWebMarketerID() {
		return webMarketerID;
	}


	public void setWebMarketerID(int webMarketerID) {
		this.webMarketerID = webMarketerID;
	}


	public Date getAppealTime() {
		return appealTime;
	}


	public void setAppealTime(Date appealTime) {
		this.appealTime = appealTime;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public AppealStateMessage getAppealState() {
		return appealState;
	}


	public void setAppealState(AppealStateMessage appealState) {
		this.appealState = appealState;
	}

	public String getAppealTimeString() {
		return appealTimeString;
	}

	public void setAppealTimeString(String appealTimeString) {
		this.appealTimeString = appealTimeString;
	}
	@Override
	public String toString() {
		return "AppealPO [appealID=" + appealID + ", orderID=" + orderID + ", userID=" + userID + ", webMarketerID="
				+ webMarketerID + ", appealTime=" + appealTime + ", content=" + content + ", appealState=" + appealState
				+ "]";
	}
	
	
}
