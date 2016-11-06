package businesslogicservice.orderblservice;

import java.util.Date;

import po.OrderPO;

public interface StaffService {
	public void setState(String orderState);
	public Date getCheckInDate();
	public String getExpectedLeftTime(String orderID);
	public void setCheckOutDate(Date date);
	public int getNumberOfGuest();
	public void setNumberOfGuest();
	public void getHasChildOrNot();
	public void setPrice();
	public void updateOrderPO(OrderPO po);
	public void showUnexecutedOrder();
	public void showExecutedOrder();
	public void showAbnormalOrder();
	public void showCancelledOrder();
	public void executeOrder();
}
