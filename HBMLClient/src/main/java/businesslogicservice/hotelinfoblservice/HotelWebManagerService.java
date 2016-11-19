package businesslogicservice.hotelinfoblservice;

import java.util.Map;

import vo.HotelVO;

public interface HotelWebManagerService {

	public Map<String, HotelVO> showHotelList(String hotel_region);
	
	public HotelVO showHotelInfo(String hotel_ID);
	
	public boolean addHotel(HotelVO vo);
	
	public boolean modifyHotel(HotelVO vo);
	
	public boolean deleteHotel(String hotel_ID);
}