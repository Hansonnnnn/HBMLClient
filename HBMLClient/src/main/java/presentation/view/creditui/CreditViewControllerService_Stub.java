package presentation.view.creditui;


import vo.CreditRecordVO;

public class CreditViewControllerService_Stub implements CreditViewControllerService{
	String user_Type;
	String user_ID;
	int creditValue;
	
	public  CreditViewControllerService_Stub(String user_Type,String user_ID,int creditValue) {
		// TODO 自动生成的构造函数存根
		this.user_Type=user_Type;
		this.user_ID=user_ID;
		this.creditValue=creditValue;
	}
	@Override
	public void showCredit() {
		// TODO 自动生成的方法存根
		System.out.println(creditValue);
		System.out.println("Show Credit Success");
	}

	@Override
	public void showCreditRecord() {
		// TODO 自动生成的方法存根
		System.out.println("Show CreditRecod Success");
	}

	@Override
	public boolean addCredit(int creditValue) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean resumeCredit(CreditRecordVO credit) {
		// TODO 自动生成的方法存根
		System.out.println("Resume Credit Success");
		return false;
	}

	@Override
	public CreditRecordVO getCreditInfo() {
		// TODO 自动生成的方法存根
		System.out.println("Get CreditInfo Success");
		return null;
	}

	@Override
	public int getCreditValue(String id) {
		// TODO 自动生成的方法存根
		System.out.println("Get CreditValue Success");
		return creditValue;
	}

	@Override
	public int setCreditValue(String id, int value) {
		// TODO 自动生成的方法存根
		this.creditValue=value;
		System.out.println("Set CreditValue Success");
		return creditValue;
	}

	@Override
	public String getChangeType(String id) {
		// TODO 自动生成的方法存根
		System.out.println("Get ChangeType Success");
		return null;
	}

	@Override
	public String getReasonType(String id) {
		// TODO 自动生成的方法存根
		System.out.println("Get ReasonType Success");
		return null;
	}

	@Override
	public String getAccount(String id) {
		// TODO 自动生成的方法存根
		System.out.println("Get Account Success");
		return null;
	}

}
