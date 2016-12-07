package businesslogicservice.hotelinfoblservice;

import java.util.Map;

import message.ResultMessage;
import model.HotelFilter;
import vo.HotelVO;

public interface HotelWebManagerService {

	public Map<Integer, HotelVO> getHotelList(HotelFilter filter,String order);	
	
	public HotelVO getHotelInfo(int hotelID);
		
	public ResultMessage addHotel(HotelVO vo);
	
	public ResultMessage modifyHotel(HotelVO vo);
	
	public ResultMessage deleteHotel(int hotel_ID);
}