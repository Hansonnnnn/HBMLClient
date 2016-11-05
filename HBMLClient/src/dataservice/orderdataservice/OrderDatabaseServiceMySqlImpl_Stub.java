package dataservice.orderdataservice;

import PO.OrderPO;
import PO.OrderPO;

public class OrderDatabaseServiceMySqlImpl_Stub implements OrderDataService{
	public OrderDatabaseServiceMySqlImpl_Stub(){}
	public void insert(OrderPO order)
	{
		System.out.println("Insert Succeed!\n");
	}
	public void delete(OrderPO order)
	{
		System.out.println("Delete Succeed!\n");
	}
	public void update(OrderPO order)
	{
		System.out.println("Updata Succeed!\n");
	}
	public OrderPO find(String id)
	{
		System.out.println("Find Succeed!\n");
		OrderPO order = new OrderPO("0000");
		return order;
	}
}
