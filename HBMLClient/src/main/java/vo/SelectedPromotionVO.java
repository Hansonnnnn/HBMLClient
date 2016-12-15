package vo;

import model.DiscountType;
import model.PromotionType;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by alex on 12/15/16.
 */
public class SelectedPromotionVO extends PromotionVO implements Serializable{


    private static final long serialVersionUID = 5713819000515788978L;
    PromotionVO promotionVO;
    long price;


    public SelectedPromotionVO(int promotionID, PromotionType promotionType, int region, String name, String content, Date startDate, Date endDate, int minRankAvailable, int maxRankAvailable, DiscountType type, int condition, int discount,long price) {
        super(promotionID, promotionType, region, name, content, startDate, endDate, minRankAvailable, maxRankAvailable, type, condition, discount);
        this.promotionVO=new PromotionVO(promotionID, promotionType, region, name, content, startDate, endDate, minRankAvailable, maxRankAvailable, type, condition, discount);
        this.price=price;
    }

    public SelectedPromotionVO(PromotionType promotionType, int region, String name, String content, Date startDate, Date endDate, int rank, DiscountType type, int condition, int discount,long price) {
        super(promotionType, region, name, content, startDate, endDate, rank, type, condition, discount);
        this.promotionVO=new PromotionVO(promotionType, region, name, content, startDate, endDate, rank, type, condition, discount);
        this.price=price;
    }

    public SelectedPromotionVO(int region, String name, String content, Date startDate, Date endDate, int rank, DiscountType type, int condition, int discount,long price) {
        super(region, name, content, startDate, endDate, rank, type, condition, discount);
        this.promotionVO=new PromotionVO(region, name, content, startDate, endDate, rank, type, condition, discount);
        this.price=price;
    }

    public SelectedPromotionVO(int region, int discount, int type,long price) {
        super(region, discount, type);
        this.promotionVO=new PromotionVO(region, discount, type);
        this.price=price;
    }

    public SelectedPromotionVO(String name, String content, Date startDate, Date endDate, int rank, DiscountType type, int condition, int discount,long price) {
        super(name, content, startDate, endDate, rank, type, condition, discount);
        this.promotionVO=new PromotionVO(name, content, startDate, endDate, rank, type, condition, discount);
        this.price=price;
    }

    public SelectedPromotionVO(int region, int discount, int minRank, int maxRank,long price) {
        super(region, discount, minRank, maxRank);
        this.promotionVO=new PromotionVO(region, discount, minRank, maxRank);
        this.price=price;
    }

    public PromotionVO getPromotionVO() {
        return promotionVO;
    }

    public long getPrice() {
        return price;
    }
}
