package businesslogicservice.roominfoblservice;

import java.util.Map;

import message.ResultMessage;
import message.RoomStateMessage;
import vo.RoomInfoVO;

public interface RoomHotelManagerService {
	public Map<String, RoomInfoVO> getRoomList(String hotel_ID);
	public RoomInfoVO getRoomInfo(String roomType);
	public ResultMessage addRoom(RoomInfoVO vo);
	public ResultMessage modifyRoom(RoomInfoVO vo);
	public ResultMessage deleteRoom(String room_ID);
	public ResultMessage modifyRoomState(String room_ID,RoomStateMessage room_state);
	
}
