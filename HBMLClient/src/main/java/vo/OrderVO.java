package vo;

import java.util.Date;

import message.OrderStateMessage;

public class OrderVO {
	private int orderID;
	private int userID;
	private int hotelID;
	private int roomInfoID;
	private OrderStateMessage orderState;
	
	//最近一次操作事件，生成po时该项为null
	private Date generateTime;
	private Date cancelTime;
	private Date executeDDl;
	private Date checkinTime;
	private Date checkoutTime;
	private int number;
	private int hasChild;
	private int price;
	
	public OrderVO(int orderID, int userID, int hotelID, int roomInfoID, OrderStateMessage orderState,
			Date generateTime, Date cancelTime, Date executeDDl, Date checkinTime, Date checkoutTime, int number,
			int hasChild, int price) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.hotelID = hotelID;
		this.roomInfoID = roomInfoID;
		this.orderState = orderState;
		this.generateTime = generateTime;
		this.cancelTime = cancelTime;
		this.executeDDl = executeDDl;
		this.checkinTime = checkinTime;
		this.checkoutTime = checkoutTime;
		this.number = number;
		this.hasChild = hasChild;
		this.price = price;
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

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public int getRoomInfoID() {
		return roomInfoID;
	}

	public void setRoomInfoID(int roomInfoID) {
		this.roomInfoID = roomInfoID;
	}

	public OrderStateMessage getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderStateMessage orderState) {
		this.orderState = orderState;
	}

	public Date getGenerateTime() {
		return generateTime;
	}

	public void setGenerateTime(Date generateTime) {
		this.generateTime = generateTime;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public Date getExecuteDDl() {
		return executeDDl;
	}

	public void setExecuteDDl(Date executeDDl) {
		this.executeDDl = executeDDl;
	}

	public Date getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(Date checkinTime) {
		this.checkinTime = checkinTime;
	}

	public Date getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(Date checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getHasChild() {
		return hasChild;
	}

	public void setHasChild(int hasChild) {
		this.hasChild = hasChild;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
