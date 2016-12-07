package businesslogicservice.hotelinfoblservice;

import java.util.List;

import message.ResultMessage;
import vo.CommentInfoVO;
import vo.HotelVO;

public interface HotelStaffService {
	
	public ResultMessage modifyHotel(HotelVO hotelVO);
	
	public List<CommentInfoVO> getComments(int hotelID);
	
}