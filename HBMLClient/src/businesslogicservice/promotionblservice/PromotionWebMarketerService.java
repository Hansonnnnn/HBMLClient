package businesslogicservice.promotionblservice;


import message.ResultMessage;
import po.WebPromotionPO;

public interface PromotionWebMarketerService {
	public ResultMessage addWebPromotion(WebPromotionPO po);
	public ResultMessage modifyWebPromotion(WebPromotionPO po);
}
