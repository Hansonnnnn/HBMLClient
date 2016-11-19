package businesslogic.promotionbl;

import java.util.Date;
import java.util.List;

public class Promotion {
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
    
    public Promotion(String id){
        this.id=id;
    }

    //constructors for hotel promotions
    public Promotion(String id,String hotelPromotionName,String type,String content,
                            Date startDate,Date endDate,List<Integer> ranks){
        this.id=id;
        this.name=hotelPromotionName;
        this.type=type;
        this.content=content;
        this.startDate=startDate;
        this.endDate=endDate;
        this.rankAvailable=ranks;
    }

    public Promotion(String hotelName,String content){
        this.name=hotelName;
        this.content=content;
    }

}
