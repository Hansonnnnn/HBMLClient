package businesslogic.roomInfobl;

import java.rmi.RemoteException;
import java.util.LinkedHashMap;
import java.util.Map;

import businesslogic.utility.TransferImpl;
import businesslogicservice.TransferService;
import businesslogicservice.roominfoblservice.RoomInfoStaffService;
import dao.RoomDao;
import message.ResultMessage;
import message.RoomStateMessage;
import po.RoomInfoPO;
import rmi.ClientRunner;
import vo.RoomInfoVO;

/**
 * @author 凡
 *
 */
public class RoomInfoStaffServiceImpl implements RoomInfoStaffService{
	
	Map<String, RoomInfoVO> roominfoList;
	RoomDao roomdao;
	TransferService transferRoomInfo;
	public RoomInfoStaffServiceImpl() {
		roominfoList = null;
		roomdao = ClientRunner.remoteHelper.getRoomDao();
		transferRoomInfo = new TransferImpl();
	}
	
	
	@Override
	public Map<String, RoomInfoVO> getRoomList(int hotel_ID) {
		
		try {
			roominfoList = new LinkedHashMap<>();
			Map<String , RoomInfoPO> map;
			map = roomdao.getRoomList(hotel_ID, null);
			for (String roomID : map.keySet()) {
				
				roominfoList.put(roomID, transferRoomInfo.poToVo(map.get(roomID)));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roominfoList;
	}

	@Override
	public RoomInfoVO getRoomInfo(String roomID) {
		
		RoomInfoVO roomInfoVO = roominfoList.get(roomID);
		return roomInfoVO;
	}

	@Override
	public ResultMessage addRoom(RoomInfoVO vo) {
		
		RoomInfoPO roomInfoPO = transferRoomInfo.voToPO(vo);
		try {
			return roomdao.addRoom(roomInfoPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.disconnection;
		}
	}

	@Override
	public ResultMessage modifyRoom(RoomInfoVO vo) {
		RoomInfoPO roomInfoPO = transferRoomInfo.voToPO(vo);
		try {
			return roomdao.modifyRoom(roomInfoPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.disconnection;
		}
	}

	@Override
	public ResultMessage deleteRoom(int roomInfoID) {
		try {
			return roomdao.deleteRoom(roomInfoID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.disconnection;
		}
	}

	@Override
	public ResultMessage deleteRoom(int hotelID, String roomID) {
		
		try {
			return roomdao.deleteRoom(hotelID,roomID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.disconnection;
		}
	}

	@Override
	public ResultMessage modifyRoomState(int roomInfoID, RoomStateMessage room_state) {

		try {
			return roomdao.modifyRoomState(roomInfoID, room_state);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.disconnection;
		}
	}

	@Override
	public ResultMessage setPrice(int roomInfoID, int price) {

		try {
			return roomdao.setPrice(roomInfoID, null, price);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.disconnection;
		}
	}

}
