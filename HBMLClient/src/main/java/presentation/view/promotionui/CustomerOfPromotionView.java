package presentation.view.promotionui;

import vo.PromotionVO;

import java.util.ArrayList;

public class CustomerOfPromotionView {
	
	PromotionViewControllerService controller;
	
	public CustomerOfPromotionView(PromotionViewControllerService controller){
		this.controller=controller;
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
