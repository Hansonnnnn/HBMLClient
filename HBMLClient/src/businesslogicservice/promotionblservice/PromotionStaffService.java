package businesslogicservice.promotionblservice;

import message.ResultMessage;
import po.HotelPromotionPO;

public interface PromotionStaffService {
	public ResultMessage addHotelPromotion(HotelPromotionPO po);
	public ResultMessage modifyHotelPromotion(HotelPromotionPO po);
}
