package businesslogic.orderbl.orderhelper;

import java.rmi.RemoteException;
import java.util.LinkedHashMap;
import java.util.Map;

import businesslogic.utility.TransferImpl;
import businesslogicservice.TransferService;
import dao.OrderDao;
import message.ResultMessage;
import po.AppealPO;
import rmi.ClientRunner;
import vo.AppealVO;

public class AppealHelper {

	Map<Integer,AppealVO> appealList;
	OrderDao orderDao;
	TransferService appealTransfer = new TransferImpl();
	public AppealHelper() {
		orderDao = ClientRunner.remoteHelper.getOrderDao();
		appealTransfer = new TransferImpl();
	}
	
	
	public ResultMessage addAppealOrder(AppealVO appealVO) {
		
		try {
			return orderDao.addAppealOrder(appealTransfer.voToPo(appealVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.disconnection;
		}
	}
	
	
	public Map<Integer, AppealVO> getAppealOrderList(int userID){
		appealList = new LinkedHashMap<>();
		try {
			Map<Integer, AppealPO> map = orderDao.getAppealOrderList(userID);
			for (int key : map.keySet()) {
				appealList.put(key,appealTransfer.poToVo(map.get(key)));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return appealList;
	}
	

	public ResultMessage modifyAppealOrder(AppealVO appealVO){
		try {
			return orderDao.modifyAppealOrder(appealTransfer.voToPo(appealVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.disconnection;
		}
		
	}
	
}
