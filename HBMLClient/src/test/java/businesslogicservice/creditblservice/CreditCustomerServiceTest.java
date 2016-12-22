package businesslogicservice.creditblservice;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.creditbl.CreditCustomerImpl;
import rmi.ClientRunner;
import vo.CreditRecordVO;

public class CreditCustomerServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClientRunner clientRunner = new ClientRunner();
	}

	@Test
	public void testGetCreditValue() {
		CreditCustomerService creditCustomerService = new CreditCustomerImpl();
		long i =0;
		try {
			i = creditCustomerService.getCreditValue(1);
			System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(0, i);
	}

	@Test
	public void testGetCreditRecordList() {
		CreditCustomerService creditCustomerService = new CreditCustomerImpl();
		Map<Integer, CreditRecordVO> map = null;
		try {
			map =creditCustomerService.getCreditRecordList(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(map.values());
	}

}
