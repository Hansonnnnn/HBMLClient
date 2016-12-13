package presentation.view.promotionui;

import message.ResultMessage;
import vo.PromotionVO;

import java.util.ArrayList;

public class WebMarketerOfPromotionView {
	private PromotionViewControllerService controller;
	
	public WebMarketerOfPromotionView(PromotionViewControllerService controller){
		this.controller=controller;
	}
	
	public ResultMessage addWebPromotion(PromotionVO vo){
		return ResultMessage.success;
	}

	public ResultMessage deleteWebPromotion(PromotionVO vo){
		return ResultMessage.success;
	}

	public ResultMessage modifyWebPromotion(PromotionVO vo){
		return ResultMessage.success;
	}

	public PromotionVO showPromotion(){
		controller.showPromotion();
		return new PromotionVO("H00001");
	}

	public ArrayList<PromotionVO> showPromotionList(){
		controller.showPromotionList();
		return null;
	}
}
