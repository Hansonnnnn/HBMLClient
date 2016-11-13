package presentation.view.promotionui;

import message.ResultMessage;
import po.HotelPromotionPO;

public class StaffOfPromotionView {
	PromotionViewControllerService controller;
	
	public StaffOfPromotionView(PromotionViewControllerService controller){
		this.controller=controller;
	}
	
	public ResultMessage addHotelPromotion(HotelPromotionPO po){
		return ResultMessage.success;
	}
	
	public ResultMessage modifyHotelPromotion(HotelPromotionPO po){
		return ResultMessage.success;
	}
}
