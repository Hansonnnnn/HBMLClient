import model.DiscountTypeHelper;
import model.PromotionType;
import po.PromotionPO;
import rmi.ClientRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alex on 12/16/16.
 */
public class test_Alex {
    static test_Alex_User test_alex_user=new test_Alex_User();
    static test_Alex_Credit test_alex_credit=new test_Alex_Credit();
    static test_Alex_Promotion test_alex_promotion=new test_Alex_Promotion();

    static void testing_User()throws Exception{

        test_Alex_User.deleteUser(2);
        test_Alex_User.addUser();
        test_alex_user.deleteUser(3);
        test_alex_user.getUser(1);
        test_alex_user.getUser(3);
        test_alex_user.getUser("alex2097");
        test_alex_user.getUser("alex2098");
        test_alex_user.modifyUser();
        test_alex_user.signup();
        test_alex_user.deleteUser(5);
        test_alex_user.login();

    }

    static void testing_Credit()throws Exception{

        test_alex_credit.getCreditRecordList(1);
        test_alex_credit.getCreditRecordList(2);
        test_alex_credit.addCreditRecord();
        test_alex_credit.getCreditValue();
        test_alex_credit.setCreditValue();

    }

    static void testing_Promotion()throws Exception{

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        DiscountTypeHelper discountTypeHelper=new DiscountTypeHelper();
        Date date1=simpleDateFormat.parse("2017-11-11");
        Date date2=simpleDateFormat.parse("2017-11-15");
        PromotionPO po1=new PromotionPO(0, PromotionType.HotelPromotion,2,"double 11 promotion","all 50% off!!!",date1,date2,1,10,discountTypeHelper.getDiscountType(1),0,50);
        date1=simpleDateFormat.parse("2017-12-10");
        date2=simpleDateFormat.parse("2017-12-14");
        PromotionPO po2=new PromotionPO(0, PromotionType.HotelPromotion,3,"双十二满减特惠","满500减１５０",date1,date2,3,10,discountTypeHelper.getDiscountType(0),500,150);
        date1=simpleDateFormat.parse("2017-12-10");
        date2=simpleDateFormat.parse("2017-12-14");

    //    test_Alex_Promotion.addPromotion(po1);
//        test_Alex_Promotion.addPromotion(po2);
     //   test_Alex_Promotion.deletePromotion(1);
     //   test_Alex_Promotion.updatePromotion();
    //test_Alex_Promotion.getPromotionList();
    }

    public static void main(String args[]){
        ClientRunner clientRunner=new ClientRunner();
        try {
            /*
            System.out.println("testing user module:");
            testing_User();
            System.out.println();
            //*/
//---------------------------------------------------------------------------//
            /*
            System.out.println("testing credit module:");
            testing_Credit();
            System.out.println();
            //*/
//---------------------------------------------------------------------------//
            ///*
            System.out.println("testing promotion module");
            testing_Promotion();
            System.out.println();
            //*/
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
