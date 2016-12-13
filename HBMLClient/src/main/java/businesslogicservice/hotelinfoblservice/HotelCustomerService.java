package businesslogicservice.hotelinfoblservice;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import message.OrderStateMessage;
import message.ResultMessage;
import model.HotelFilter;
import vo.CommentInfoVO;
import vo.HotelVO;

/**
 * @author 凡
 *
 */
public interface HotelCustomerService {
	
	/**
	 * @param filter   查看model里该类使用规则
	 * @param order   为（lowestPrice,star,score）
	 * @param date    查看哪一天的酒店
	 * @return 	删选后排好序的map集合
	 */
	public Map<Integer, HotelVO> getHotelList(HotelFilter filter,String order,Date date);	
	
	/**
	 * @param userID  当前登录用户ＩＤ
	 * @param orderState	  查询什么类型的住宿酒店记录   
	 * @return
	 */
	public Set<Integer> hotelRecord(int userID,OrderStateMessage orderState);
	
	public HotelVO getHotelInfo(int hotelID);
	
	public ResultMessage addComment(CommentInfoVO commentInfoVO);
	


}