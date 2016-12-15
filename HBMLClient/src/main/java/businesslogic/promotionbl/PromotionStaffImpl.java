package businesslogic.promotionbl;

import businesslogicservice.promotionblservice.PromotionStaffService;
import message.ResultMessage;
import model.PromotionFilter;
import vo.PromotionVO;

import java.util.Map;

public class PromotionStaffImpl implements PromotionStaffService{


	@Override
	public Map<Integer, PromotionVO> getHotelPromotionList(PromotionFilter promotionFilter) {
		return null;
	}

	@Override
	public PromotionVO getPromotion(int promotionID) {
		return null;
	}

	@Override
	public ResultMessage addHotelPromotion(PromotionVO vo) {
		return null;
	}

	@Override
	public ResultMessage deleteHotelPromotion(int promotionID) {
		return null;
	}

	@Override
	public ResultMessage modifyHotelPromotion(PromotionVO vo) {
		return null;
	}
}
