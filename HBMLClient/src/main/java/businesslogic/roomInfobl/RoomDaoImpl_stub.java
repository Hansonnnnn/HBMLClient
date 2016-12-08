package businesslogic.roomInfobl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Map;

import dao.RoomDao;
import message.ResultMessage;
import message.RoomStateMessage;
import po.RoomInfoPO;
//遗留代码，STUB
public class RoomDaoImpl_stub implements RoomDao{

	@Override
	public Map<String, RoomInfoPO> getRoomList(int hotel_ID, Date date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomInfoPO getRoomInfo(String roomType) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addRoom(RoomInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyRoom(RoomInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteRoom(int roomInfoID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteRoom(int hotelID, String roomID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyRoomState(int roomInfoID, RoomStateMessage room_state) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyRoomStateByDay(int roomInfoID, RoomStateMessage roomState, Date date)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setPrice(int roomInfoID, Date date, int price) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Map<String, RoomInfoPO> getRoomList(String hotel_ID) {
//		// TODO Auto-generated method stub
//		System.out.println("(DATA)getRoomList success!");
//		return null;
//	}
//
//	@Override
//	public RoomInfoPO getRoomInfo(String roomType) {
//		// TODO Auto-generated method stub
//		System.out.println("(DATA)getRoomInfo success!");
//		return null;
//	}
//
//	@Override
//	public ResultMessage addRoom(RoomInfoPO po) {
//		// TODO Auto-generated method stub
//		System.out.println("(DATA)addRoom success!");
//		return ResultMessage.failure;
//	}
//
//	@Override
//	public ResultMessage modifyRoom(RoomInfoPO po) {
//		// TODO Auto-generated method stub
//		System.out.println("(DATA)modifyRoom success!");
//		return  ResultMessage.failure;
//	}
//
//	@Override
//	public ResultMessage deleteRoom(String room_ID) {
//		// TODO Auto-generated method stub
//		System.out.println("(DATA)deleteRoom success!");
//		return ResultMessage.failure;
//	}
//
//	@Override
//	public ResultMessage modifyRoomState(String room_ID,RoomStateMessage room_state) {
//		// TODO Auto-generated method stub
//		System.out.println("(DATA)modifyRoomState success!");
//		return  ResultMessage.failure;
//	}

}
