package vo;
import model.DateHelper;
import model.DiscountType;
import model.PromotionType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alex on 16-11-17.
 */
public class PromotionVO{
    public DateHelper getDateHelper() {
		return dateHelper;
	}

	public void setDateHelper(DateHelper dateHelper) {
		this.dateHelper = dateHelper;
	}

	public void setPromotionID(int promotionID) {
		this.promotionID = promotionID;
	}

	public void setPromotionType(PromotionType promotionType) {
		this.promotionType = promotionType;
	}

	public void setRegion(int region) {
		this.region = region;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setStartDateString(String startDateString) {
		this.startDateString = startDateString;
	}

	public void setEndDateString(String endDateString) {
		this.endDateString = endDateString;
	}

	public void setMinRankAvailable(int minRankAvailable) {
		this.minRankAvailable = minRankAvailable;
	}

	public void setMaxRankAvailable(int maxRankAvailable) {
		this.maxRankAvailable = maxRankAvailable;
	}

	public void setType(DiscountType type) {
		this.type = type;
	}

	public void setRequirement(int requirement) {
		this.requirement = requirement;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	DateHelper dateHelper=new DateHelper();

    int promotionID;
    PromotionType promotionType;
    int region;
    String name;
    String content;
    Date startDate;
    Date endDate;
    String startDateString;
    String endDateString;
    int minRankAvailable;
    int maxRankAvailable;
    DiscountType type;
    int requirement;
    int discount;

    //general constructor
    public PromotionVO(int promotionID, PromotionType promotionType, int region, String name, String content, Date startDate, Date endDate, int minRankAvailable, int maxRankAvailable, DiscountType type, int condition, int discount) {
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.region = region;
        this.name = name;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.minRankAvailable = minRankAvailable;
        this.maxRankAvailable = maxRankAvailable;
        this.type = type;
        this.requirement = condition;
        this.discount = discount;
        startDateString=dateHelper.dateToString(startDate);
        endDateString=dateHelper.dateToString(endDate);
    }

    //general constructor without promotionID, and the rank is unique
    /**
     * @param promotionType
     * @param region        如果是hotel promotion,这里放hotelID(需要从HotelVO读估计)，如果是web promotion,这里放regionID（需要从RegionVO读估计）
     * @param name
     * @param content
     * @param startDate
     * @param endDate
     * @param rank          会员等级
     * @param type          Manjian代表满减优惠类型，Dazhe代表折扣优惠类型
     * @param condition     如果是满减优惠类型，这里写满减的条件；如果是折扣优惠类型，填０就行
     * @param discount      折扣力度，如果是满减优惠类型，这里写减免的额度；如果是折扣优惠类型，填０－１００之间的数值代表打几折
     */
    public PromotionVO(PromotionType promotionType, int region, String name, String content, Date startDate, Date endDate, int rank, DiscountType type, int condition, int discount){
        this.promotionType = promotionType;
        this.region = region;
        this.name = name;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.minRankAvailable = rank;
        this.maxRankAvailable = rank;
        this.type = type;
        this.requirement = condition;
        this.discount = discount;
    }


    /// /伍俊你可以参照下面两个constructor来构造promotion:
    //这是普通hotel promotion

    /**
     *
     * @param region        这里填hotelID
     * @param name
     * @param content
     * @param startDate
     * @param endDate
     * @param rank
     * @param type
     * @param condition
     * @param discount
     */
    public PromotionVO(int region, String name, String content, Date startDate, Date endDate, int rank, DiscountType type, int condition, int discount){
        this.promotionType = PromotionType.HotelPromotion;
        this.region = region;
        this.name = name;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.minRankAvailable = rank;
        this.maxRankAvailable = rank;
        this.type = type;
        this.requirement = condition;
        this.discount = discount;

    }

    //这是特殊hotel promotion：生日特惠和合作企业特惠

    /**
     *
     * @param region           这里填酒店ID
     * @param discount         这里填折扣力度
     * @param type             如果是生日特惠，填０；如果是合作企业特惠，填１
     */
    public PromotionVO(int region,int discount,int type){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        this.promotionType = PromotionType.HotelPromotion;
        this.region = region;
        if(type==0) this.name = "00";
        else if(type==1) this.name="01";
        this.type = DiscountType.DaZhe;
        this.requirement = 0;
        this.discount = discount;
        try {
            this.startDate=simpleDateFormat.parse("2000-1-1");
            this.endDate=simpleDateFormat.parse("2030-1-1");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     * 这是为了修改已有特殊酒店促销策略
     * @param region     这里填酒店ID
     * @param discount   这里填折扣力度
     * @param type       如果是生日特惠，填０；如果是合作企业特惠，填１
     * @param promotionID   这个promotionID根据已有promotion的promotionID填，必须写
     * @param dummy1     冗余参数，只是为了和商圈特惠相区分
     */
    public PromotionVO(int region,int discount,int type,int promotionID,int dummy1){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        this.promotionType = PromotionType.HotelPromotion;
        this.region = region;
        if(type==0) this.name = "00";
        else if(type==1) this.name="01";
        this.type = DiscountType.DaZhe;
        this.promotionID=promotionID;
        this.requirement = 0;
        this.discount = discount;
        try {
            this.startDate=simpleDateFormat.parse("2000-1-1");
            this.endDate=simpleDateFormat.parse("2030-1-1");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    //这是普通web promotion(就不包含商圈信息咯，全国通用)

    /**
     *
     * @param name
     * @param content
     * @param startDate
     * @param endDate
     * @param type
     * @param condition
     * @param discount
     */
    public PromotionVO(String name, String content, Date startDate, Date endDate, int rank, DiscountType type, int condition, int discount){

        this.promotionType = PromotionType.WebPromotion;
        this.name = name;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.minRankAvailable = rank;
        this.maxRankAvailable = rank;
        this.type = type;
        this.requirement = condition;
        this.discount = discount;
    }

    //这是特殊web promotion：商圈优惠

    /**
     *
     * @param region        这里填商圈ID
     * @param discount
     * @param minRank       只是为了和特殊hotel promotion的constructor相区分，这里若只有一个会员等级，那minRank, maxRank传相同的数就行
     * @param maxRank
     */
    public PromotionVO(int region,int discount,int minRank, int maxRank){

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        this.promotionType = PromotionType.WebPromotion;
        this.region = region;
        this.name="10";
        this.minRankAvailable=minRank;
        this.maxRankAvailable=maxRank;
        this.type = DiscountType.DaZhe;
        this.requirement = 0;
        this.discount = discount;
        try {
            this.startDate=simpleDateFormat.parse("2000-1-1");
            this.endDate=simpleDateFormat.parse("2030-1-1");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public int getPromotionID() {
        return promotionID;
    }

    public PromotionType getPromotionType() {
        return promotionType;
    }

    public int getRegion() {
        return region;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getMinRankAvailable() {
        return minRankAvailable;
    }

    public int getMaxRankAvailable() {
        return maxRankAvailable;
    }

    public DiscountType getType() {
        return type;
    }

    public int getRequirement() {
        return requirement;
    }

    public int getDiscount() {
        return discount;
    }

    public String getStartDateString() {
        return startDateString;
    }

    public String getEndDateString() {
        return endDateString;
    }
}
