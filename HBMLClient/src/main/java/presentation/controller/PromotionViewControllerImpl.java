package presentation.controller;

import businesslogic.utility.TransferImpl;
import businesslogicservice.promotionblservice.PromotionCustomerService;
import businesslogicservice.promotionblservice.PromotionStaffService;
import businesslogicservice.promotionblservice.PromotionWebMarketerService;
import message.ResultMessage;
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
		return this.promotionCustomerImpl.showPromotion();
	}

	@Override
	public ArrayList<PromotionVO> showPromotionList() {
		return this.promotionCustomerImpl.showPromotionList();
	}

	@Override
	public ResultMessage addPromotion(PromotionVO promotionVO) {
		TransferImpl transfer=new TransferImpl();
		PromotionTypeHelper promotionTypeHelper=new PromotionTypeHelper();
		if(promotionTypeHelper.getPromotionType(promotionVO.getId()).equals(PromotionType.HotelPromotion)){
			return this.promotionStaffService.addPromotion(transfer.voToPo(promotionVO));
		}else if(promotionTypeHelper.getPromotionType(promotionVO.getId()).equals(PromotionType.WebPromotion)){
			return this.promotionWebMarketerService.addPromotion(transfer.voToPo(promotionVO));
		}else return ResultMessage.failure;
	}

	@Override
	public ResultMessage deletePromotion(String ID) {
		TransferImpl transfer=new TransferImpl();
		PromotionTypeHelper promotionTypeHelper=new PromotionTypeHelper();
		if(promotionTypeHelper.getPromotionType(ID).equals(PromotionType.HotelPromotion)){
			return this.promotionStaffService.deletePromotion(ID);
		}else if(promotionTypeHelper.getPromotionType(ID).equals(PromotionType.WebPromotion)){
			return this.promotionWebMarketerService.deletePromotion(ID);
		}else return ResultMessage.failure;
	}

	@Override
	public ResultMessage modify(PromotionVO promotionVO) {
		TransferImpl transfer=new TransferImpl();
		PromotionTypeHelper promotionTypeHelper=new PromotionTypeHelper();
		if(promotionTypeHelper.getPromotionType(promotionVO.getId()).equals(PromotionType.HotelPromotion)){
			return this.promotionStaffService.modifyPromotion(transfer.voToPo(promotionVO));
		}else if(promotionTypeHelper.getPromotionType(promotionVO.getId()).equals(PromotionType.WebPromotion)){
			return this.promotionWebMarketerService.modifyPromotion(transfer.voToPo(promotionVO));
		}else return ResultMessage.failure;
	}
}
