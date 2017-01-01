package businesslogicservice.promotionblservice;

import model.PromotionFilter;
import vo.OrderVO;
import vo.PromotionVO;
import vo.SelectedPromotionVO;

import java.util.Map;


public interface PromotionCustomerService {
	/**
	 * 获得酒店促销策略列表
	 * 注意没有getPromotionList方法，只能获得酒店促销策略列表或网站促销策略列表的一种
	 * 传入参数可以直接通过PromotionFilter promotionFilter=new PromotionFilter(); 把promotionFilter传入
	 * PromotionFilter的使用方法请参见Model包的PromotionFilter类
	 * @param promotionFilter
	 * @return
	 */
	public Map<Integer, PromotionVO> getHotelPromotionList(PromotionFilter promotionFilter);

	/**
	 * 获得网站促销策略列表
	 * PromotionFilter的使用方法请参见Model包的PromotionFilter类
	 * @param promotionFilter
	 * @return
	 */
	public Map<Integer, PromotionVO> getWebPromotionList(PromotionFilter promotionFilter);

	/**
	 * 根据promotionID类获得需要的promotion信息
	 * @param promotionID
	 * @return
	 */
	public PromotionVO getPromotion(int promotionID);

	/**
	 *　根据一个订单信息来检索所有该订单能够享受的促销策略，并计算最优惠策略
	 * @param vo		传入一个完整的OrderVO
	 * @return			返回的SelectedPromotionVO拥有getPrice()和getPromotionVO()方法
	 */
	public SelectedPromotionVO getSelectedPromotion(OrderVO vo);

}
