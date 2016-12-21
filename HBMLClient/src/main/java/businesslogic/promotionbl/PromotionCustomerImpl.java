package businesslogic.promotionbl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import businesslogic.promotionbl.helper.PromotionHelper;
import businesslogic.utility.TransferImpl;
import businesslogicservice.promotionblservice.PromotionCustomerService;
import model.PromotionFilter;
import vo.OrderVO;
import vo.PromotionVO;
import vo.SelectedPromotionVO;

public class PromotionCustomerImpl implements PromotionCustomerService {

	PromotionHelper promotionHelper;

	public PromotionCustomerImpl() {

		promotionHelper=new PromotionHelper();

	}


	@Override
	public Map<Integer, PromotionVO> getHotelPromotionList(PromotionFilter promotionFilter){

		return promotionHelper.getHotelPromotionList(promotionFilter);

	}

	@Override
	public Map<Integer, PromotionVO> getWebPromotionList(PromotionFilter promotionFilter){

		return promotionHelper.getWebPromotionList(promotionFilter);

	}

	@Override
	public PromotionVO getPromotion(int promotionID) {

		return promotionHelper.getPromotion(promotionID);

	}

	@Override
	public SelectedPromotionVO getSelectedPromotion(OrderVO vo){
		// TODO Auto-generated method stub
		return promotionHelper.getSelectedPromotion(vo);

	}

}
