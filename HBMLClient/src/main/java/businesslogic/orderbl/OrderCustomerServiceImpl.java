package businesslogic.orderbl;

import java.util.Map;
import businesslogic.orderbl.orderhelper.AppealHelper;
import businesslogic.orderbl.orderhelper.OrderHelper;
import businesslogicservice.orderblservice.OrderCustomerService;
import message.OrderStateMessage;
import message.ResultMessage;
import model.UserType;
import vo.AppealVO;
import vo.OrderVO;

public class OrderCustomerServiceImpl implements OrderCustomerService {
	OrderHelper orderhelper;
	AppealHelper appealHelper;

	public OrderCustomerServiceImpl() {
		orderhelper = new OrderHelper();
		appealHelper = new AppealHelper();
	}

	@Override
	public Map<Integer, OrderVO> getUnexecutedOrderList(int userID) {

		return orderhelper.getUnexecutedOrderList(userID, UserType.Customer);
	}

	@Override
	public Map<Integer, OrderVO> getExecutedOrderList(int userID) {

		return orderhelper.getExecutedOrderList(userID, UserType.Customer);
	}

	@Override
	public Map<Integer, OrderVO> getCancelledOrderList(int userID) {

		return orderhelper.getCancelledOrderList(userID, UserType.Customer);
	}

	@Override
	public Map<Integer, OrderVO> getAbnormalOrderList(int userID) {

		return orderhelper.getAbnormalOrderList(userID, UserType.Customer);
	}

	@Override
	public ResultMessage revokeOrder(int orderID) {

		return orderhelper.changeOrderState(orderID, OrderStateMessage.Cancelled);
	}

	@Override
	public ResultMessage addOrder(OrderVO vo) {

		return orderhelper.addOrder(vo);
	}

	@Override
	public ResultMessage addAppealOrder(AppealVO appealVO) {

		return appealHelper.addAppealOrder(appealVO);
	}

}
