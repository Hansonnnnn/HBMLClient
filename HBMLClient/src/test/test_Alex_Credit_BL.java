import businesslogic.creditbl.CreditCustomerImpl;
import businesslogic.creditbl.CreditWebMarketerImpl;
import businesslogicservice.creditblservice.CreditCustomerService;
import businesslogicservice.creditblservice.CreditWebMarketerService;
import dao.CreditDao;
import model.CreditRecordReasonTypeHelper;
import po.CreditRecordPO;
import rmi.ClientRunner;
import vo.CreditRecordVO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by alex on 12/18/16.
 */
public class test_Alex_Credit_BL {
    static Map<Integer, CreditRecordVO> map;

    static void getCreditRecordList(int id)throws Exception{
        CreditCustomerService creditCustomerService=new CreditCustomerImpl();
        map=creditCustomerService.getCreditRecordList(id);
        CreditRecordVO creditRecordVO;
        System.out.println("the map size is: "+map.size());
        if(map.size()==0){
            System.out.println("the map is null");
        }else{
            Set set=map.keySet();
            for(Object obj:set){
                Integer k=(Integer) obj;
                creditRecordVO=(CreditRecordVO)map.get(k);
                System.out.println("checking creditRecord number: "+k);
                System.out.println(creditRecordVO.getAmount());
                System.out.println(creditRecordVO.getReasonType());
            }
        }
        System.out.println();
    }

    static void popup(int userID,long value)throws Exception{
        CreditWebMarketerService creditWebMarketerService=new CreditWebMarketerImpl();
        creditWebMarketerService.addCreditValue(userID,value);
    }

    static long getCreditValue()throws Exception{
        CreditDao creditDao=ClientRunner.remoteHelper.getCreditDao();
        long number=creditDao.getCreditValue(1);
        System.out.println("the credit value is: "+number);
        return number;
    }

    static void setCreditValue()throws Exception{
        CreditDao creditDao=ClientRunner.remoteHelper.getCreditDao();
        long number2=9999;
        long number1=getCreditValue();
        System.out.println(creditDao.setCreditValue(1,number2));
    }
}
