package dataservice.promotiondataservice;

import po.HotelPromotionPO;
import po.WebPromotionPO;

public class PromotionDataServiceMySqlImpl_Stub implements PromotionDataService{

    public PromotionDataServiceMySqlImpl_Stub() {
    }

    @Override
    public void insert(HotelPromotionPO hotelPromotionPO) {
        System.out.println("hotel promotion successfully inserted!");
    }

    @Override
    public void insert(WebPromotionPO webPromotionPO) {
        System.out.println("web promotion successfully inserted!");
    }

    @Override
    public void delete(HotelPromotionPO hotelPromotionPO) {
        System.out.println("hotel promotion successfully deleted!");
    }

    @Override
    public void delete(WebPromotionPO webPromotionPO) {
        System.out.println("web promotion successfully deleted!");
    }

    @Override
    public void update(HotelPromotionPO hotelPromotionPO) {
        System.out.println("hotel promotion successfully updated!");
    }

    @Override
    public void update(WebPromotionPO webPromotionPO) {
        System.out.println("web promotion successfully updated!");
    }

    @Override
    public HotelPromotionPO findHotelPromotionPO(String id) {
        return new HotelPromotionPO("MOTEL168","free for newcomers");
    }

    @Override
    public WebPromotionPO findWebPromotionPO(String id) {
        return new WebPromotionPO("activity","double 11","free for all newcomers");
    }
}
