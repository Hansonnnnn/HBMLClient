package presentation.view.hotelinfoui;

import vo.HotelVO;

public interface HotelInfoViewControlerService {
	
	public HotelVO[] showHotelList(String hotel_region);
	
	public HotelVO showHotelInfo(String hotel_ID);
	
	public boolean addHotel(HotelVO vo);
	
	public boolean modifyHotel(HotelVO vo);
	
	public boolean deleteHotel(String hotel_ID);

}