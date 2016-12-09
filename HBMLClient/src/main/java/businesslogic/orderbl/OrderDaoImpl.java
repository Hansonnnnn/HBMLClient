package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import dao.OrderDao;
import message.OrderStateMessage;
import message.ResultMessage;
import model.UserType;
import po.AppealPO;
import po.OrderPO;

public class OrderDaoImpl implements OrderDao
{

	@Override
	public Map<Integer, OrderPO> getOrderList(int ID, UserType userType,OrderStateMessage orderState) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, OrderPO> getUnexecutedOrderList(int ID, UserType userType) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, OrderPO> getExecutedOrderList(int ID, UserType userType) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, OrderPO> getCancelledOrderList(int ID, UserType userType) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, OrderPO> getAbnormalOrderList(int ID, UserType userType) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderPO getOrderInfo(int orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage changeOrderState(int orderID, OrderStateMessage orderState) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addOrder(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addAppealOrder(AppealPO appealPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppealPO getAppealOrder(int orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyAppealOrder(AppealPO appealPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}

//	@Override
//	public Map<String, OrderPO> getOrderList(String userID)
//	{
//		// TODO Auto-generated method stub
//		if(userID.equals("0001"))
//		{
//			Map<String, OrderPO> orderList = new HashMap<String, OrderPO>();
//			for(int i = 0; i < orderList.size();i++)
//			{
//				OrderPO orderPO = new OrderPO("0001");//从文件中或者数据库中读出来的orderpo
//				orderList.put("0001", orderPO);
//			}
//			return orderList;
//		}
//		return null;
//	}
//	
//	@Override
//	public ResultMessage addOrder(OrderPO orderpo) {
//		// TODO Auto-generated method stub
//		System.out.println("addOrder successfully!");
//		return ResultMessage.success;
//	}
//
//	@Override
//	public ResultMessage deleteOrder(OrderPO orderpo) {
//		// TODO Auto-generated method stub
//		System.out.println("deleteOrder successfully!");
//		return ResultMessage.success;
//	}
//
//	@Override
//	public ResultMessage modifyOrder(OrderPO orderpo) {
//		// TODO Auto-generated method stub
//		System.out.println("modifyOrder successfully!");
//		return ResultMessage.success;
//	}
//
//	@Override
//	public OrderPO findOrder(String orderID) {
//		// TODO Auto-generated method stub
//		Map<String, OrderPO> orderList = new HashMap<String, OrderPO>();
//		for(int i = 0; i < orderList.size();i++)
//		{
//			OrderPO orderPO = new OrderPO("0001");//从文件中或者数据库中读出来的orderpo
//			orderList.put("0001", orderPO);
//		}
//		OrderPO returnOrderPO = orderList.get(orderID);
//		return returnOrderPO;
//	}


