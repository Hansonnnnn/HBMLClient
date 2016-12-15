package driver;

import businesslogicservice.creditblservice.CreditCustomerService;
import businesslogicservice.creditblservice.CreditWebMarketerService;

public class CreditBLService_Driver {
	public void drive(CreditCustomerService creditCustomerService, CreditWebMarketerService creditWebMarketerService){
		//testing creditCustomerService
		creditCustomerService.getCreditRecordList(1);
		creditCustomerService.getCreditRecord(1);
		creditCustomerService.getCreditValue(1);

		//testing creditWebMarketerService
		creditWebMarketerService.addCreditValue(1,100);
		creditWebMarketerService.resumeCreditValue(1,200);
	}
}
