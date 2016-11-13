package businesslogicservice.promotionblservice;

import vo.HotelPromotionVO;
import vo.WebPromotionVO;

/**
 * Created by alex on 16-10-16.
 */
public class PromotionBLService_Stub implements PromotionBLService {
    private String user_id;
    private int user_type;
    //user_type::0 for hotel staff,0;1 for web marketers
    public PromotionBLService_Stub(String id){
        this.user_id=id;
        if(this.user_id.charAt(0)=='0')this.user_type=0;
        else this.user_type=1;

    }


    @Override
    public void showPromotion() {
        if(this.user_type==0){
            HotelPromotionVO hotelPromotionVO=new HotelPromotionVO("double 11","by TMALL",1);
            System.out.println();
            System.out.println(hotelPromotionVO.getName());
            System.out.println(hotelPromotionVO.getContent());
            hotelPromotionVO.setName("new_name");
            System.out.println(hotelPromotionVO.getName());
            System.out.println();
        }else{
            WebPromotionVO webPromotionVO=new WebPromotionVO("activity","double 11","by TMALL");
            System.out.println();
            System.out.println(webPromotionVO.getName());
            System.out.println(webPromotionVO.getContent());
            webPromotionVO.setName("new_name");
            System.out.println(webPromotionVO.getName());
            System.out.println();
        }
    }

    @Override
    public void showPromotionList() {
        int i;
        if(this.user_type==0){
            HotelPromotionVO[] hotelPromotionVOs=new HotelPromotionVO[10];
            for(i=0;i<10;i++){
                hotelPromotionVOs[i]=new HotelPromotionVO("double 11","by TMALL",i);
                System.out.println(hotelPromotionVOs[i].getName());
                System.out.println(hotelPromotionVOs[i].getContent());
            }
        }else{
            WebPromotionVO[] webPromotionVOs=new WebPromotionVO[10];
            for(i=0;i<10;i++){
                webPromotionVOs[i]=new WebPromotionVO("activity","double 11"+(2010+i),"by TMALL");
                System.out.println(webPromotionVOs[i].getName());
                System.out.println(webPromotionVOs[i].getContent());
            }
        }
    }

    @Override
    public boolean addPromotion(HotelPromotionVO hotelPromotionVO) {
        System.out.println("hotel promotion successfully added");
        return false;
    }

    @Override
    public boolean addPromotion(WebPromotionVO webPromotionVO) {
        System.out.println("web promotion successfully added");
        return false;
    }

    @Override
    public boolean deletePromotion(String ID) {
        System.out.println("hotel promotion successfully deleted");
        return false;
    }

    @Override
    public boolean modify(HotelPromotionVO hotelPromotionVO) {
        System.out.println("hotel promotion successfully modified");
        return false;
    }

    @Override
    public boolean modify(WebPromotionVO webPromotionVO) {
        System.out.println("web promotion successfully modified");
        return false;
    }

    @Override
    public HotelPromotionVO getHotelPromotionVO() {
        return new HotelPromotionVO("double 11","by TMALL",1);
    }

    @Override
    public WebPromotionVO getWebPromotionVO() {
        return new WebPromotionVO("activity","double 11","by TMALL");
    }
}
