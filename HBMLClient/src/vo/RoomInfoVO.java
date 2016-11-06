package vo;

import java.io.Serializable;
import java.util.List;

import vo.RoomInfoVO;

public class RoomInfoVO implements Serializable{
	List<RoomInfoVO> roomList;
	String roomType;
	int price;
	public RoomInfoVO() {
		// TODO Auto-generated constructor stub
	}
	
	public RoomInfoVO(List<RoomInfoVO> rL,String rT,int p){
		roomList=rL;
		roomType=rT;
		price=p;
		
	}


	public List<RoomInfoVO> getRoomList() {
		return roomList;
	}


	public void setRoomList(List<RoomInfoVO> roomList) {
		this.roomList = roomList;
	}


	public String getRoomType() {
		return roomType;
	}


	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

}
