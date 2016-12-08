package businesslogicservice.orderblservice;

import java.rmi.RemoteException;
import java.util.Map;

import model.UserType;
import po.OrderPO;
import vo.OrderVO;

public interface OrderBLService {
	//获取未执行订单（即订单已生成，但是订单的用户还未入住，订单未执行状态）
	public Map<Integer, OrderVO> getUnexecutedOrderList(int ID,UserType userType);
			
	//获取已执行订单（即订单用户已入住，订单处于在执行状态，直到用户退房或撤销订单）
	public Map<Integer, OrderVO> getExecutedOrderList(int ID,UserType userType);
			
	//获取已撤销订单（即订单用户对该订单执行撤销操作之后，订单处于的状态）
	public Map<Integer, OrderVO> getCancelledOrderList(int ID,UserType userType);
			
	//获取异常订单（即用户未按照规定时间入住，订单处于的状态）
	public Map<Integer, OrderVO> getAbnormalOrderList(int ID,UserType userType);
	/**
	 * 显示订单列表，订单列表可能是各种形式的订单组合成的一个列表
	 * 如：未执行订单列表、已执行订单列表、异常订单列表、已撤销订单列表
	 * 特殊的：待编辑订单列表（只有客户有）
	 * @param orderList
	 */
//	public void showOrderList(OrderVO[] orderList);
	public OrderVO showOrderInfo(String orderID);
	
	/**
	 * 凡是对订单对象有操作的Impl，只要改变订单的数据或状态，就要对OrderPO进行更新
	 * @param id
	 * @return
	 */
//	public boolean updateOrderPO(Order orderNeededToUpdate);

}
