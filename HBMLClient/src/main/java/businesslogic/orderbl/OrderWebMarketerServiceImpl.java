package businesslogic.orderbl;

import java.util.Map;

import businesslogic.orderbl.orderhelper.AppealHelper;
import businesslogicservice.orderblservice.OrderWebMarketerService;
import message.ResultMessage;
import vo.AppealVO;

public class OrderWebMarketerServiceImpl implements OrderWebMarketerService
{
	AppealHelper appealHelper;

	public OrderWebMarketerServiceImpl() {
		appealHelper = new AppealHelper();
	}

	@Override
	public Map<Integer, AppealVO> getAppealOrderList(int userID) {
		
		
		return appealHelper.getAppealOrderList(userID);
	}

	@Override
	public ResultMessage modifyAppealOrder(AppealVO appealVO) {
		
		
		return appealHelper.modifyAppealOrder(appealVO);
	}

	

}
