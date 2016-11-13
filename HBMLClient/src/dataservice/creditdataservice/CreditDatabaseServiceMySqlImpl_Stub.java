package dataservice.creditdataservice;

import po.CreditPO;

public class CreditDatabaseServiceMySqlImpl_Stub implements CreditDataService{
	public CreditDatabaseServiceMySqlImpl_Stub(){}
	public void insert(CreditPO order)
	{
		System.out.println("Insert Succeed!\n");
	}
	public void delete(CreditPO order)
	{
		System.out.println("Delete Succeed!\n");
	}
	public void update(CreditPO credit)
	{
		System.out.println("Updata Succeed!\n");
	}
	public CreditPO find(String id)
	{
		System.out.println("Find Succeed!\n");
		CreditPO credit = new CreditPO(100, null);
		return credit;
	}
	@Override
	public int getCreditValue(String id) {
		System.out.println("Get Succeed!\n");
		return 0;
	}
	@Override
	public int setCreidtValue(String id, int value) {
		System.out.println("Set Succeed!\n");
		return 0;
	}
	@Override
	public String getChangeType(String id) {
		System.out.println("Get ChangeType Succeed!\n");
		return null;
	}
	@Override
	public String getReasonType(String id) {
		System.out.println("Get ReasonType Succeed!\n");
		return null;
	}
	@Override
	public String getAccount(String id) {
		System.out.println("Get Account Succeed!\n");
		return null;
	}
	
}
