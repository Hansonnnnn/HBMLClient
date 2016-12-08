package businesslogic.orderbl;

import java.util.Map;

import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.orderblservice.OrderStaffService;
import model.UserType;
import vo.OrderVO;

public class OrderStaffServiceImpl implements OrderStaffService, OrderBLService
{

	@Override
	public Map<Integer, OrderVO> getUnexecutedOrderList(int ID, UserType userType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, OrderVO> getExecutedOrderList(int ID, UserType userType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, OrderVO> getCancelledOrderList(int ID, UserType userType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, OrderVO> getAbnormalOrderList(int ID, UserType userType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO showOrderInfo(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean executeOrder() {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public Map<String, UnexecutedOrderVO> showOrderList(String type) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public boolean updateOrderPO(Order orderNeededToUpdate) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean executeOrder() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public UnexecutedOrderVO showOrderInfo(String orderID) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
