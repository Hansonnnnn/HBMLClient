package driver;

import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.promotionblservice.PromotionCustemerService;
import businesslogicservice.promotionblservice.PromotionStaffService;
import businesslogicservice.promotionblservice.PromotionWebMarketerService;
import po.HotelPromotionPO;
import po.WebPromotionPO;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public class PromotionBLService_Driver {
	
	private HotelPromotionVO hotelPromotonVO=new HotelPromotionVO("monday hotel", null, 0);
	
	private WebPromotionVO webPromotionVO=new WebPromotionVO("discount", "Singles'Day", null);
	
	public void drive(PromotionBLService promotionBLService,PromotionCustemerService promotionCustemerService,
			PromotionStaffService promotionStaffService,PromotionWebMarketerService promotionWebMarketerService){
		
		promotionBLService.showPromotion();
		promotionBLService.showPromotionList();
		promotionBLService.addPromotion(hotelPromotonVO);
		promotionBLService.addPromotion(webPromotionVO);
		promotionBLService.deletePromotion("0001");
		promotionBLService.modify(hotelPromotonVO);
		promotionBLService.modify(webPromotionVO);
		promotionBLService.getHotelPromotionVO();
		promotionBLService.getWebPromotionVO();
		promotionCustemerService.showWebPromotion();
		promotionCustemerService.showWebPromotionList();
		promotionCustemerService.showHotelPromotion();
		promotionCustemerService.showHotelPromotionList();
		promotionStaffService.addHotelPromotion(new HotelPromotionPO("xianlin hotel", null));
		promotionStaffService.modifyHotelPromotion(new HotelPromotionPO("nanjing hotel", null));
		promotionWebMarketerService.addWebPromotion(new WebPromotionPO("discount", "National Day", null));
		promotionWebMarketerService.modifyWebPromotion(new WebPromotionPO("discount", "National Day", null));
		
	}
}
