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
	
}
