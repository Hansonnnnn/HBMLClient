import businesslogic.promotionbl.PromotionWebMarketerImpl;
import businesslogicservice.promotionblservice.PromotionWebMarketerService;
import model.PromotionFilter;
import rmi.ClientRunner;
import vo.PromotionVO;

import java.util.Map;

/**
 * Created by alex on 12/18/16.
 */
public class test_Alex_BL {
    static test_Alex_Credit_BL test_alex_credit_bl=new test_Alex_Credit_BL();
    static test_Alex_User_BL test_alex_user_bl=new test_Alex_User_BL();
    static test_Alex_Promotion_BL test_alex_promotion_bl=new test_Alex_Promotion_BL();

    static void test_User_BL()throws Exception{
        //test_alex_user_bl.signup();
        //test_alex_user_bl.login();
        //test_alex_user_bl.getUserInfo();
        //test_alex_user_bl.delete();
        //test_alex_user_bl.logout();
    }

    static void test_Credit_BL()throws Exception{
        //test_Alex_Credit_BL.popup(1,10000);
        test_Alex_Credit_BL.getCreditValue();
    }

    static void test_Promotion_BL()throws Exception{
        //test_Alex_Promotion_BL.addPromotion();
        //test_Alex_Promotion_BL.updatePromotion();
        //test_Alex_Promotion_BL.deletePromotion();
        //test_Alex_Promotion_BL.getPromotionList();
        //test_Alex_Promotion_BL.getSelectedPromotion();
    }

    static void test_in_test()throws Exception{
        Map<Integer, PromotionVO> map;
        PromotionFilter promotionFilter=new PromotionFilter();
        PromotionWebMarketerService promotionWebMarketerService=new PromotionWebMarketerImpl();
        map=promotionWebMarketerService.getWebPromotionList(promotionFilter);
        System.out.println(map.size());
    }


    public static void main(String args[]){
        ClientRunner clientRunner = new ClientRunner();
        try{
            test_User_BL();
            test_Credit_BL();
            test_Promotion_BL();
            //test_in_test();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
