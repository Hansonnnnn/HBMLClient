package businesslogic.promotionbl;

import businesslogic.promotionbl.helper.PromotionHelper;
import businesslogicservice.promotionblservice.PromotionStaffService;
import message.ResultMessage;
import model.PromotionFilter;
import model.PromotionType;
import vo.PromotionVO;

import java.util.Map;

public class PromotionStaffImpl implements PromotionStaffService{

	PromotionHelper promotionHelper;

	public PromotionStaffImpl() {

		promotionHelper=new PromotionHelper();

	}


	@Override
	public Map<Integer, PromotionVO> getHotelPromotionList(PromotionFilter promotionFilter) throws Exception{

		return promotionHelper.getHotelPromotionList(promotionFilter);

	}

	@Override
	public PromotionVO getPromotion(int promotionID) {

		PromotionVO promotionVO=promotionHelper.getPromotion(promotionID);
		if(promotionVO.getPromotionType().equals(PromotionType.HotelPromotion)) return promotionVO;
		else return null;

	}

	@Override
	public ResultMessage addHotelPromotion(PromotionVO vo) throws Exception{

		return promotionHelper.addHotelPromotion(vo);
	}

	@Override
	public ResultMessage deleteHotelPromotion(int promotionID) throws Exception{

		return promotionHelper.deleteHotelPromotion(promotionID);

	}

	@Override
	public ResultMessage modifyHotelPromotion(PromotionVO vo) throws Exception{

		return promotionHelper.modifyWebPromotion(vo);

	}
}
