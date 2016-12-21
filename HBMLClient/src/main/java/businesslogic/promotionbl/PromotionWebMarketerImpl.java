package businesslogic.promotionbl;

import businesslogic.promotionbl.helper.PromotionHelper;
import businesslogicservice.promotionblservice.PromotionWebMarketerService;
import message.ResultMessage;
import model.PromotionFilter;
import vo.PromotionVO;

import java.util.Map;

public class PromotionWebMarketerImpl implements PromotionWebMarketerService{

	PromotionHelper promotionHelper;

	public PromotionWebMarketerImpl() {
		promotionHelper=new PromotionHelper();
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
	public ResultMessage addWebPromotion(PromotionVO vo){

		return promotionHelper.addWebPromotion(vo);

	}

	@Override
	public ResultMessage deleteWebPromotion(int promotionID){

		return promotionHelper.deleteWebPromotion(promotionID);

	}

	@Override
	public ResultMessage modifyWebPromotion(PromotionVO vo){

		return promotionHelper.modifyWebPromotion(vo);
	}
}
