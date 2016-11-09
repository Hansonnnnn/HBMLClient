package businesslogic.creditbl;

import businesslogicservice.creditblservice.CreditBLService;
import po.CreditPO;
import vo.CreditVO;

public class CreditController implements CreditBLService{
	CreditDatabaseServiceMySqlImpl_Stub creditDataService = new CreditDatabaseServiceMySqlImpl_Stub();  
	private String user_id;
	private int creditValue;
	
	public CreditController(String id, int value)
	{
		user_id = id;
		creditValue = value;
	}
	//“查看信用值”的实现
	public void showCredit()
	{
		CreditPO credit = creditDataService.find(user_id);
		System.out.println(credit.getValue());
	}
	//“查看信用值变化记录”的实现
	public void showCreditRecord()
	{
		CreditPO credit = creditDataService.find(user_id);
		System.out.println(credit.getCreditRecord());
	}
	//“充值信用值”的实现
	public boolean addCredit(int creditValue)
	{
		CreditPO credit = new CreditPO(creditValue);
		creditDataService.insert(credit);
		System.out.println("Add Credit Succeed!" + credit.getValue());
		return true;
	}
	//“恢复信用值”的实现
	public boolean resumeCredit(CreditVO credit)
	{
		creditDataService.find(user_id);
		System.out.println("Resume Credit Succeed!" + credit.getValue());
		return true;
	}
	//为orderbl提供信用值信息
	public CreditVO getCreditInfo()
	{
		System.out.println("Return CreditVO Succeed!");
		return new CreditVO(100, null);
	}
//	//为本层内部需要CreditPO对象的方法提供数据
//	public CreditPO getCreditPO()
//	{
//		return new CreditPO(100, null);
//	}
}
