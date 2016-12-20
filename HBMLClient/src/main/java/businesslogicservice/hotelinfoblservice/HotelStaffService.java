package businesslogicservice.hotelinfoblservice;

import java.util.Map;

import message.ResultMessage;
import vo.CommentInfoVO;
import vo.HotelVO;

public interface HotelStaffService {
	
	/**
	 * @param hotelVO   修改后成型的hotelVO
	 * @return
	 */
	public ResultMessage modifyHotel(HotelVO hotelVO);
	
	/**
	 * @param hotelID  查看哪个酒店的评论
	 * @return	Map Key（integer是评论编号） 
	 */
	public Map<Integer, CommentInfoVO> getComments(int hotelID);
	
	public HotelVO getHotelInfo(int hotelID);
	
}