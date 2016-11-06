package businesslogicservice.creditblservice;

import po.CreditPO;
import vo.CreditVO;

public interface CreditBLService {
	public void showCredit();
	public void showCreditRecord();
	public boolean addCredit(int creditValue);
	public boolean resumeCredit(CreditVO credit);
	public CreditVO getCreditInfo();
//	public CreditPO getCreditPO();
	public int getCreditValue(String id);
	public int setCreditValue(String id);
}
