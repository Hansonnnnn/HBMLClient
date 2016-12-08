package businesslogic.roomInfobl.roomhelper;

import java.rmi.RemoteException;

import businesslogic.roomInfobl.RoomDaoImpl_stub;
import businesslogic.utility.TransferImpl;
import businesslogicservice.TransferService;
import dao.roominfo.RoomDao;
import message.ResultMessage;
import message.RoomStateMessage;
import po.RoomInfoPO;
import vo.RoomInfoVO;

public class RoomInfo {
	String roomType;
	int price;
	RoomState roomState;
	TransferService roomInfoTransfer = new TransferImpl();
	RoomDao roomDao = new RoomDaoImpl_stub();
	
	public RoomInfoVO getPoFromData() {
		RoomInfoPO roomInfoPO = null;
		try {
			roomInfoPO = roomDao.getRoomInfo("0001");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return roomInfoTransfer.poToVo(roomInfoPO);
	}
	
	public RoomInfoPO createRoomInfoPO() {
		
		return new RoomInfoPO();
	}
	
	public ResultMessage addRoomInfoPO(RoomInfoPO po) {
		
		return ResultMessage.failure;
	}
	
	public ResultMessage deleteRoomInfoPO(String room_ID) {
		
		return ResultMessage.failure;
	}
	
	public ResultMessage modifyRoomInfoPO(RoomInfoPO po) {
		
		return ResultMessage.failure;
	}
//	public ResultMessage modifyRoomInfoState(RoomStateMessage roomStateMessage) {
//		
//		return roomState.modifyRoomInfoState(roomStateMessage);
//	}
}
