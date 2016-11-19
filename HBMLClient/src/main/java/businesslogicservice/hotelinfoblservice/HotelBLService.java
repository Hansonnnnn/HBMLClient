package businesslogicservice.hotelinfoblservice;

import vo.HotelVO;
//STUB使用，后期删除
public interface HotelBLService {
	public HotelVO[] getHotelList(String hotel_region);
	public HotelVO getHotelInfo(String hotel_ID);
	public boolean addHotel(HotelVO vo);
	public boolean modifyHotel(HotelVO vo);
	public boolean deleteHotel(String hotel_ID);
}
