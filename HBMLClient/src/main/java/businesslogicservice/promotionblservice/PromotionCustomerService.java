package businesslogicservice.promotionblservice;

import model.PromotionFilter;
import vo.PromotionVO;

import java.util.Map;


public interface PromotionCustomerService {

	public Map<Integer, PromotionVO> getHotelPromotionList(PromotionFilter promotionFilter);

	public Map<Integer, PromotionVO> getWebPromotionList(PromotionFilter promotionFilter);

	public PromotionVO getPromotion(int promotionID);
}
