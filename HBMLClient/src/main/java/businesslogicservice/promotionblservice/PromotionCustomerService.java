package businesslogicservice.promotionblservice;

import model.PromotionFilter;
import vo.PromotionVO;

import java.util.Map;


public interface PromotionCustomerService {
	/**
	 * 注意没有getPromotionList方法，只能获得酒店促销策略列表或网站促销策略列表的一种
	 * 传入参数可以直接通过PromotionFilter promotionFilter=new PromotionFilter(); 把promotionFilter传入
	 * @param promotionFilter
	 * @return
	 */
	public Map<Integer, PromotionVO> getHotelPromotionList(PromotionFilter promotionFilter);

	public Map<Integer, PromotionVO> getWebPromotionList(PromotionFilter promotionFilter);

	public PromotionVO getPromotion(int promotionID);
}
