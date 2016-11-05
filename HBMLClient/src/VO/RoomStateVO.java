package VO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import VO.RoomInfoVO;

public class RoomStateVO implements Serializable{
	RoomInfoVO roomInfo;
	int price;
	String number;
	String type;
	List<Date> detailedInfo;
	
	public RoomStateVO(RoomInfoVO rI,int p,String n,String t
			,List<Date> dI){
		roomInfo=rI;
		price=p;
		number=n;
		type=t;
		detailedInfo=dI;
	}

	public RoomInfoVO getRoomInfo() {
		return roomInfo;
	}

	public void setRoomInfo(RoomInfoVO roomInfo) {
		this.roomInfo = roomInfo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Date> getDetailedInfo() {
		return detailedInfo;
	}

	public void setDetailedInfo(List<Date> detailedInfo) {
		this.detailedInfo = detailedInfo;
	}

}
