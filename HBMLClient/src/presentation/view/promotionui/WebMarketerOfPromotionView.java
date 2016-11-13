package presentation.view.promotionui;

import message.ResultMessage;
import po.WebPromotionPO;

public class WebMarketerOfPromotionView {
	private PromotionViewControllerService controller;
	
	public WebMarketerOfPromotionView(PromotionViewControllerService controller){
		this.controller=controller;
	}
	
	public ResultMessage addWebPromotion(WebPromotionPO po){
		return ResultMessage.success;
	}
	
	public ResultMessage modifyWebPromotion(WebPromotionPO po){
		return ResultMessage.success;
	}
}
