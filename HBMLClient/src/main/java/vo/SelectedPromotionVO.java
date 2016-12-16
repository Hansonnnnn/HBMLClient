package vo;


/**
 * Created by alex on 12/15/16.
 */
public class SelectedPromotionVO{
    public SelectedPromotionVO(PromotionVO promotionVO,float price) {

        this.promotionVO=promotionVO;
        this.price=price;

    }

    PromotionVO promotionVO;
    float price;


    public PromotionVO getPromotionVO() {

        return promotionVO;

    }

    public float getPrice() {
        return price;
    }
}
