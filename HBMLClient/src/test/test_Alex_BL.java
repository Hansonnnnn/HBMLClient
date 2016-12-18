import rmi.ClientRunner;

/**
 * Created by alex on 12/18/16.
 */
public class test_Alex_BL {
    static test_Alex_Credit_BL test_alex_credit_bl=new test_Alex_Credit_BL();
    static test_Alex_User_BL test_alex_user_bl=new test_Alex_User_BL();
    static test_Alex_Promotion_BL test_alex_promotion_bl=new test_Alex_Promotion_BL();

    static void test_User_BL()throws Exception{
        test_alex_user_bl.signup();
    }

    static void test_Credit_BL(){

    }

    static void test_Promotion_BL(){

    }

    public static void main(String args[]){
        ClientRunner clientRunner = new ClientRunner( );
        try{
            test_User_BL();
            test_Credit_BL();
            test_Promotion_BL();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
