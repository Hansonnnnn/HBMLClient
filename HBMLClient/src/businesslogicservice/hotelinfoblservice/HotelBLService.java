package businesslogicservice.hotelinfoblservice;

import vo.HotelVO;

public interface HotelBLService {
	public HotelVO[] getHotelList(String hotel_region);
	public HotelVO getHotelInfo(String hotel_ID);
	public boolean addHotel(HotelVO vo);
	public boolean modifyHotel(HotelVO vo);
	public boolean deleteHotel(String hotel_ID);
}
