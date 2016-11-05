package businesslogicservice.hotelinfoblservice;

import VO.HotelVO;

public interface HotelCustomerService {
	
	public HotelVO[] showHotelList(String hotel_region);
	
	public HotelVO showHotelInfo(String hotel_ID);
}