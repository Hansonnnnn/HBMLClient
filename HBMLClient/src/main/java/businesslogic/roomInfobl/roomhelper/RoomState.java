package businesslogic.roomInfobl.roomhelper;

import java.rmi.RemoteException;

import businesslogic.roomInfobl.RoomDaoImpl_stub;
import dao.roominfo.RoomDao;
import message.ResultMessage;
import message.RoomStateMessage;

public class RoomState {

	RoomDao roomDao = new RoomDaoImpl_stub();
//	public ResultMessage modifyRoomInfoState(RoomStateMessage room_state) {
//		
//		try {
//			return roomDao.modifyRoomState("0001", room_state);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

}
