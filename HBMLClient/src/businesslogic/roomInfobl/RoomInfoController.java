package businesslogic.roomInfobl;

import businesslogicservice.roominfoblservice.RoomBLService;
import dataservice.roominfodataservice.RoomInfoDataService;
import po.RoomInfoPO;
import vo.RoomInfoVO;

public class RoomInfoController implements RoomBLService {
	RoomInfoDataService roomInfoDataService = new RoomInfoDataServiceImpl_Stub();
	
	String hotel_ID = "";
	String Room_ID = "";
	
	RoomInfoVO roomInfoVO;

	@Override
	public RoomInfoVO[] getRoomList(String hotel_ID) {
		// TODO Auto-generated method stub
		if (hotel_ID.equals("0001")) {
			roomInfoDataService.getRoomList(hotel_ID);
		}
		return null;
	}

	@Override
	public RoomInfoVO getRoomInfo(String roomType) {
		// TODO Auto-generated method stub
		if (roomType.equals("0001")) {
			roomInfoDataService.getRoomInfo(roomType);
		}
		return null;
	}

	@Override
	public boolean addRoom(RoomInfoVO vo) {
		roomInfoDataService.addRoom(new RoomInfoPO());
		return false;
	}

	@Override
	public boolean modifyRoom(RoomInfoVO vo) {
		roomInfoDataService.modifyRoom(new RoomInfoPO());
		System.out.println("Orderbl.OrderblImpl.getAddOrderState(String order_ID)");
		return false;
	
	}

	@Override
	public boolean deleteRoom(String room_ID) {
		roomInfoDataService.deleteRoom(room_ID);
		return false;
	}

	@Override
	public boolean modifyRoomState(String room_ID, String room_state) {
		roomInfoDataService.modifyRoomState(room_ID, room_state);
		return false;		
	}
}
