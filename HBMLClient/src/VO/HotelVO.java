package VO;

import java.awt.Image;
import java.util.List;

import VO.CommentInfoVO;
import VO.OrderVO;
import VO.RoomInfoVO;
import VO.StaffAccountVO;

public class HotelVO {
	String name;
	String id;
	int star;
	String address;
	String region;
	String introduction;
	String facility;
	Image environment;
	CommentInfoVO commentInfo;
	RoomInfoVO roomInfo;
	List<OrderVO> historyOrder;
	StaffAccountVO staffAccount;
	
	public HotelVO() {
		// TODO Auto-generated constructor stub
	}
	public HotelVO(String n,String i,int s,String a,
			String r,String in,String f,Image e,
			RoomInfoVO rI,List<OrderVO> hO,StaffAccountVO sA){
		name=n;
		id=i;
		star=s;
		address=a;
		region=r;
		introduction=in;
		facility=f;
		environment=e;
		roomInfo=rI;
		historyOrder=hO;
		staffAccount=sA;
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

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public Image getEnvironment() {
		return environment;
	}

	public void setEnvironment(Image environment) {
		this.environment = environment;
	}

	public CommentInfoVO getCommentInfo() {
		return commentInfo;
	}

	public void setCommentInfo(CommentInfoVO commentInfo) {
		this.commentInfo = commentInfo;
	}

	public RoomInfoVO getRoomInfo() {
		return roomInfo;
	}

	public void setRoomInfo(RoomInfoVO roomInfo) {
		this.roomInfo = roomInfo;
	}

	public List<OrderVO> getHistoryOrder() {
		return historyOrder;
	}

	public void setHistoryOrder(List<OrderVO> historyOrder) {
		this.historyOrder = historyOrder;
	}

	public StaffAccountVO getStaffAccount() {
		return staffAccount;
	}

	public void setStaffAccount(StaffAccountVO staffAccount) {
		this.staffAccount = staffAccount;
	}

}
