package businesslogic.promotionbl;

import businesslogicservice.promotionblservice.PromotionWebMarketerService;
import message.ResultMessage;
import model.PromotionFilter;
import vo.PromotionVO;

import java.util.Map;

public class PromotionWebMarketerImpl implements PromotionWebMarketerService{


	@Override
	public Map<Integer, PromotionVO> getWebPromotionList(PromotionFilter promotionFilter) {
		return null;
	}

	@Override
	public PromotionVO getPromotion(int promotionID) {
		return null;
	}

	@Override
	public ResultMessage addWebPromotion(PromotionVO vo) {
		return null;
	}

	@Override
	public ResultMessage deleteWebPromotion(int promotionID) {
		return null;
	}

	@Override
	public ResultMessage modifyWebPromotion(PromotionVO po) {
		return null;
	}
}
