package businesslogic.roomInfobl.roomhelper;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.standard.RequestingUserName;

import businesslogic.roomInfobl.RoomDaoImpl_stub;
import businesslogic.utility.TransferImpl;
import businesslogicservice.TransferService;
import dao.roominfo.RoomDao;
import message.ResultMessage;
import po.RoomInfoPO;
import vo.RoomInfoVO;

public class RoomInfoList {

	RoomInfo roomInfo ;
	Map<String, RoomInfoVO> roomInfoList;
	RoomDao roomInfoDao = new RoomDaoImpl_stub();
	TransferService roomInfoTransferService = new TransferImpl();
	public RoomInfoList() {
		roomInfo = new RoomInfo();
		roomInfoList = new HashMap<String, RoomInfoVO>();
	}
	
//	public Map<String, RoomInfoVO> getRoomInfoList() {
//		try {
//			Map<String , RoomInfoPO> roomInfoPoList = roomInfoDao.getRoomList("0001");
//			for (String string:roomInfoPoList.keySet()) {
//				if (string != null) {
//					roomInfoList.put(string,roomInfoTransferService.poToVo(roomInfoPoList.get(string)));
//				}
//			}
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return roomInfoList;
//	}
	  
	public RoomInfoVO getRoomInfo() {
		
		return new RoomInfoVO();
	}
	
	public ResultMessage creatRoomInfo() {
		
		return ResultMessage.failure;
	}
}
