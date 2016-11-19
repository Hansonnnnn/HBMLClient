package presentation.view.roominfoui;

import java.util.Map;

import message.ResultMessage;
import message.RoomStateMessage;
import vo.RoomInfoVO;

public class HotelManagerOfRoomView {
	
	RoomInfoViewControllerService controller;
	
	public HotelManagerOfRoomView(RoomInfoViewControllerService controller) {
		this.controller = controller;
	}
	
	

	public Map<String, RoomInfoVO> getRoomList(String hotel_ID) {
		
		return controller.getRoomList(hotel_ID);
	}


	public RoomInfoVO getRoomInfo(String roomType) {
	

		return  controller.getRoomInfo(roomType);
	}

	public ResultMessage addRoom(RoomInfoVO vo) {
	
		return controller.addRoom(vo);
	}


	public ResultMessage modifyRoom(RoomInfoVO vo) {
	
		return  controller.modifyRoom(vo);
	}


	public ResultMessage deleteRoom(String room_ID) {

		return controller.deleteRoom(room_ID);
	}


	public ResultMessage modifyRoomState(String room_ID,RoomStateMessage room_state) {
	
		return  controller.modifyRoomState(room_ID, room_state);
	}
	
}
