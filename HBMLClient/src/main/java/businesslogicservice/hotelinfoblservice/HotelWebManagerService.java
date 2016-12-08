package businesslogicservice.hotelinfoblservice;

import java.util.Map;
import message.ResultMessage;
import model.HotelFilter;
import vo.HotelVO;

public interface HotelWebManagerService {

	/**
	 * @param name 预期搜索酒店的名字
	 * @return
	 */
	public Map<Integer, HotelVO> getHotelList(String name);	
	
	public HotelVO getHotelInfo(int hotelID);
		
	public ResultMessage addHotel(HotelVO vo);
	
	public ResultMessage modifyHotel(HotelVO vo);
	
	public ResultMessage deleteHotel(int hotel_ID);
}