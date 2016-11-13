package businesslogicservice.hotelinfoblservice;

import java.util.Map;

import vo.HotelVO;

public interface HotelCustomerService {
	
	public Map<String, HotelVO> showHotelList(String hotel_region);
	
	public HotelVO showHotelInfo(String hotel_ID);
}