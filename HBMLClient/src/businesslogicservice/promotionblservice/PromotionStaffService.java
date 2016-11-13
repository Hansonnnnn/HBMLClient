package businesslogicservice.promotionblservice;

import message.ResultMessage;
import po.PromotionPO;

public interface PromotionStaffService {
	public ResultMessage addPromotion(PromotionPO po);
	public ResultMessage modifyPromotion(PromotionPO po);
}
