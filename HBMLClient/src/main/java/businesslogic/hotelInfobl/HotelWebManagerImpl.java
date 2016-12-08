package businesslogic.hotelInfobl;

import java.util.Map;

import businesslogic.hotelInfobl.helper.CommentHelper;
import businesslogic.hotelInfobl.helper.HotelHelper;
import businesslogicservice.hotelinfoblservice.HotelWebManagerService;
import message.ResultMessage;
import model.HotelFilter;
import vo.HotelVO;

public class HotelWebManagerImpl implements HotelWebManagerService{

	HotelHelper hotelHelper;
	CommentHelper commentHelper;
	
	public HotelWebManagerImpl(){
		hotelHelper = new HotelHelper();
		commentHelper = new CommentHelper();
	}
	@Override
	public Map<Integer, HotelVO> getHotelList(String name) {
	
		HotelFilter hotelFilter = new HotelFilter();
		hotelFilter.add("name","like", "%"+name+"%");
		return hotelHelper.getHotelList(hotelFilter, null, null);
	}

	@Override
	public HotelVO getHotelInfo(int hotelID) {
		
		
		return hotelHelper.getHotelInfo(hotelID);
	}

	@Override
	public ResultMessage addHotel(HotelVO vo) {
		
		
		return hotelHelper.addHotel(vo);
	}

	@Override
	public ResultMessage modifyHotel(HotelVO vo) {
		
		
		return hotelHelper.modifyHotel(vo);
	}

	@Override
	public ResultMessage deleteHotel(int hotel_ID) {
		
		
		return hotelHelper.deleteHotel(hotel_ID);
	}
	
	
}