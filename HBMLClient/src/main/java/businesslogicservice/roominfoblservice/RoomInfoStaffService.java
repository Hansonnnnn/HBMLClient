package businesslogicservice.roominfoblservice;

import java.util.Map;

import message.ResultMessage;
import message.RoomStateMessage;
import vo.RoomInfoVO;

public interface RoomInfoStaffService {
	
	/**
	 * @param hotel_ID  查看哪个酒店的room
	 * @return  Map的 Key（String）是RoomID
	 */
	public Map<String, RoomInfoVO> getRoomList(int hotel_ID);
	
	/**
	 * @param roomID  房间的门牌号（前置调用条件是已调用getRoomList）
	 * @return
	 */
	public RoomInfoVO getRoomInfo(String roomID);
	
	
	
	public ResultMessage addRoom(RoomInfoVO vo);

	public ResultMessage modifyRoom(RoomInfoVO vo);
	
	
	/**
	 * @Description: 两种删除的方法，你看用哪个方便
	 *                       roominfoID是每个房间独一无二的编号。 roomID是门牌号（不同酒店的房间可能相同）
	 */
	public ResultMessage deleteRoom(int roomInfoID);
	
	public ResultMessage deleteRoom(int hotelID,String roomID);
	
	/**
	 * @Description: TODO 更改房间状态（针对房间当天状态）      ！！执行订单时不用管房间状态，用OrderService的方法
	 * 
	 * 若RoomState改为unavailable 表示房间不可预订
	 * 
	 * ！！实际使用时不用考虑这个   上层不用考虑前置。
	 * 若RoomState改为Blank  （前置状态booked）表示退房  （前置状态unavailable）表示房间重新接受预定
	 * 
	 */
	public ResultMessage modifyRoomState(int roomInfoID,RoomStateMessage room_state);	
	
	
	/**
	 * @Description: TODO 更改房间价格（针对房间，不针对具体某天）只针对房间默认属性
	 */
	public ResultMessage setPrice(int roomInfoID,int price);
	
	
}
