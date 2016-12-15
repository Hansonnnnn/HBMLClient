package businesslogicservice.promotionblservice;

import message.ResultMessage;
import model.PromotionFilter;
import vo.PromotionVO;

import java.util.Map;

public interface PromotionStaffService {

	public Map<Integer, PromotionVO> getHotelPromotionList(PromotionFilter promotionFilter);

	public PromotionVO getPromotion(int promotionID);

	/**
	 * 如果传入vo的name属性为"0"，代表客户生日优惠; 如果是"1",代表合作企业折扣
	 * @param vo
	 * @return
	 */
	public ResultMessage addHotelPromotion(PromotionVO vo);

	public ResultMessage deleteHotelPromotion(int promotionID);

	public ResultMessage modifyHotelPromotion(PromotionVO vo);
}
