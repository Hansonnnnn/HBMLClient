package businesslogic.orderbl;

import java.util.Map;

import businesslogic.orderbl.orderhelper.AppealHelper;
import businesslogic.orderbl.orderhelper.OrderHelper;
import businesslogicservice.orderblservice.OrderStaffService;
import message.OrderStateMessage;
import message.ResultMessage;
import model.UserType;
import vo.OrderVO;

public class OrderStaffServiceImpl implements OrderStaffService{

	OrderHelper orderhelper;
	AppealHelper appealHelper;

	public OrderStaffServiceImpl() {
		orderhelper = new OrderHelper();
		appealHelper = new AppealHelper();
	}
	
	@Override
	public Map<Integer, OrderVO> getUnexecutedOrderList(int hotelID) {
		
		
		return orderhelper.getUnexecutedOrderList(hotelID, UserType.Staff);
	}

	@Override
	public Map<Integer, OrderVO> getExecutedOrderList(int hotelID) {
		
		
		return orderhelper.getExecutedOrderList(hotelID, UserType.Staff);
	}

	@Override
	public Map<Integer, OrderVO> getCancelledOrderList(int hotelID) {
		
		
		return orderhelper.getCancelledOrderList(hotelID, UserType.Staff);
	}

	@Override
	public Map<Integer, OrderVO> getAbnormalOrderList(int hotelID) {
		
		
		return orderhelper.getAbnormalOrderList(hotelID, UserType.Staff);
	}

	@Override
	public ResultMessage executeOrder(int orderID) {
		
		
		return orderhelper.changeOrderState(orderID, OrderStateMessage.Executed);
	}

	

}
