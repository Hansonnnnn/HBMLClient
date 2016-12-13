package businesslogic.hotelInfobl;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import businesslogic.hotelInfobl.helper.CommentHelper;
import businesslogic.hotelInfobl.helper.HotelHelper;
import businesslogicservice.hotelinfoblservice.HotelCustomerService;
import message.OrderStateMessage;
import message.ResultMessage;
import model.HotelFilter;
import vo.CommentInfoVO;
import vo.HotelVO;

/**
 * @author 凡
 *
 */
public class HotelCustomerImpl implements HotelCustomerService{

	HotelHelper hotelHelper;
	CommentHelper commentHelper;
	
	public HotelCustomerImpl(){
		hotelHelper = new HotelHelper();
		commentHelper = new CommentHelper();
	}

	@Override
	public Map<Integer, HotelVO> getHotelList(HotelFilter filter, String order, Date date) {
		
		return hotelHelper.getHotelList(filter, order, date);
	}

	@Override
	public HotelVO getHotelInfo(int hotelID) {
		
		
		return hotelHelper.getHotelInfo(hotelID);
	}

	@Override
	public ResultMessage addComment(CommentInfoVO commentInfoVO) {
		
		
		return commentHelper.addComment(commentInfoVO);
	}

	@Override
	public Set<Integer> hotelRecord(int userID, OrderStateMessage orderState) {
		
		
		return hotelHelper.hotelRecord(userID,orderState);
	}
	
	
	
}