package driver;

import businesslogicservice.promotionblservice.PromotionCustomerService;
import businesslogicservice.promotionblservice.PromotionStaffService;
import businesslogicservice.promotionblservice.PromotionWebMarketerService;
import po.PromotionPO;
import vo.PromotionVO;

public class PromotionBLService_Driver {
	
	private PromotionVO PromotonVO=new PromotionVO("0001");
	
	
	public void drive(PromotionBLService promotionBLService,PromotionCustomerService promotionCustemerService,
			PromotionStaffService promotionStaffService,PromotionWebMarketerService promotionWebMarketerService){
		
		promotionBLService.showPromotion();
		promotionBLService.showPromotionList();
		promotionBLService.addPromotion(new PromotionVO("W01"));
		promotionBLService.addPromotion(new PromotionVO("H02"));
		promotionBLService.deletePromotion("W01");
		promotionBLService.modify(new PromotionVO("H02"));
		promotionBLService.modify(new PromotionVO("W01"));
		promotionBLService.getPromotionVO();
		promotionCustemerService.showPromotion();
		promotionCustemerService.showPromotionList();
		promotionStaffService.addPromotion(new PromotionPO("W01"));
		promotionStaffService.modifyPromotion(new PromotionPO("H02"));
		
	}
}
