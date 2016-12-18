package businesslogicservice.hotelinfoblservice;

import java.util.Map;
import message.ResultMessage;
import model.HotelFilter;
import vo.HotelVO;

/**
 * @author 凡
 *
 */
public interface HotelWebManagerService {

	/**
	 * @param name 预期搜索酒店的名字
	 * @return  Integer 酒店ID 
	 */
	public Map<Integer, HotelVO> getHotelList(String name);	
	
	/**
	 * @return 所有的酒店，无排序，无筛选
	 */
	public Map<Integer, HotelVO> getAllHotel();	
	
	public HotelVO getHotelInfo(int hotelID);
		
	/**
	 * @param vo  以vo为参数的  都是成型正确的VO  
	 * @return
	 */
	public int addHotel(HotelVO vo);
	
	public ResultMessage modifyHotel(HotelVO vo);
	
	
	/**
	 * @param hotel_ID   要删除哪个酒店
	 * @return
	 */
	public ResultMessage deleteHotel(int hotel_ID);
}