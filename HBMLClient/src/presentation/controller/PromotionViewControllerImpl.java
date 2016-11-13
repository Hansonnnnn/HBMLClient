package presentation.controller;

import businesslogicservice.promotionblservice.PromotionCustemerService;
import businesslogicservice.promotionblservice.PromotionStaffService;
import businesslogicservice.promotionblservice.PromotionWebMarketerService;
import presentation.view.promotionui.PromotionViewControllerService;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public class PromotionViewControllerImpl implements PromotionViewControllerService{
	
	PromotionCustemerService promotionCustomerImpl;
	PromotionStaffService promotionStaffService;
	PromotionWebMarketerService promotionWebMarketerService;
	
	public PromotionViewControllerImpl(PromotionCustemerService promotionCustemerService) {
		this.promotionCustomerImpl=promotionCustemerService;
	}
	
	public PromotionViewControllerImpl(PromotionStaffService promotionStaffService) {
		this.promotionStaffService=promotionStaffService;
	}
	
	public PromotionViewControllerImpl(PromotionWebMarketerService promotionWebMarketerService) {
		this.promotionWebMarketerService=promotionWebMarketerService;
	}
	
	@Override
	public void showPromotion() {
		
	}

	@Override
	public void showPromotionList() {
		
	}

	@Override
	public boolean addPromotion(HotelPromotionVO hotelPromotionVO) {
		return false;
	}

	@Override
	public boolean addPromotion(WebPromotionVO webPromotionVO) {
		return false;
	}

	@Override
	public boolean deletePromotion(String ID) {
		return false;
	}

	@Override
	public boolean modify(HotelPromotionVO hotelPromotionVO) {
		return false;
	}

	@Override
	public boolean modify(WebPromotionVO webPromotionVO) {
		return false;
	}

	@Override
	public HotelPromotionVO getHotelPromotionVO() {
		return null;
	}

	@Override
	public WebPromotionVO getWebPromotionVO() {
		return null;
	}

}
