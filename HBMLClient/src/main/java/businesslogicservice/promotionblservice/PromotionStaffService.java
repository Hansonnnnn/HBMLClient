package businesslogicservice.promotionblservice;

import message.ResultMessage;
import model.PromotionFilter;
import vo.PromotionVO;

import java.util.Map;

public interface PromotionStaffService {

	public Map<Integer, PromotionVO> getHotelPromotionList(PromotionFilter promotionFilter)throws Exception;

	public PromotionVO getPromotion(int promotionID);

	/**
	 *
	 * @param vo
	 * @return
	 */
	public ResultMessage addHotelPromotion(PromotionVO vo)throws Exception;

	public ResultMessage deleteHotelPromotion(int promotionID)throws Exception;

	public ResultMessage modifyHotelPromotion(PromotionVO vo)throws Exception;
}
