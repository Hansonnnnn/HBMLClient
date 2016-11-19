package businesslogic.roomInfobl;

import java.util.Map;

import dao.roominfo.RoomDao;
import message.ResultMessage;
import message.RoomStateMessage;
import po.RoomInfoPO;
//遗留代码，STUB
public class RoomDaoImpl_stub implements RoomDao{

	@Override
	public Map<String, RoomInfoPO> getRoomList(String hotel_ID) {
		// TODO Auto-generated method stub
		System.out.println("(DATA)getRoomList success!");
		return null;
	}

	@Override
	public RoomInfoPO getRoomInfo(String roomType) {
		// TODO Auto-generated method stub
		System.out.println("(DATA)getRoomInfo success!");
		return null;
	}

	@Override
	public ResultMessage addRoom(RoomInfoPO po) {
		// TODO Auto-generated method stub
		System.out.println("(DATA)addRoom success!");
		return ResultMessage.failure;
	}

	@Override
	public ResultMessage modifyRoom(RoomInfoPO po) {
		// TODO Auto-generated method stub
		System.out.println("(DATA)modifyRoom success!");
		return  ResultMessage.failure;
	}

	@Override
	public ResultMessage deleteRoom(String room_ID) {
		// TODO Auto-generated method stub
		System.out.println("(DATA)deleteRoom success!");
		return ResultMessage.failure;
	}

	@Override
	public ResultMessage modifyRoomState(String room_ID,RoomStateMessage room_state) {
		// TODO Auto-generated method stub
		System.out.println("(DATA)modifyRoomState success!");
		return  ResultMessage.failure;
	}

}
