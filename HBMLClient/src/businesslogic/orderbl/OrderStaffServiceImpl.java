package businesslogic.orderbl;

import java.util.Map;

import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.orderblservice.OrderStaffService;
import vo.OrderVO;

public class OrderStaffServiceImpl implements OrderStaffService, OrderBLService
{

	@Override
	public Map<String, OrderVO> showOrderList(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showOrderList(OrderVO[] orderList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateOrderPO(Order orderNeededToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean executeOrder() {
		// TODO Auto-generated method stub
		return false;
	}

}
