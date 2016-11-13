package dao.credit;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.CreditVO;

public interface CreditDao extends Remote{
	
	public void showCredit() throws RemoteException;
	
	public void showCreditRecord() throws RemoteException;
	
	public boolean addCredit(int creditValue) throws RemoteException;
	
	public boolean resumeCredit(CreditVO credit) throws RemoteException;
	
	public int getCreditValue(String id) throws RemoteException;
	
	public int setCreditValue(String id, int value) throws RemoteException;
	
	public String getChangeType(String id) throws RemoteException;
	
	public String getReasonType(String id) throws RemoteException;
	
	public String getAccount(String id) throws RemoteException;

}
