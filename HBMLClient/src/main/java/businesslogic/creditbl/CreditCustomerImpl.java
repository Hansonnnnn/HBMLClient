package businesslogic.creditbl;

import businesslogic.creditbl.helper.CreditHelper;
import businesslogicservice.creditblservice.CreditCustomerService;
import vo.CreditRecordVO;

import java.util.Map;

/**
 * Created by alex on 12/13/16.
 */
public class CreditCustomerImpl implements CreditCustomerService{

    CreditHelper creditHelper;

    public CreditCustomerImpl() {
        creditHelper=new CreditHelper();
    }


    @Override
    public long getCreditValue(int userID) throws Exception{
        return creditHelper.getCreditValue(userID);
    }

    @Override
    public Map<Integer, CreditRecordVO> getCreditRecordList(int userID) throws Exception{
        return creditHelper.getCreditRecordList(userID);
    }


}
