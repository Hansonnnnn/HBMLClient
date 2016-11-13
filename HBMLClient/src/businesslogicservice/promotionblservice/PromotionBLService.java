package businesslogicservice.promotionblservice;

import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public interface PromotionBLService {
    public void showPromotion();
    public void showPromotionList();
    public boolean addPromotion(HotelPromotionVO hotelPromotionVO);
    public boolean addPromotion(WebPromotionVO webPromotionVO);
    public boolean deletePromotion(String ID);
    public boolean modify(HotelPromotionVO hotelPromotionVO);
    public boolean modify(WebPromotionVO webPromotionVO);
    public HotelPromotionVO getHotelPromotionVO();
    public WebPromotionVO getWebPromotionVO();
    
}
