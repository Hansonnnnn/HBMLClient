package businesslogicservice.orderblservice;

import java.util.Date;

import po.HotelPO;
import po.OrderPO;

/**
 * 该类为所有orderbl模块中Customer需要提供的服务
 * @author xiezhenyu
 *
 */
public interface CustomerService {
	public void setID(String ID);
	public void setCreateDate(Date date);
	public void setCancelDate(Date date);
//	public void setHotelInfo(HotelPO hotelInfo);
	public void setState(String orderState);
	public void setNumberOfGuest();
	public void setHasChildOrNot();
	public void setContactInfo(String contactInfo);
	public void setCreditChangeExplanation(String explanation);
	public void setExecuteDeadline(Date date);
	public int getPrice();//----->应该只出现在order里面
	public int calculatePrice();
	public void setPrice();
	public void updateOrderPO(OrderPO po);
}
