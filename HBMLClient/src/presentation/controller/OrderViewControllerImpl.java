package presentation.controller;

import businesslogicservice.orderblservice.OrderCustomerService;
import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.orderblservice.OrderStaffService;
import businesslogicservice.orderblservice.OrderWebMarketerService;
import presentation.view.orderui.CustomerOfOrderView;
import presentation.view.orderui.OrderViewControllerService;

public class OrderViewControllerImpl implements OrderViewControllerService
{
		private CustomerOfOrderView view_of_customer;
		
		private OrderBLService orderblservice;
		private OrderCustomerService customerservice;
		private OrderStaffService staffservice;
		private OrderWebMarketerService webmarketerservice;
		
		/**
		 * 显示订单信息
		 */
		public void showOrderInfo()
		{
			
		}
		/**
		 * 显示订单列表
		 */
		public void showOrderList()
		{
			
		}
		
		/**
		 * 生成订单
		 */
		public void makeOrder()
		{
			
		}
		
		/**
		 * 撤销订单
		 */
		public void cancelOrder()
		{
			
		}
		
		/**
		 * 执行订单(针对酒店工作人员所独有)
		 */
		public void executeOrder()
		{
			
		}
		
		/**
		 * 编辑订单
		 */
		public void editOrder()
		{
			
		}
		
		/**
		 * 评价订单
		 */
		public void evaluateOrder()
		{
			
		}
		
		/**
		 * 订单申诉
		 */
		public void orderAppeal()
		{
			
		}
		
		/**
		 * 更新订单列表（为内部调用方法）
		 */
		public void updateOrdeList()
		{
			
		}
		/**
		 *以下方法是处理各ui之间的相互调用，即处理按钮点击之后的界面切换的方法 
		 */
		
		
}
