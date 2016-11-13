package dataservice.creditdataservice;

import po.CreditPO;

public interface CreditDataService {
	public void insert(CreditPO credit);
	public void delete(CreditPO credit);
	public void update(CreditPO credit);
	public CreditPO find(String id);
	public int getCreditValue(String id);
	public int setCreidtValue(String id,int value);
	public String getChangeType(String id);
	public String getReasonType(String id);
	public String getAccount(String id);
}
