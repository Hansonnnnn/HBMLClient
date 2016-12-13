package presentation.view.creditui;

public interface CreditViewControllerService {
	
	public void showCredit();
	
	public void showCreditRecord();
	
	public boolean addCredit(int creditValue);
	
	public boolean resumeCredit(CreditVO credit);
	
	public CreditVO getCreditInfo();

	public int getCreditValue(String id);
	
	public int setCreditValue(String id,int value);
	
	public String getChangeType(String id);
	
	public String getReasonType(String id);
	
	public String getAccount(String id);
}
