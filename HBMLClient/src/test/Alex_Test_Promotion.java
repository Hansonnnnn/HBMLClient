import model.PromotionConditionHelper;

/**
 * Created by alex on 12/16/16.
 */
public class Alex_Test_Promotion {

    static void testPromotion(){
        PromotionConditionHelper promotionConditionHelper=new PromotionConditionHelper();
        int testleft=2;
        int testright=2;
        promotionConditionHelper.add(testleft,"=",testright,"int");
        promotionConditionHelper.add(3,">=",2,"int");
        String str="1234asdf";
        promotionConditionHelper.add(str,"=","1234asdf","string");
        promotionConditionHelper.add(3,"<",2,"asdf");
        promotionConditionHelper.del("asdf");
        System.out.println(promotionConditionHelper.decodeConditions());
    }


    public static void main(String args[]){
        testPromotion();
    }
}
