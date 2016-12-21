import businesslogic.orderbl.OrderCustomerServiceImpl;
import businesslogic.promotionbl.PromotionStaffImpl;
import businesslogic.promotionbl.PromotionWebMarketerImpl;
import businesslogic.promotionbl.helper.PromotionHelper;
import businesslogic.userbl.UserCustomerImpl;
import businesslogicservice.orderblservice.OrderCustomerService;
import businesslogicservice.promotionblservice.PromotionStaffService;
import businesslogicservice.promotionblservice.PromotionWebMarketerService;
import businesslogicservice.userblservice.UserCustomerService;
import dao.PromotionDao;
import model.DiscountType;
import model.DiscountTypeHelper;
import model.PromotionFilter;
import model.PromotionType;
import po.PromotionPO;
import rmi.ClientRunner;
import vo.OrderVO;
import vo.PromotionVO;
import vo.SelectedPromotionVO;
import vo.UserVO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by alex on 12/18/16.
 */
public class test_Alex_Promotion_BL {

    static void addPromotion()throws Exception{
        PromotionStaffService promotionStaffService=new PromotionStaffImpl();
        PromotionWebMarketerService promotionWebMarketerService=new PromotionWebMarketerImpl();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        DiscountTypeHelper discountTypeHelper=new DiscountTypeHelper();
        Date date1=simpleDateFormat.parse("2017-11-11");
        Date date2=simpleDateFormat.parse("2017-11-15");

        //a region promotion(web promotion)
        PromotionVO promotionVO1=new PromotionVO(1,20,2,5);
        //a birthday promotion(hotel promotion)
        PromotionVO promotionVO2=new PromotionVO(1,20,0);
        //a brother company promotion(hotel promotion)
        PromotionVO promotionVO3=new PromotionVO(1,10,1);
        //an ordinary promotion(web promotion)
        PromotionVO promotionVO4=new PromotionVO("double 11","20% off",date1,date2,2, DiscountType.DaZhe,0,20);
        //an ordinary promotion(hotel promotion)
        date1=simpleDateFormat.parse("2017-12-10");
        date2=simpleDateFormat.parse("2017-12-14");
        PromotionVO promotionVO5=new PromotionVO(1,"double 12","30% off",date1,date2,2,DiscountType.DaZhe,0,30);
        promotionWebMarketerService.addWebPromotion(promotionVO1);
    }

    static void updatePromotion()throws Exception{
        PromotionStaffService promotionStaffService=new PromotionStaffImpl();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        DiscountTypeHelper discountTypeHelper=new DiscountTypeHelper();
        Date date1=simpleDateFormat.parse("2017-1-1");
        Date date2=simpleDateFormat.parse("2017-12-31");
        PromotionVO vo3=new PromotionVO(2, PromotionType.HotelPromotion,3,"all year discount","满500减100",date1,date2,1,10,discountTypeHelper.getDiscountType(0),500,100);
        System.out.println(promotionStaffService.modifyHotelPromotion(vo3));
    }

    static void deletePromotion()throws Exception{
        PromotionStaffService promotionStaffService=new PromotionStaffImpl();
        System.out.println(promotionStaffService.deleteHotelPromotion(1));
        System.out.println(promotionStaffService.deleteHotelPromotion(1));
    }

    static void getPromotionList()throws Exception{
        //initialization
        //testing getPromotionList
        PromotionStaffService promotionStaffService=new PromotionStaffImpl();
        DiscountTypeHelper discountTypeHelper=new DiscountTypeHelper();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=simpleDateFormat.parse("2016-12-25");
        Date date2=simpleDateFormat.parse("2016-12-31");
        PromotionVO[] promotionVOs=new PromotionVO[20];
        for(int i=0;i<10;i++){
            promotionVOs[2*i]=new PromotionVO(0, PromotionType.HotelPromotion,4*i+1,"special discount at Christmas!","15% off for all guests!!!",date1,date2,1,10,discountTypeHelper.getDiscountType(1),0,15);
            promotionVOs[2*i+1]=new PromotionVO(0, PromotionType.WebPromotion,3*i+1,"special discount at Christmas!","150 off if 500 is paid",date1,date2,1,10,discountTypeHelper.getDiscountType(0),500,150);
        }
        for(int i=0;i<20;i++){
            promotionStaffService.addHotelPromotion(promotionVOs[i]);
        }
        //a simple update of some data
        date1=simpleDateFormat.parse("2016-11-11");
        date2=simpleDateFormat.parse("2016-12-12");
        PromotionVO vo1;

        for(int i=1;i<5;i++){
            vo1=new PromotionVO(i*i, PromotionType.HotelPromotion,0,"promotion between double 11 and double 12***","all 50% off!!!",date1,date2,1,10,discountTypeHelper.getDiscountType(1),0,50);
            promotionStaffService.modifyHotelPromotion(vo1);
        }
        PromotionFilter filter=new PromotionFilter();
        date1=simpleDateFormat.parse("2016-12-1");
        filter.add("startDate",">",date1);

        Map<Integer, PromotionVO> map=promotionStaffService.getHotelPromotionList(filter);
        PromotionVO promotionVO;
        if(map.size()==0){
            System.out.println("the map is null");
        }else{
            System.out.println("the map size is "+map.size());
            Set set=map.keySet();
            for(Object obj:set){
                Integer k=(Integer) obj;
                promotionVO=(PromotionVO)map.get(k);
                System.out.println("checking promotion number: "+k);
                System.out.println("promotion id             : "+promotionVO.getPromotionID());
                System.out.println("promotion start date is  : "+promotionVO.getStartDate());
                System.out.println("promotion region is      : "+promotionVO.getRegion());
            }
        }
    }

    static void getSelectedPromotion()throws Exception{
        OrderCustomerService orderCustomerService=new OrderCustomerServiceImpl();
        Map<Integer, OrderVO> map=orderCustomerService.getUnexecutedOrderList(1);
        System.out.println("mapsize:  "+map.size());
        OrderVO orderVO=null;
        for(int key:map.keySet()){
            orderVO=map.get(key);
            if(orderVO!=null&&orderVO.getHotelID()==120) break;
        }
        PromotionStaffService promotionStaffService=new PromotionStaffImpl();


        //putting some promotions
        /*
        DiscountTypeHelper discountTypeHelper=new DiscountTypeHelper();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=simpleDateFormat.parse("2016-12-1");
        Date date2=simpleDateFormat.parse("2016-12-31");
        PromotionVO[] promotionVOs=new PromotionVO[20];
        for(int i=0;i<10;i++){
            promotionVOs[2*i]=new PromotionVO(0, PromotionType.HotelPromotion,120,"special discount at Christmas!","15+i% off for all guests!!!",date1,date2,i,10,discountTypeHelper.getDiscountType(1),0,15+i);
            promotionVOs[2*i+1]=new PromotionVO(0, PromotionType.WebPromotion,3*i+1,"special discount at Christmas!","150+i off if 500 is paid",date1,date2,1,10,discountTypeHelper.getDiscountType(0),500,150+i);
        }
        for(int i=0;i<20;i++){
            promotionStaffService.addHotelPromotion(promotionVOs[i]);
        }
        //a simple update of some data
        date1=simpleDateFormat.parse("2016-11-11");
        date2=simpleDateFormat.parse("2016-12-12");
        PromotionVO vo1;

        for(int i=1;i<5;i++){
            vo1=new PromotionVO(i*i, PromotionType.HotelPromotion,120,"promotion between double 11 and double 12***","all 50% off!!!",date1,date2,i,10,discountTypeHelper.getDiscountType(1),0,50);
            promotionStaffService.modifyHotelPromotion(vo1);
        }
        //*/
        ///*
        PromotionHelper promotionHelper=new PromotionHelper();
        UserCustomerService userCustomerService=new UserCustomerImpl();


        UserVO userVO=userCustomerService.getUserData(orderVO.getUserID());
        System.out.println(userVO.getMemberInfo());
        System.out.println("the price is "+orderVO.getPrice());
        SelectedPromotionVO selectedPromotionVO= promotionHelper.getSelectedPromotion(orderVO);
        System.out.println(selectedPromotionVO.getPromotionVO().getPromotionID());
        System.out.println(selectedPromotionVO.getPrice());
        System.out.println(selectedPromotionVO.getPromotionVO().getName());
        System.out.println(selectedPromotionVO.getPromotionVO().getContent());
        //*/
    }
}
