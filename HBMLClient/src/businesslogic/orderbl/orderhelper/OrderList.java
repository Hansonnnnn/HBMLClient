package businesslogic.orderbl.orderhelper;

import java.util.HashMap;
import java.util.Map;

import businesslogic.orderbl.Order;

public class OrderList {
	public Map<String, Order> orderList;
	
	public OrderList()
	{
		orderList = new HashMap<String, Order>();
	}
	
	public void addItem(Order newOrder)
	{
		orderList.put(newOrder.getId(), newOrder);
	}
	
	
}
