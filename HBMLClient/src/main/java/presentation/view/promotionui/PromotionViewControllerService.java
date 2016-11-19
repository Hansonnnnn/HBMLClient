package presentation.view.promotionui;

import message.ResultMessage;
import vo.PromotionVO;

import java.util.List;

public interface PromotionViewControllerService {
	public PromotionVO showPromotion();
    public List<PromotionVO> showPromotionList();
    public ResultMessage addPromotion(PromotionVO promotionVO);
    public ResultMessage deletePromotion(String ID);
    public ResultMessage modify(PromotionVO promotionVO);
}
