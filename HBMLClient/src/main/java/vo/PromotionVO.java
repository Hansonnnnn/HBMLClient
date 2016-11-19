package vo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * Created by alex on 16-11-13.
 */
public class PromotionVO implements Serializable{
    //shared
    String id;
    String name;
    String type;
    String content;
    Date startDate;
    Date endDate;
    List<Integer> rankAvailable;
    //for hotel promotion
    List<String> regionAvailable;
    //for web promotion


    //constructors for all PromotionVO
    public PromotionVO(String id){
        this.id=id;
    }

    //constructors for hotel promotions
    public PromotionVO(String id,String hotelPromotionName,String type,String content,
                       Date startDate,Date endDate,List<Integer> ranks){
        this.id=id;
        this.name=hotelPromotionName;
        this.type=type;
        this.content=content;
        this.startDate=startDate;
        this.endDate=endDate;
        this.rankAvailable=ranks;
    }

    public PromotionVO(String hotelName,String content){
        this.name=hotelName;
        this.content=content;
    }

    //constructors for web promotions
    public PromotionVO(String id,String webPromotionName,String type,String content,
                       Date startDate,Date endDate,List<Integer> ranks,List<String> regionAvailable){
        this.id=id;
        this.name=webPromotionName;
        this.type=type;
        this.content=content;
        this.startDate=startDate;
        this.endDate=endDate;
        this.rankAvailable=ranks;
        this.regionAvailable=regionAvailable;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
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

    public List<Integer> getRankAvailable() {
        return rankAvailable;
    }

    public List<String> getRegionAvailable() {
        return regionAvailable;
    }
}
