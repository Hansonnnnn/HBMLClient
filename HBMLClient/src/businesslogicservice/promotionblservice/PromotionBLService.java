package businesslogicservice.promotionblservice;

/**
 * Created by alex on 16-10-16.
 */
import VO.HotelPromotionVO;
import VO.WebPromotionVO;

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
