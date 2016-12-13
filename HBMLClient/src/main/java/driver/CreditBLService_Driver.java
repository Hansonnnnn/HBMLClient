package driver;

import businesslogicservice.creditblservice.CreditCustomerService;

public class CreditBLService_Driver {
	public void drive(CreditBLService creditBLService,CreditCustomerService creditCustomerService){
		creditBLService.showCredit();
		creditBLService.showCreditRecord();
		creditBLService.addCredit(1000);
		creditBLService.resumeCredit(new CreditVO(1000,null));
		creditBLService.getCreditInfo();
		creditBLService.getCreditValue("0001");
		creditBLService.setCreditValue("0001", 1000);
		creditCustomerService.getChangeType("0001");
		creditCustomerService.getReasonType("0001");
		creditCustomerService.getAccount("0001");
	}
}
