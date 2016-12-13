package presentation.controller;

import businesslogic.utility.TransferImpl;
import businesslogicservice.promotionblservice.PromotionCustomerService;
import businesslogicservice.promotionblservice.PromotionStaffService;
import businesslogicservice.promotionblservice.PromotionWebMarketerService;
import message.ResultMessage;
import model.PromotionFilter;
import model.PromotionType;
import model.PromotionTypeHelper;
import presentation.view.promotionui.PromotionViewControllerService;
import vo.PromotionVO;

import java.util.ArrayList;

public class PromotionViewControllerImpl implements PromotionViewControllerService{
	
	PromotionCustomerService promotionCustomerImpl;
	PromotionStaffService promotionStaffService;
	PromotionWebMarketerService promotionWebMarketerService;
	
	public PromotionViewControllerImpl(PromotionCustomerService promotionCustemerService) {
		this.promotionCustomerImpl=promotionCustemerService;
	}
	
	public PromotionViewControllerImpl(PromotionStaffService promotionStaffService) {
		this.promotionStaffService=promotionStaffService;
	}
	
	public PromotionViewControllerImpl(PromotionWebMarketerService promotionWebMarketerService) {
		this.promotionWebMarketerService=promotionWebMarketerService;
	}
	
	@Override
	public PromotionVO showPromotion() {
		return this.promotionCustomerImpl.getPromotion(0);
	}

	@Override
	public ArrayList<PromotionVO> showPromotionList() {
		PromotionFilter filter=new PromotionFilter();
		return null;
	}

	@Override
	public ResultMessage addPromotion(PromotionVO promotionVO) {
		TransferImpl transfer=new TransferImpl();
		PromotionTypeHelper promotionTypeHelper=new PromotionTypeHelper();
		if(promotionTypeHelper.getPromotionType(promotionVO.getPromotionID()).equals(PromotionType.HotelPromotion)){
			return this.promotionStaffService.addHotelPromotion(promotionVO);
		}else if(promotionTypeHelper.getPromotionType(promotionVO.getPromotionID()).equals(PromotionType.WebPromotion)){
			return this.promotionWebMarketerService.addWebPromotion(promotionVO);
		}else return ResultMessage.failure;
	}

	@Override
	public ResultMessage deletePromotion(int ID) {
		TransferImpl transfer=new TransferImpl();
		PromotionTypeHelper promotionTypeHelper=new PromotionTypeHelper();
		if(promotionTypeHelper.getPromotionType(ID).equals(PromotionType.HotelPromotion)){
			return this.promotionStaffService.deleteHotelPromotion(ID);
		}else if(promotionTypeHelper.getPromotionType(ID).equals(PromotionType.WebPromotion)){
			return this.promotionWebMarketerService.deleteWebPromotion(ID);
		}else return ResultMessage.failure;
	}

	@Override
	public ResultMessage modify(PromotionVO promotionVO) {
		TransferImpl transfer=new TransferImpl();
		PromotionTypeHelper promotionTypeHelper=new PromotionTypeHelper();
		if(promotionTypeHelper.getPromotionType(promotionVO.getPromotionID()).equals(PromotionType.HotelPromotion)){
			return this.promotionStaffService.modifyHotelPromotion(promotionVO);
		}else if(promotionTypeHelper.getPromotionType(promotionVO.getPromotionID()).equals(PromotionType.WebPromotion)){
			return this.promotionWebMarketerService.modifyWebPromotion(promotionVO);
		}else return ResultMessage.failure;
	}
}
