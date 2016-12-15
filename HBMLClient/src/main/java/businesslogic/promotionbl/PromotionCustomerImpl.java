package businesslogic.promotionbl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import businesslogic.utility.TransferImpl;
import businesslogicservice.promotionblservice.PromotionCustomerService;
import model.PromotionFilter;
import vo.OrderVO;
import vo.PromotionVO;
import vo.SelectedPromotionVO;

public class PromotionCustomerImpl implements PromotionCustomerService {


	@Override
	public Map<Integer, PromotionVO> getHotelPromotionList(PromotionFilter promotionFilter) {
		return null;
	}

	@Override
	public Map<Integer, PromotionVO> getWebPromotionList(PromotionFilter promotionFilter) {
		return null;
	}

	@Override
	public PromotionVO getPromotion(int promotionID) {
		return null;
	}

	@Override
	public SelectedPromotionVO getSelectedPromotion(OrderVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
}
