package presentation.view.promotionui;

import message.ResultMessage;
import vo.PromotionVO;

import java.util.List;

public interface PromotionViewControllerService {
	public PromotionVO showPromotion();
    public List<PromotionVO> showPromotionList();
    public ResultMessage addPromotion(PromotionVO promotionVO)throws Exception;
    public ResultMessage deletePromotion(int ID)throws Exception;
    public ResultMessage modify(PromotionVO promotionVO) throws Exception;
}
