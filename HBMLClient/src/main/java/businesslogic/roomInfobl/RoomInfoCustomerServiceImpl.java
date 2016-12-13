package businesslogic.roomInfobl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import businesslogic.utility.TransferImpl;
import businesslogicservice.TransferService;
import businesslogicservice.roominfoblservice.RoomInfoCustomerService;
import dao.RoomDao;
import po.RoomInfoPO;
import rmi.ClientRunner;
import vo.RoomInfoVO;

/**
 * @author 凡
 *
 */
public class RoomInfoCustomerServiceImpl implements RoomInfoCustomerService{

	Map<String, RoomInfoVO> roominfoList;
	RoomDao roomdao;
	TransferService transferRoomInfo;
	public RoomInfoCustomerServiceImpl() {
		roominfoList = null;
		roomdao = ClientRunner.remoteHelper.getRoomDao();
		transferRoomInfo = new TransferImpl();
	}
	@Override
	public Map<String, RoomInfoVO> getRoomList(int hotel_ID, Date date) {
		
		try {
			roominfoList = new LinkedHashMap<>();
			Map<String , RoomInfoPO> map;
			map = roomdao.getRoomList(hotel_ID, date);
			for (String roomType : map.keySet()) {
				
				roominfoList.put(roomType, transferRoomInfo.poToVo(map.get(roomType)));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roominfoList;
	}

}
