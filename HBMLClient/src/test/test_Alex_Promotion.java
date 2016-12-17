import businesslogic.orderbl.OrderCustomerServiceImpl;
import businesslogic.promotionbl.helper.PromotionHelper;
import businesslogic.userbl.UserCustomerImpl;
import businesslogicservice.orderblservice.OrderCustomerService;
import businesslogicservice.userblservice.UserCustomerService;
import dao.PromotionDao;
import dao.UserDao;
import model.DiscountTypeHelper;
import model.MemberType;
import model.PromotionFilter;
import model.PromotionType;
import po.PromotionPO;
import rmi.ClientRunner;
import vo.OrderVO;
import vo.SelectedPromotionVO;
import vo.UserVO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by alex on 12/13/16.
 */
public class test_Alex_Promotion {

    static void addPromotion(PromotionPO po)throws Exception{
        PromotionDao promotionDao= ClientRunner.remoteHelper.getPromotionDao();
        System.out.println(promotionDao.addPromotion(po));
    }

    static void updatePromotion()throws Exception{
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        DiscountTypeHelper discountTypeHelper=new DiscountTypeHelper();
        Date date1=simpleDateFormat.parse("2017-1-1");
        Date date2=simpleDateFormat.parse("2017-12-31");
        PromotionPO po3=new PromotionPO(2, PromotionType.HotelPromotion,3,"all year discount","满500减100",date1,date2,1,10,discountTypeHelper.getDiscountType(0),500,100);
        PromotionDao promotionDao=ClientRunner.remoteHelper.getPromotionDao();
        System.out.println(promotionDao.updatePromotion(po3));
    }

    static void deletePromotion(int id)throws Exception{
        PromotionDao promotionDao=ClientRunner.remoteHelper.getPromotionDao();
        System.out.println(promotionDao.deletePromotion(id));
    }

    static void getPromotionList()throws Exception{
        //initialization
        //testing getPromotionList
        DiscountTypeHelper discountTypeHelper=new DiscountTypeHelper();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=simpleDateFormat.parse("2016-12-25");
        Date date2=simpleDateFormat.parse("2016-12-31");
        PromotionPO[] promotionPOs=new PromotionPO[20];
        PromotionDao promotionDao=ClientRunner.remoteHelper.getPromotionDao();
        for(int i=0;i<10;i++){
            promotionPOs[2*i]=new PromotionPO(0, PromotionType.HotelPromotion,4*i+1,"special discount at Christmas!","15% off for all guests!!!",date1,date2,1,10,discountTypeHelper.getDiscountType(1),0,15);
            promotionPOs[2*i+1]=new PromotionPO(0, PromotionType.WebPromotion,3*i+1,"special discount at Christmas!","150 off if 500 is paid",date1,date2,1,10,discountTypeHelper.getDiscountType(0),500,150);
        }
        for(int i=0;i<20;i++){
            promotionDao.addPromotion(promotionPOs[i]);
        }
        //a simple update of some data
        date1=simpleDateFormat.parse("2016-11-11");
        date2=simpleDateFormat.parse("2016-12-12");
        PromotionPO po1;

        for(int i=1;i<5;i++){
            po1=new PromotionPO(i*i, PromotionType.HotelPromotion,0,"promotion between double 11 and double 12***","all 50% off!!!",date1,date2,1,10,discountTypeHelper.getDiscountType(1),0,50);
            promotionDao.updatePromotion(po1);
        }
        PromotionFilter filter=new PromotionFilter();
        date1=simpleDateFormat.parse("2016-12-1");
        filter.add("startDate",">",date1);

        Map<Integer, PromotionPO> map=promotionDao.getHotelPromotionList(filter);
        PromotionPO promotionPO;
        if(map.size()==0){
            System.out.println("the map is null");
        }else{
            System.out.println("the map size is "+map.size());
            Set set=map.keySet();
            for(Object obj:set){
                Integer k=(Integer) obj;
                promotionPO=(PromotionPO)map.get(k);
                System.out.println("checking promotion number: "+k);
                System.out.println("promotion id             : "+promotionPO.getPromotionID());
                System.out.println("promotion start date is  : "+promotionPO.getStartDate());
                System.out.println("promotion region is      : "+promotionPO.getRegion());
            }
        }
    }

    static void getSelectedPromotion()throws Exception{
        OrderCustomerService orderCustomerService=new OrderCustomerServiceImpl();
        Map<Integer,OrderVO> map=orderCustomerService.getExecutedOrderList(1);
        System.out.println("mapsize:  "+map.size());
        OrderVO orderVO=null;
        for(int key:map.keySet()){
            orderVO=map.get(key);
            if(orderVO!=null&&orderVO.getHotelID()==120) break;
        }
        /*
        //putting some promotions
        DiscountTypeHelper discountTypeHelper=new DiscountTypeHelper();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=simpleDateFormat.parse("2016-12-1");
        Date date2=simpleDateFormat.parse("2016-12-31");
        PromotionPO[] promotionPOs=new PromotionPO[20];
        PromotionDao promotionDao=ClientRunner.remoteHelper.getPromotionDao();
        for(int i=0;i<10;i++){
            promotionPOs[2*i]=new PromotionPO(0, PromotionType.HotelPromotion,4*i+1,"special discount at Christmas!","15+i% off for all guests!!!",date1,date2,i,10,discountTypeHelper.getDiscountType(1),0,15+i);
            promotionPOs[2*i+1]=new PromotionPO(0, PromotionType.WebPromotion,3*i+1,"special discount at Christmas!","150+i off if 500 is paid",date1,date2,1,10,discountTypeHelper.getDiscountType(0),500,150+i);
        }
        for(int i=0;i<20;i++){
            promotionDao.addPromotion(promotionPOs[i]);
        }
        //a simple update of some data
        date1=simpleDateFormat.parse("2016-11-11");
        date2=simpleDateFormat.parse("2016-12-12");
        PromotionPO po1;

        for(int i=1;i<5;i++){
            po1=new PromotionPO(i*i, PromotionType.HotelPromotion,0,"promotion between double 11 and double 12***","all 50% off!!!",date1,date2,i,10,discountTypeHelper.getDiscountType(1),0,50);
            promotionDao.updatePromotion(po1);
        }
        //*/
        ///*
        PromotionHelper promotionHelper=new PromotionHelper();
        UserCustomerService userCustomerService=new UserCustomerImpl();

       // orderVO=new OrderVO(0,2,120,);
       // orderCustomerService.addOrder(orderVO);

        UserVO userVO=userCustomerService.getUserData(orderVO.getUserID());
        System.out.println(userVO.getName());
        System.out.println("the price is "+orderVO.getPrice());

        SelectedPromotionVO selectedPromotionVO= promotionHelper.getSelectedPromotion(orderVO);
        System.out.println(selectedPromotionVO.getPrice());
        //*/
    }

}
