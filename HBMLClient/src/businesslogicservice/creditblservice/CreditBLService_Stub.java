package businesslogicservice.creditblservice;

import po.CreditPO;
import vo.CreditVO;

public class CreditBLService_Stub implements CreditBLService{
	private String user_id;
	private int creditValue;
	
	public CreditBLService_Stub(String id, int value)
	{
		user_id = id;
		creditValue = value;
	}
	//“查看信用值”的实现
	public void showCredit()
	{
		if(user_id == "0000")
		{
			CreditVO credit = new CreditVO(100,null);
			System.out.println(credit.getValue());
		}
	}
	//“查看信用值变化记录”的实现
	public void showCreditRecord()
	{
		if(user_id == "0000")
		{
			CreditVO[] creditRecord  = new CreditVO[10];
			for(int i = 0; i < creditRecord.length;i++)
			{
				creditRecord[i] = new CreditVO(i+100, null);
				System.out.println(creditRecord[i].getValue());//未使用creditVO对象中的creditRecord
			}
		}
	}
	//“充值信用值”的实现
	public boolean addCredit(int creditValue)
	{
		if(user_id == "0000")
		{
			this.creditValue+=creditValue;
			System.out.println("充值成功 " + creditValue);
			return true;
		}
		System.out.println("充值失败 " + creditValue);
		return false;
	}
	//“恢复信用值”的实现
	public boolean resumeCredit(CreditVO credit)
	{
		if(credit != null)
		{
			System.out.println("恢复成功 " + credit.getValue());
			return true;
		}
		return false;
	}
	//为orderbl提供信用值信息
	public CreditVO getCreditInfo()
	{
		return new CreditVO(100,null);
	}
//	//为本层内部需要CreditPO对象的方法提供数据
//	public CreditPO getCreditPO()
//	{
//		return new CreditPO(100, null);
//	}
	@Override
	//获取信用值的实现
	public int getCreditValue(String id) {
		if(id=="0000"){
			System.out.println("获取信用值成功 " + creditValue);
			return this.creditValue;
		}
		System.out.println("获取失败: "+creditValue);
		return 0;
	}
	@Override
	//设置信用值的实现
	public int setCreditValue(String id,int value) {
		if(id=="0000"){
			this.creditValue=value;
			System.out.println("设置成功: "+creditValue);
			return this.creditValue;
		}
		System.out.println("设置失败");
		return 0;
	}
}
