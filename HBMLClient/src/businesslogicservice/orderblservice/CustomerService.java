package businesslogicservice.orderblservice;

import java.util.Date;

import po.HotelPO;
import po.OrderPO;

public interface CustomerService {
	public String getPersonalInfo();
	public void setPersonalInfo(String personInfo);
	public String getID();
	public void setID(String ID);
	public Date getCreateDate();
	public void setCreateDate(Date date);
	public Date getCancelDate();
	public void setCancelDate(Date date);
	public HotelPO getHotelInfo();
	public void setHotelInfo(HotelPO hotelInfo);
	public Enum getState();
	public void setState(Enum orderState);
	public void setNumberOfGuest();
	public boolean getHasChildOrNot();
	public void setHasChildOrNot();
	public String getContactInfo();
	public void setContactInfo(String contactInfo);
	public String getCreditChangeExplanation();
	public void setCreditChangeExplanation(String explanation);
	public Date getExexuteDeadline();
	public void setExecuteDeadline(Date date);
	public int getPrice();//----->应该只出现在order里面
	public int calculatePrice();
	public void setPrice();
	public void updateOrderPO(OrderPO po);
}
