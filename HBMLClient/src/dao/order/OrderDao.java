package dao.order;

import message.ResultMessage;
import po.OrderPO;

public interface OrderDao {
		public ResultMessage addOrder(OrderPO orderpo);
		public ResultMessage deleteOrder(OrderPO orderpo);
		public ResultMessage modifyOrder(OrderPO orderpo);
		public OrderPO findOrder(String orderID);
}
