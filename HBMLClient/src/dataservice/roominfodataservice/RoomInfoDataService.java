package dataservice.roominfodataservice;

import po.RoomInfoPO;

public interface RoomInfoDataService {
	public RoomInfoPO[] getRoomList(String hotel_ID);
	public RoomInfoPO getRoomInfo(String roomType);
	public boolean addRoom(RoomInfoPO po);
	public boolean modifyRoom(RoomInfoPO po);
	public boolean deleteRoom(String room_ID);
	public boolean modifyRoomState(String room_ID,String room_state);

}
