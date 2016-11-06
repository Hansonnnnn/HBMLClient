package businesslogicservice.hotelinfoblservice;

import vo.HotelVO;

public interface HotelCustomerService {
	
	public HotelVO[] showHotelList(String hotel_region);
	
	public HotelVO showHotelInfo(String hotel_ID);
}