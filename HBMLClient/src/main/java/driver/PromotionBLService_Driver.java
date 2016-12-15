package driver;

import businesslogicservice.promotionblservice.PromotionCustomerService;
import businesslogicservice.promotionblservice.PromotionStaffService;
import businesslogicservice.promotionblservice.PromotionWebMarketerService;
import model.DiscountTypeHelper;
import model.PromotionFilter;
import model.PromotionType;
import vo.PromotionVO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PromotionBLService_Driver {
	
	public void drive(PromotionCustomerService promotionCustomerService, PromotionStaffService promotionStaffService,PromotionWebMarketerService promotionWebMarketerService)throws Exception
	{
		//testing promotionCustomerService
		PromotionFilter promotionFilter=new PromotionFilter();
		promotionCustomerService.getWebPromotionList(promotionFilter);
		promotionCustomerService.getHotelPromotionList(promotionFilter);
		promotionCustomerService.getPromotion(1);

		//testing promotionStaffService
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date1=simpleDateFormat.parse("2017-11-11");
		Date date2=simpleDateFormat.parse("2017-11-15");
		DiscountTypeHelper discountTypeHelper=new DiscountTypeHelper();
		PromotionVO promotionVO=new PromotionVO(0, PromotionType.HotelPromotion,2,"double 11 promotion","all 50% off!!!",date1,date2,1,10,discountTypeHelper.getDiscountType(1),0,50);
		promotionStaffService.getPromotion(1);
		promotionStaffService.getHotelPromotionList(promotionFilter);
		promotionStaffService.addHotelPromotion(promotionVO);
		promotionStaffService.deleteHotelPromotion(1);
		promotionStaffService.modifyHotelPromotion(promotionVO);

		//testing promotionWebMarketerService
		PromotionVO promotionVO2=new PromotionVO(0, PromotionType.WebPromotion,2,"double 11 promotion","all 50% off!!!",date1,date2,1,10,discountTypeHelper.getDiscountType(1),0,50);
		promotionWebMarketerService.getPromotion(1);
		promotionWebMarketerService.addWebPromotion(promotionVO2);
		promotionWebMarketerService.deleteWebPromotion(1);
		promotionWebMarketerService.getWebPromotionList(promotionFilter);
		promotionWebMarketerService.modifyWebPromotion(promotionVO2);


	}
}
