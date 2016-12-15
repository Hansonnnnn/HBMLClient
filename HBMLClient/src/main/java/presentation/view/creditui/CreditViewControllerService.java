package presentation.view.creditui;

import po.CreditRecordPO;
import vo.CreditRecordVO;

public interface CreditViewControllerService {
	
	public void showCredit();
	
	public void showCreditRecord();
	
	public boolean addCredit(int creditValue);
	
	public boolean resumeCredit(CreditRecordVO credit);
	
	public CreditRecordVO getCreditInfo();

	public int getCreditValue(String id);
	
	public int setCreditValue(String id,int value);
	
	public String getChangeType(String id);
	
	public String getReasonType(String id);
	
	public String getAccount(String id);
}
