package businesslogicservice.creditblservice;


import vo.CreditRecordVO;

import java.util.Map;

public interface CreditCustomerService {

	public long getCreditValue(int userID);

	public Map<Integer, CreditRecordVO> getCreditRecordList(int userID);

	public CreditRecordVO getCreditRecord(int creditRecordID);

}
