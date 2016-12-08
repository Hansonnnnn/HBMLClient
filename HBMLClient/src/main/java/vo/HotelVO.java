package vo;

import java.awt.Image;
import java.util.List;

public class HotelVO {
	private String name;
	private String id;
	private int star;
	private double price;
	private int score;
	private String address;
	private String region;
	private String introduction;
	private String facility;
	private Image environment;
	private CommentInfoVO commentInfo;
	private RoomInfoVO roomInfo;
	private List<OrderVO> historyOrder;
	private StaffAccountVO staffAccount;
	
	public HotelVO() {
		// TODO Auto-generated constructor stub
	}
	
	//界面显示酒店列表时，需要显示的内容
	public HotelVO(String name, String address, int star, double price, int score)
	{
		this.name = name;
		this.address = address;
		this.star = star;
		this.price = price;
		this.score = score;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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
