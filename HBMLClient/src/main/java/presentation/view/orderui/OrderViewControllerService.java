package presentation.view.orderui;

import presentation.view.customerui.customerui.OrderVO;

public interface OrderViewControllerService {
	
		public OrderVO showOrderInfo(String orderID);
	
		public void showOrderList();
		
		public void makeOrder();
	
		public void cancelOrder();
	
		public void executeOrder();

		public void editOrder();
	
		public void evaluateOrder();
	
		public void orderAppeal();
	
		public void updateOrdeList();

	/**
	 *以下方法是处理各ui之间的相互调用，即处理按钮点击之后的界面切换的方法 
	 */

}
