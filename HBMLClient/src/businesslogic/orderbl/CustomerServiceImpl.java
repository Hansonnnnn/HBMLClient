package businesslogic.orderbl;

import java.util.Date;

import businesslogicservice.orderblservice.CustomerService;
import po.HotelPO;
import po.OrderPO;
import vo.HotelVO;

public class CustomerServiceImpl implements CustomerService
{
	Order currentOrder;
	
	public CustomerServiceImpl(Order order)
	{
		this.currentOrder = order;
	}
	
	
	/**
	 * 
	 */
	public String getID()
	{
		return currentOrder.getId();
	}
	
	/**
	 * 
	 */
	public void setID(String ID)
	{
		currentOrder.setId(ID);
	}
	
	/**
	 * 
	 */
	public Date getCreateDate()
	{
		return currentOrder.getCreateDate();
	}
	
	/**
	 * 
	 */
	public void setCreateDate(Date date)
	{
		currentOrder.setCreateDate(date);
	}
	
	/**
	 * 
	 */
	public Date getCancelDate()
	{
		return currentOrder.getCancelDate();
	}
	
	/**
	 * 
	 */
	public void setCancelDate(Date date)
	{
		currentOrder.setCancelDate(date);
	}

	/**
	 * 
	 * @param hotelInfo
	 * @return
	 */
	public void setHotelInfo(HotelVO hotelInfo)
	{
//		currentOrder.setHotelInfo(hotelInfo);
	}
	
	public void setState(String orderState)
	{
		currentOrder.setState(orderState);
	}
	
	public void setNumberOfGuest()
	{
		
	}
	
	public void setHasChildOrNot()
	{
		
	}
	
	public void setContactInfo(String contactInfo)
	{
		
	}
	
	public void setCreditChangeExplanation(String explanation)
	{
		
	}
	
	public void setExecuteDeadline(Date date)
	{
		
	}
	public int getPrice()//----->应该只出现在order里面
	{
		return calculatePrice();
	}
	
	public int calculatePrice()
	{
//		PromotionService promotion = PromotionServiceImpl.getInstance();
		return currentOrder.getPrice();
	}
	
	public void setPrice()
	{
		
	}
	public void updateOrderPO(OrderPO po)
	{
		
	}
//
//
//	@Override
//	public void setHotelInfo(HotelPO hotelInfo) {
//		// TODO Auto-generated method stub
//		
//	}
}
