package vo;

import java.util.Date;

import vo.CreditRecordVO;
import vo.HotelVO;
import vo.PersonalInfoVO;

public class UnexecutedOrderVO {
	public  PersonalInfoVO personalInfo;
	public  String orderID;
	public  String generateTime;
	public  String cancelledTime;
	public  String execuedDDL;
	public  double price;
//	Date createDate;
//	Date cancelDate;
	HotelVO hotelInfo;
	CreditRecordVO creditRecord;
	String state;
	Date checkDate;
	Date checkoutDate;
	int number;
	boolean hasChild;
	String contactInfo;
	String creditExplanation;
//	Date executeDeadline;
//	int price;
	
	public UnexecutedOrderVO(String id)
	{
		this.orderID = id;
	}
	
	public UnexecutedOrderVO(String orderID, String generateTime, String cancelledTime, String executedDDL, double price)
	{
		this.orderID = orderID;
		this.generateTime = generateTime;
		this.cancelledTime = cancelledTime;
		this.execuedDDL = executedDDL;
		this.price = price;
	}
//	public OrderVO(PersonalInfoVO pI,String i,Date cD,Date caD,HotelVO hI,
//			CreditRecordVO cR,String s,
//			Date chD,Date coD,int num,boolean hC,String cI,
//			String cE,Date eD,int p){
//		personalInfo=pI;
//		id=i;
//		createDate=cD;
//		cancelDate=caD;
//		hotelInfo=hI;
//		creditRecord=cR;
//		state=s;
//		checkDate=cD;
//		checkoutDate=coD;
//		number=num;
//		hasChild=hC;
//		contactInfo=cI;
//		creditExplanation=cE;
//		executeDeadline=eD;
//		price=p;
//		
//	}


	public PersonalInfoVO getPersonalInfo() {
		return personalInfo;
	}


	public void setPersonalInfo(PersonalInfoVO personalInfo) {
		this.personalInfo = personalInfo;
	}


	public HotelVO getHotelInfo() {
		return hotelInfo;
	}


	public void setHotelInfo(HotelVO hotelInfo) {
		this.hotelInfo = hotelInfo;
	}


	public CreditRecordVO getCreditRecord() {
		return creditRecord;
	}


	public void setCreditRecord(CreditRecordVO creditRecord) {
		this.creditRecord = creditRecord;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public Date getCheckDate() {
		return checkDate;
	}


	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}


	public Date getCheckoutDate() {
		return checkoutDate;
	}


	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public boolean isHasChild() {
		return hasChild;
	}


	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}


	public String getContactInfo() {
		return contactInfo;
	}


	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}


	public String getCreditExplanation() {
		return creditExplanation;
	}


	public void setCreditExplanation(String creditExplanation) {
		this.creditExplanation = creditExplanation;
	}



	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
