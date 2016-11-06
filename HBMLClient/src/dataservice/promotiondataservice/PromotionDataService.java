package dataservice.promotiondataservice;

import po.CreditPO;
import po.HotelPromotionPO;
import po.WebPromotionPO;
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
