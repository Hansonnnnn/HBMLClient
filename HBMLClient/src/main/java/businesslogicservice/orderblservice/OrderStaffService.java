package businesslogicservice.orderblservice;

import java.util.Map;

import message.ResultMessage;
import vo.OrderVO;

public interface OrderStaffService 
{
		public Map<Integer, OrderVO> getUnexecutedOrderList(int hotelID) ;
		
		//获取已执行订单（即订单用户已入住，订单处于在执行状态）
		public Map<Integer, OrderVO> getExecutedOrderList(int hotelID) ;
		
		//获取已撤销订单（即订单用户对该订单执行撤销操作之后，订单处于的状态）
		public Map<Integer, OrderVO> getCancelledOrderList(int hotelID) ;
		
		//获取异常订单（即用户未按照规定时间入住，订单处于的状态）
		public Map<Integer, OrderVO> getAbnormalOrderList(int hotelID) ;
		//执行订单 “未执行、异常”---->"已执行"
		public ResultMessage executeOrder(int orderID) ;
}
