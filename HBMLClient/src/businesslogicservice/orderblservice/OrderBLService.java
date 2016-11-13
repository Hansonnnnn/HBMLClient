package businesslogicservice.orderblservice;

import java.util.Map;

import businesslogic.orderbl.Order;
import vo.OrderVO;

public interface OrderBLService {
	public Map<String, OrderVO> showOrderList(String type);
	public OrderVO showOrderInfo(String orderID);
	public boolean updateOrderPO(Order orderNeededToUpdate);
}
