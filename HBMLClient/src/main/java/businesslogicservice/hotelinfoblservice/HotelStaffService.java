package businesslogicservice.hotelinfoblservice;

import java.util.Map;

import message.ResultMessage;
import vo.CommentInfoVO;
import vo.HotelVO;

public interface HotelStaffService {
	
	public ResultMessage modifyHotel(HotelVO hotelVO);
	
	public Map<Integer, CommentInfoVO> getComments(int hotelID);
	
}