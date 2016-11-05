package businesslogicservice.orderblservice;

import PO.OrderPO;
import VO.AppealVO;
import VO.OrderVO;

public interface OrderBLService {
	/**
	 * 显示订单信息，要实现该方法的参与者有：Customer、Staff
	 * 特殊的：显示未执行订单的方法多一个参与者：WebMarketer
	 * @param order
	 */
	public void showOrderInfo(OrderVO order);
	
	/**
	 * 显示订单列表，订单列表可能是各种形式的订单组合成的一个列表
	 * 如：未执行订单列表、已执行订单列表、异常订单列表、已撤销订单列表
	 * 特殊的：待编辑订单列表（只有客户有）
	 * @param orderList
	 */
	public void showOrderList(OrderVO[] orderList);
	
	/**
	 * 凡是对订单对象有操作的Impl，只要改变订单的数据或状态，就要对OrderPO进行更新
	 * @param id
	 * @return
	 */
	public boolean updateOrderPO(String id);

}
