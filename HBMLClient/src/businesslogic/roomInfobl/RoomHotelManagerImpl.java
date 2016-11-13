package businesslogic.roomInfobl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import businesslogicservice.roominfoblservice.RoomHotelManagerService;
import dao.roominfo.RoomDao;
import message.ResultMessage;
import message.RoomStateMessage;
import po.RoomInfoPO;
import rmi.ClientRunner;
import vo.HotelVO;
import vo.RoomInfoVO;

public class RoomHotelManagerImpl implements RoomHotelManagerService {

	private Map<String, RoomInfoVO> roomList ;
	
	private RoomDao roomDao;
	
	public RoomHotelManagerImpl() {
		roomDao = ClientRunner.remoteHelper.getRoomDao();
		roomList =new HashMap<String,RoomInfoVO>();
		//测试使用。后期删除
		roomDao = new RoomDaoImpl_stub();
	}
	
	@Override
	public Map<String, RoomInfoVO> getRoomList(String hotel_ID) {

		try {
			roomDao.getRoomList("0001");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RoomInfoVO getRoomInfo(String roomType) {
		try {
			roomDao.getRoomInfo("0001");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage addRoom(RoomInfoVO vo) {
		try {
			roomDao.addRoom(new RoomInfoPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage modifyRoom(RoomInfoVO vo) {
		try {
			roomDao.modifyRoom(new RoomInfoPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage deleteRoom(String room_ID) {
		try {
			roomDao.deleteRoom("0001");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage modifyRoomState(String room_ID, RoomStateMessage room_state) {
		try {
			roomDao.modifyRoomState(room_ID, room_state);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
