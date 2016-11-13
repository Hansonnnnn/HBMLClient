package model;

/**
 * Created by alex on 16-11-13.
 */
public enum PromotionType {
    HotelPromotion,
    WebPromotion,
    NoSuchPromotion;
    public PromotionType getPromotionType(String promotionid){
        if(promotionid.charAt(0)=='H'){
            return PromotionType.HotelPromotion;
        }else if(promotionid.charAt(0)=='W'){
            return PromotionType.WebPromotion;
        }else return PromotionType.NoSuchPromotion;
    }
}
