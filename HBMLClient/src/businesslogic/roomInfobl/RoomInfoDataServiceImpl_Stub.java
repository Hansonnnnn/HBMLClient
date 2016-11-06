package businesslogic.roomInfobl;

import dataservice.roominfodataservice.RoomInfoDataService;
import po.RoomInfoPO;

public class RoomInfoDataServiceImpl_Stub implements RoomInfoDataService{

	@Override
	public RoomInfoPO[] getRoomList(String hotel_ID) {
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
	public boolean addRoom(RoomInfoPO po) {
		// TODO Auto-generated method stub
		System.out.println("(DATA)addRoom success!");
		return false;
	}

	@Override
	public boolean modifyRoom(RoomInfoPO po) {
		// TODO Auto-generated method stub
		System.out.println("(DATA)modifyRoom success!");
		return false;
	}

	@Override
	public boolean deleteRoom(String room_ID) {
		// TODO Auto-generated method stub
		System.out.println("(DATA)deleteRoom success!");
		return false;
	}

	@Override
	public boolean modifyRoomState(String room_ID, String room_state) {
		// TODO Auto-generated method stub
		System.out.println("(DATA)modifyRoomState success!");
		return false;
	}

}
