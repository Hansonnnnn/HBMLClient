package dataservice.promotiondataservice;

/**
 * Created by alex on 16-10-16.
 */
import PO.CreditPO;
import PO.HotelPromotionPO;
import PO.WebPromotionPO;
public interface PromotionDataService {
    public void insert(HotelPromotionPO hotelPromotionPO);
    public void insert(WebPromotionPO webPromotionPO);
    public void delete(HotelPromotionPO hotelPromotionPO);
    public void delete(WebPromotionPO webPromotionPO);
    public void update(HotelPromotionPO hotelPromotionPO);
    public void update(WebPromotionPO webPromotionPO);
    public HotelPromotionPO findHotelPromotionPO(String id);
    public WebPromotionPO findWebPromotionPO(String id);
}
