package presentation.controller;

import java.util.Map;

import businesslogic.utility.TransferImpl;
import businesslogicservice.TransferService;
import businesslogicservice.roominfoblservice.RoomInfoHotelManagerService;
import message.ResultMessage;
import message.RoomStateMessage;
import presentation.view.roominfoui.RoomInfoViewControllerService;
import vo.RoomInfoVO;

public class RoomInfoViewControllerImpl implements RoomInfoViewControllerService{

	TransferService roomTransferImpl;
	RoomInfoHotelManagerService roomInfoHotelManagerServiceImpl;
	
	public RoomInfoViewControllerImpl(RoomInfoHotelManagerService roomInfoHotelManagerServiceImpl) {
		this.roomInfoHotelManagerServiceImpl = roomInfoHotelManagerServiceImpl;
		roomTransferImpl = new TransferImpl();
	}

	@Override
	public Map<String, RoomInfoVO> getRoomList(String hotel_ID) {
		
		return null;
	}

	@Override
	public RoomInfoVO getRoomInfo(String roomType) {
		
		return null;
	}

	@Override
	public ResultMessage addRoom(RoomInfoVO vo) {
		
		return null;
	}

	@Override
	public ResultMessage modifyRoom(RoomInfoVO vo) {
		
		return null;
	}

	@Override
	public ResultMessage deleteRoom(String room_ID) {
		
		return null;
	}

	@Override
	public ResultMessage modifyRoomState(String room_ID, RoomStateMessage room_state) {
		
		return null;
	}
}
