package businesslogicservice.promotionblservice;


import message.ResultMessage;
import model.PromotionFilter;
import vo.PromotionVO;

import java.util.Map;

public interface PromotionWebMarketerService {
	/**
	 * PromotionFilter filter =new PromotionFilter();
	 * 传filter
	 * @param promotionFilter
	 * @return
	 */
	public Map<Integer, PromotionVO> getWebPromotionList(PromotionFilter promotionFilter) throws Exception;

	public PromotionVO getPromotion(int promotionID);

	/**
	 * 添加网站营销策略，需要将信息写进一个新建VO里
	 * @param vo
	 * @return
	 */
	public ResultMessage addWebPromotion(PromotionVO vo)throws Exception;

	/**
	 * 获取促销信息VO对象，使用getID
	 * 调用此方法后，需要重新调用getWebPromotionList，并打印
	 * @param promotionID
	 * @return
	 */
	public ResultMessage deleteWebPromotion(int promotionID)throws Exception;

	/**
	 * 类似addWebPromotion,需要将信息写进一个新建VO里
	 * @param vo
	 * @return
	 */
	public ResultMessage modifyWebPromotion(PromotionVO vo)throws Exception;
}
