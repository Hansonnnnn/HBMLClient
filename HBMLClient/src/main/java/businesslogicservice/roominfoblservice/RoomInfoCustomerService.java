package businesslogicservice.roominfoblservice;

import java.util.Date;
import java.util.Map;

import vo.RoomInfoVO;

public interface RoomInfoCustomerService {

	/**
	 * @param hotel_ID 查看哪个酒店的room
	 * @param date	查看哪天的room
	 * @return Map中Key（String）是房型，如果这个房型有空房，则Value（RoomInfoVO）是价格最低的那个房，订的时候直接用这个
	 * 										 如果这个房型没有空房，则Value（RoomInfoVO）中roomInfoID为空，vo中只有价格供显示使用
	 */
	public Map<String, RoomInfoVO> getRoomList(int hotel_ID,Date date); 
	
}
