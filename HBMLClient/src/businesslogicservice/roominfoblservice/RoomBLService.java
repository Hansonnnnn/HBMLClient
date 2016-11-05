package businesslogicservice.roominfoblservice;

import VO.RoomInfoVO;

public interface RoomBLService {
	public RoomInfoVO[] getRoomList(String hotel_ID);
	public RoomInfoVO getRoomInfo(String roomType);
	public boolean addRoom(RoomInfoVO vo);
	public boolean modifyRoom(RoomInfoVO vo);
	public boolean deleteRoom(String room_ID);
	public boolean modifyRoomState(String room_ID,String room_state);
	
}
