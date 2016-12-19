package businesslogic.orderbl;

import java.util.Map;

import businesslogic.orderbl.orderhelper.AppealHelper;
import businesslogic.orderbl.orderhelper.OrderHelper;
import businesslogicservice.orderblservice.OrderWebMarketerService;
import message.ResultMessage;
import model.UserType;
import vo.AppealVO;
import vo.OrderVO;

public class OrderWebMarketerServiceImpl implements OrderWebMarketerService
{
	AppealHelper appealHelper;
	OrderHelper orderHelper;

	public OrderWebMarketerServiceImpl() {
		appealHelper = new AppealHelper();
		orderHelper = new OrderHelper();
	}

	@Override
	public Map<Integer, AppealVO> getAppealOrderList(int userID) {
		
		
		return appealHelper.getAppealOrderList(userID);
	}

	@Override
	public ResultMessage modifyAppealOrder(AppealVO appealVO) {
		
		
		return appealHelper.modifyAppealOrder(appealVO);
	}

	@Override
	public Map<Integer, OrderVO> getUnexecutedOrderList() {
		
		
		return orderHelper.getUnexecutedOrderList(0, UserType.WebMarketer);
	}

	

}
