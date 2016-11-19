package presentation.view.promotionui;

import businesslogic.promotionbl.Promotion;
import message.ResultMessage;
import model.PromotionType;
import model.PromotionTypeHelper;
import vo.PromotionVO;

import java.util.ArrayList;

public class PromotionViewControllerService_Stub implements PromotionViewControllerService{

	@Override
	public PromotionVO showPromotion() {
		// TODO 自动生成的方法存根
		System.out.println("show Promotion success");
		return new PromotionVO("H00001");
	}

	@Override
	public ArrayList<PromotionVO> showPromotionList() {
		// TODO 自动生成的方法存根
		ArrayList<PromotionVO> promotionVOs=new ArrayList<PromotionVO>();
		promotionVOs.add(new PromotionVO("H00001"));
		promotionVOs.add(new PromotionVO("H00002"));
		promotionVOs.add(new PromotionVO("H00003"));
		promotionVOs.add(new PromotionVO("H00004"));
		System.out.println("show PromotionList success");
		return promotionVOs;
	}

	@Override
	public ResultMessage addPromotion(PromotionVO promotionVO) {
		// TODO 自动生成的方法存根
		PromotionTypeHelper promotionTypeHelper=new PromotionTypeHelper();
		if(promotionTypeHelper.getPromotionType(promotionVO.getId()).equals(PromotionType.HotelPromotion)){
			System.out.println("add HotelPromotion success");
			return ResultMessage.success;
		}else if(promotionTypeHelper.getPromotionType(promotionVO.getId()).equals(PromotionType.WebPromotion)){
			System.out.println("add WebPromotion success");
			return ResultMessage.success;
		}
		System.out.println("add promotion failed");
		return ResultMessage.failure;
	}

	@Override
	public ResultMessage deletePromotion(String ID) {
		// TODO 自动生成的方法存根
		PromotionTypeHelper promotionTypeHelper=new PromotionTypeHelper();
		if(promotionTypeHelper.getPromotionType(ID).equals(PromotionType.HotelPromotion)){
			System.out.println("delete HotelPromotion success");
			return ResultMessage.success;
		}else if(promotionTypeHelper.getPromotionType(ID).equals(PromotionType.WebPromotion)){
			System.out.println("delete WebPromotion success");
			return ResultMessage.success;
		}
		System.out.println("delete Promotion failed");
		return ResultMessage.failure;
	}

	@Override
	public ResultMessage modify(PromotionVO promotionVO) {
		// TODO 自动生成的方法存根
		PromotionTypeHelper promotionTypeHelper=new PromotionTypeHelper();
		if(promotionTypeHelper.getPromotionType(promotionVO.getId()).equals(PromotionType.HotelPromotion)){
			System.out.println("modify HotelPromotion success");
			return ResultMessage.success;
		}else if(promotionTypeHelper.getPromotionType(promotionVO.getId()).equals(PromotionType.WebPromotion)){
			System.out.println("modify WebPromotion success");
			return ResultMessage.success;
		}
		System.out.println("modify promotion failed");
		return ResultMessage.failure;
	}

}
