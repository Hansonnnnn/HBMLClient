package businesslogic.creditbl;

import businesslogicservice.creditblservice.CreditCustomerService;
import vo.CreditRecordVO;

import java.util.Map;

/**
 * Created by alex on 12/13/16.
 */
public class CreditCustomerImpl implements CreditCustomerService{

    @Override
    public long getCreditValue(int userID) {
        return 0;
    }

    @Override
    public Map<Integer, CreditRecordVO> getCreditRecordList(int userID) {
        return null;
    }

    @Override
    public CreditRecordVO getCreditRecord(int creditRecordID) {
        return null;
    }
}
