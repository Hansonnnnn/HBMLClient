package businesslogicservice.promotionblservice;

import message.ResultMessage;
import model.PromotionFilter;
import vo.PromotionVO;

import java.util.Map;

public interface PromotionStaffService {

	public Map<Integer, PromotionVO> getHotelPromotionList(PromotionFilter promotionFilter);

	public PromotionVO getPromotion(int promotionID);

	/**
	 *
	 * @param vo
	 * @return
	 */
	public ResultMessage addHotelPromotion(PromotionVO vo);

	public ResultMessage deleteHotelPromotion(int promotionID);

	public ResultMessage modifyHotelPromotion(PromotionVO vo);
}
