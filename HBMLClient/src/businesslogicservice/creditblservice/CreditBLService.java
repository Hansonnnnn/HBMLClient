package businesslogicservice.creditblservice;

import PO.CreditPO;
import VO.CreditVO;

public interface CreditBLService {
	public void showCredit();
	public void showCreditRecord();
	public boolean addCredit(int creditValue);
	public boolean resumeCredit(CreditVO credit);
	public CreditVO getCreditInfo();
//	public CreditPO getCreditPO();
}
