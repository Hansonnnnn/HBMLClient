package presentation.view.roominfoui;

import java.util.Map;

import message.ResultMessage;
import message.RoomStateMessage;
import vo.RoomInfoVO;

public class RoomInfoViewControllerService_stub implements RoomInfoViewControllerService{

	@Override
	public Map<String, RoomInfoVO> getRoomList(String hotel_ID) {
		// TODO Auto-generated method stub
		System.out.println("(DATA)getRoomList success!");
		return null;
	}

	@Override
	public RoomInfoVO getRoomInfo(String roomType) {
		// TODO Auto-generated method stub
		System.out.println("(DATA)getRoomInfo success!");
		return null;
	}

	@Override
	public ResultMessage addRoom(RoomInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("(DATA)addRoom success!");
		return ResultMessage.failure;
	}

	@Override
	public ResultMessage modifyRoom(RoomInfoVO vo) {
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
