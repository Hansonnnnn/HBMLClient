package businesslogic.hotelInfobl;

import java.util.Map;

import businesslogic.hotelInfobl.helper.CommentHelper;
import businesslogic.hotelInfobl.helper.HotelHelper;
import businesslogicservice.hotelinfoblservice.HotelStaffService;
import message.ResultMessage;
import vo.CommentInfoVO;
import vo.HotelVO;

/**
 * @author 凡
 *
 */
public class HotelStaffImpl implements HotelStaffService{

	HotelHelper hotelHelper;
	CommentHelper commentHelper;
	
	public HotelStaffImpl() {
		hotelHelper = new HotelHelper();
		commentHelper = new CommentHelper();
	}

	@Override
	public ResultMessage modifyHotel(HotelVO hotelVO) {
		
		
		return hotelHelper.modifyHotel(hotelVO);
	}

	@Override
	public Map<Integer, CommentInfoVO> getComments(int hotelID) {
		
		
		return commentHelper.getComments(hotelID);
	}
	
	
}