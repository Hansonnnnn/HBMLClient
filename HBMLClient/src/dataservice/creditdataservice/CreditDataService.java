package dataservice.creditdataservice;

import PO.CreditPO;

public interface CreditDataService {
	public void insert(CreditPO order);
	public void delete(CreditPO order);
	public void update(CreditPO order);
	public CreditPO find(String id);
}
