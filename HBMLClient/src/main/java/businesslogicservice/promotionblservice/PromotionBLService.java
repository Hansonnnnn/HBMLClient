package businesslogicservice.promotionblservice;

import businesslogic.promotionbl.Promotion;
import vo.PromotionVO;

public interface PromotionBLService {
    public void showPromotion();
    public void showPromotionList();
    public boolean addPromotion(PromotionVO promotion);
    public boolean deletePromotion(String ID);
    public boolean modify(PromotionVO promotion);
    public PromotionVO getPromotionVO();
}
