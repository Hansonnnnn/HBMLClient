package dao.roominfo;

import java.rmi.Remote;
import java.util.Map;

import message.ResultMessage;
import po.RoomInfoPO;

public interface RoomDao extends Remote {
	public Map<String, RoomInfoPO> getRoomList(String hotel_ID);
	public RoomInfoPO getRoomInfo(String roomType);
	public ResultMessage addRoom(RoomInfoPO po);
	public ResultMessage modifyRoom(RoomInfoPO po);
	public ResultMessage deleteRoom(String room_ID);
	public ResultMessage modifyRoomState(String room_ID,String room_state);
	
}
