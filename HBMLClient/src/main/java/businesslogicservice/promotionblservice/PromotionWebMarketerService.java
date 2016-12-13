package businesslogicservice.promotionblservice;


import message.ResultMessage;
import model.PromotionFilter;
import vo.PromotionVO;

import java.util.Map;

public interface PromotionWebMarketerService {

	public Map<Integer, PromotionVO> getWebPromotionList(PromotionFilter promotionFilter);

	public PromotionVO getPromotion(int promotionID);

	public ResultMessage addWebPromotion(PromotionVO vo);

	public ResultMessage deleteWebPromotion(int promotionID);

	public ResultMessage modifyWebPromotion(PromotionVO po);
}
