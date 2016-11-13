package presentation.view.promotionui;

import java.util.ArrayList;

import po.WebPromotionPO;
import vo.WebPromotionVO;

public class CustomerOfPromotionView {
	
	PromotionViewControllerService controller;
	
	public CustomerOfPromotionView(PromotionViewControllerService controller){
		this.controller=controller;
	}
	
	public WebPromotionPO showPromotion(){
		controller.showPromotion();
		return new WebPromotionPO(null,null,null);
	}
	
	public ArrayList<WebPromotionVO> showPromotionList(){
		controller.showPromotionList();
		return null;
	}
}
