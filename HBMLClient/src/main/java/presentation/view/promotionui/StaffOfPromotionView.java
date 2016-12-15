package presentation.view.promotionui;

import message.ResultMessage;
import vo.PromotionVO;

import java.util.ArrayList;

public class StaffOfPromotionView {
	PromotionViewControllerService controller;
	
	public StaffOfPromotionView(PromotionViewControllerService controller){
		this.controller=controller;
	}
	
	public ResultMessage addHotelPromotion(PromotionVO vo){
		return ResultMessage.success;
	}
	
	public ResultMessage deleteHotelPromotion(PromotionVO vo){
		return ResultMessage.success;
	}

	public ResultMessage modifyHotelPromotion(PromotionVO vo){
		return ResultMessage.success;
	}

	public PromotionVO showPromotion(){
		controller.showPromotion();
		return null;
	}

	public ArrayList<PromotionVO> showPromotionList(){
		controller.showPromotionList();
		return null;
	}
}
