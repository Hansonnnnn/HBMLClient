package businesslogicservice.orderblservice;

import java.util.Map;

import message.ResultMessage;
import vo.AppealVO;
import vo.OrderVO;

/**
 * @author 凡
 *
 */
public interface OrderCustomerService {
	public Map<Integer, OrderVO> getUnexecutedOrderList(int userID);

	// 获取已执行订单（即订单用户已入住，订单处于在执行状态）
	public Map<Integer, OrderVO> getExecutedOrderList(int userID);

	// 获取已撤销订单（即订单用户对该订单执行撤销操作之后，订单处于的状态）
	public Map<Integer, OrderVO> getCancelledOrderList(int userID);

	// 获取异常订单（即用户未按照规定时间入住，订单处于的状态）
	public Map<Integer, OrderVO> getAbnormalOrderList(int userID);

	/**
	 * @TODO：撤销订单
	 * @param orderID 
	 * @return
	 */
	public ResultMessage revokeOrder(int orderID);

	/**
	 * @TODO：用户点击“生成订单”，添加订单
	 * @param vo 新VO中需有 (userID,hotelID,roomInfoID,executeDDL,number,hasChild,price)
	 * @return
	 */
	public ResultMessage addOrder(OrderVO vo);


	/**
	 * @TODO：用户在异常订单界面可发起申诉
	 * @param appealVO 新VO 中需有(orderID,userID,content)，其余为null即可
	 * @return
	 */
	public ResultMessage addAppealOrder(AppealVO appealVO);
}
