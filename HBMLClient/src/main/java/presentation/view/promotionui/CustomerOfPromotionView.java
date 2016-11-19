package presentation.view.promotionui;

import java.util.ArrayList;
import vo.PromotionVO;

public class CustomerOfPromotionView {
	
	PromotionViewControllerService controller;
	
	public CustomerOfPromotionView(PromotionViewControllerService controller){
		this.controller=controller;
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
