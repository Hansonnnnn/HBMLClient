package businesslogic.orderbl;

import java.util.Date;

import PO.HotelPO;
import PO.OrderPO;
import businesslogicservice.orderblservice.CustomerService;

public class CustomerServiceImpl implements CustomerService
{
	String getPersonalInfo()
	{
		
	}
	
	void setPersonalInfo(String personInfo);
	String getID();
	void setID(String ID);
	Date getCreateDate();
	void setCreateDate(Date date);
	Date getCancelDate();
	void setCancelDate(Date date);
	HotelInfo getHotelInfo();
	Void setHotelInfo(HotelInfo hotelInfo);
	Enum getState();
	Void setState(Enum orderState);
	Void setNumberOfGuest();
	Boolean getHasChildOrNot();
	Void setHasChildOrNot();
	String getContactInfo();
	Void setContactInfo(String contactInfo);
	String getCreditChangeExplanation();
	Void setCreditChangeExplanation(String explanation);
	Date getExexuteDeadline();
	Void setExecuteDeadline(Date date);
	Int getPrice();//----->应该只出现在order里面
	Int calculatePrice();
	Void setPrice();
	void updateOrderPO(OrderPO po);
	@Override
	public HotelPO getHotelInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setHotelInfo(HotelPO hotelInfo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setState(Enum orderState) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setNumberOfGuest() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setHasChildOrNot() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setContactInfo(String contactInfo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setCreditChangeExplanation(String explanation) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setExecuteDeadline(Date date) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int calculatePrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setPrice() {
		// TODO Auto-generated method stub
		
	}
}
