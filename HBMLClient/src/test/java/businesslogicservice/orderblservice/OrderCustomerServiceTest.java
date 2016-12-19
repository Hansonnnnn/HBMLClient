package businesslogicservice.orderblservice;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.orderbl.OrderCustomerServiceImpl;
import message.ResultMessage;
import rmi.ClientRunner;
import vo.AppealVO;
import vo.OrderVO;

public class OrderCustomerServiceTest {

	OrderCustomerService orderCustomerService = new OrderCustomerServiceImpl(); 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClientRunner clientRunner = new ClientRunner();
	}

	@Test
	public void testGetUnexecutedOrderList() {
		Map<Integer, OrderVO	> map = orderCustomerService.getUnexecutedOrderList(1);
		assertNotNull(map);
	}

	@Test
	public void testGetExecutedOrderList() {
		Map<Integer, OrderVO	> map = orderCustomerService.getExecutedOrderList(1);
		assertNotNull(map);
	}

	@Test
	public void testGetCancelledOrderList() {
		Map<Integer, OrderVO	> map = orderCustomerService.getCancelledOrderList(1);
		assertNotNull(map);
	}

	@Test
	public void testGetAbnormalOrderList() {
		Map<Integer, OrderVO	> map = orderCustomerService.getAbnormalOrderList(1);
		assertNotNull(map);
	}

	@Test
	public void testGetUnexecutedOrderListOfSpecificHotel() {
		Map<Integer, OrderVO	> map = orderCustomerService.getUnexecutedOrderListOfSpecificHotel(1, 120);
		assertNotNull(map);
	}

	@Test
	public void testGetExecutedOrderListOfSpecificHotel() {
		Map<Integer, OrderVO	> map = orderCustomerService.getExecutedOrderListOfSpecificHotel(1, 120);
		assertNotNull(map);
	}

	@Test
	public void testGetCancelledOrderListOfSpecificHotel() {
		Map<Integer, OrderVO	> map = orderCustomerService.getCancelledOrderListOfSpecificHotel(1, 120);
		assertNotNull(map);
	}

	@Test
	public void testGetAbnormalOrderListOfSpecificHotel() {
		Map<Integer, OrderVO	> map = orderCustomerService.getAbnormalOrderListOfSpecificHotel(1, 120);
		assertNotNull(map);
	}

	@Test
	public void testRevokeOrder() {
		ResultMessage resultMessage = orderCustomerService.revokeOrder(2);
		assertEquals(ResultMessage.success, resultMessage);
	}

	@Test
	public void testAddOrder() {
		ResultMessage resultMessage = null;
		Map<Integer, OrderVO	> map = orderCustomerService.getAbnormalOrderListOfSpecificHotel(1, 120);
		for (OrderVO orderVO : map.values()) {
			resultMessage = orderCustomerService.addOrder(orderVO);
			break;
		}
		assertEquals(ResultMessage.success, resultMessage);
	}

	@Test
	public void testAddAppealOrder() {
		ResultMessage resultMessage = orderCustomerService.addAppealOrder(new AppealVO(0, 3, 1, 0, null, "Junit测试", null));
		assertEquals(ResultMessage.success, resultMessage);
	}

}
