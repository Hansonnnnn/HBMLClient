package businesslogicservice.orderblservice;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.orderbl.OrderStaffServiceImpl;
import message.ResultMessage;
import rmi.ClientRunner;
import vo.OrderVO;

public class OrderStaffServiceTest {

	OrderStaffService orderStaffService = new OrderStaffServiceImpl(); 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClientRunner clientRunner = new ClientRunner();
	}

	@Test
	public void testGetUnexecutedOrderList() {
		Map<Integer, OrderVO	> map = orderStaffService.getUnexecutedOrderList(1);
		assertNotNull(map);
	}

	@Test
	public void testGetExecutedOrderList() {
		Map<Integer, OrderVO	> map = orderStaffService.getExecutedOrderList(1);
		assertNotNull(map);
	}

	@Test
	public void testGetCancelledOrderList() {
		Map<Integer, OrderVO	> map = orderStaffService.getCancelledOrderList(1);
		assertNotNull(map);
	}

	@Test
	public void testGetAbnormalOrderList() {
		Map<Integer, OrderVO	> map = orderStaffService.getAbnormalOrderList(1);
		assertNotNull(map);
	}

	@Test
	public void testExecuteOrder() {
		ResultMessage resultMessage = orderStaffService.executeOrder(3);
		assertEquals(ResultMessage.success, resultMessage);
	}

}
