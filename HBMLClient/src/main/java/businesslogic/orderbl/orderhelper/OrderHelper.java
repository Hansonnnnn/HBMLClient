package businesslogic.orderbl.orderhelper;

import java.rmi.RemoteException;
import java.util.LinkedHashMap;
import java.util.Map;

import businesslogic.utility.TransferImpl;
import businesslogicservice.TransferService;
import dao.OrderDao;
import message.OrderStateMessage;
import message.ResultMessage;
import model.UserType;
import po.OrderPO;
import rmi.ClientRunner;
import vo.OrderVO;

public class OrderHelper {
	
	Map<Integer, OrderVO> orderList ;
	OrderDao orderDao;
	TransferService orderTransferService ;
	public OrderHelper() {
		orderDao = ClientRunner.remoteHelper.getOrderDao();
		orderTransferService = new TransferImpl();
	}
	
	
	//获取未执行订单（即订单已生成，但是订单的用户还未入住，订单未执行状态）
	public Map<Integer, OrderVO> getUnexecutedOrderList(int ID,UserType userType) {
		orderList = new LinkedHashMap<>();
		try {
			Map<Integer, OrderPO> map = orderDao.getOrderList(ID, userType, OrderStateMessage.Unexecuted);
			for (int key :map.keySet()) {
				orderList.put(key,orderTransferService.poToVo(map.get(key)));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}
	
	//获取已执行订单（即订单用户已入住，订单处于在执行状态）
	public Map<Integer, OrderVO> getExecutedOrderList(int ID,UserType userType) {
		
		orderList = new LinkedHashMap<>();
		try {
			Map<Integer, OrderPO> map = orderDao.getOrderList(ID, userType, OrderStateMessage.Executed);
			for (int key :map.keySet()) {
				orderList.put(key,orderTransferService.poToVo(map.get(key)));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}
	
	//获取已撤销订单（即订单用户对该订单执行撤销操作之后，订单处于的状态）
	public Map<Integer, OrderVO> getCancelledOrderList(int ID,UserType userType) {
		orderList = new LinkedHashMap<>();
		try {
			Map<Integer, OrderPO> map = orderDao.getOrderList(ID, userType, OrderStateMessage.Cancelled);
			for (int key :map.keySet()) {
				orderList.put(key,orderTransferService.poToVo(map.get(key)));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}
	
	//获取异常订单（即用户未按照规定时间入住，订单处于的状态）
	public Map<Integer, OrderVO> getAbnormalOrderList(int ID,UserType userType) {
		orderList = new LinkedHashMap<>();
		try {
			Map<Integer, OrderPO> map = orderDao.getOrderList(ID, userType, OrderStateMessage.Abnormal);
			for (int key :map.keySet()) {
				orderList.put(key,orderTransferService.poToVo(map.get(key)));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}
	
	//获得具体订单信息(非申诉订单)
	public OrderVO getOrderInfo(int orderID) {
		return orderList.get(orderID);		
	}
	//用户点击“撤销订单”，订单状态  “未执行”---->"已撤销"
	//执行订单 “未执行、异常”---->"已执行"
	public ResultMessage changeOrderState(int orderID,OrderStateMessage orderState) {
		try {
			return orderDao.changeOrderState(orderID, orderState);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.disconnection;
		}
	}

	//用户点击“生成订单”，添加订单
	public ResultMessage addOrder(OrderVO vo) {
		try {
			return orderDao.addOrder(orderTransferService.voToPo(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.disconnection;
		}
	}
	
}
