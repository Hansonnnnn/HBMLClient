package businesslogicservice.orderblservice;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.orderbl.OrderWebMarketerServiceImpl;
import message.ResultMessage;
import rmi.ClientRunner;
import vo.AppealVO;

public class OrderWebMarketerServiceTest {

	OrderWebMarketerService orderWebMarketerService = new OrderWebMarketerServiceImpl(); 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClientRunner clientRunner = new ClientRunner();
	}

	@Test
	public void testGetAppealOrderList() {
		Map<Integer, AppealVO> map = orderWebMarketerService.getAppealOrderList(1);
		assertNotNull(map);
	}

	@Test
	public void testModifyAppealOrder() {
		ResultMessage resultMessage = null;
		Map<Integer, AppealVO> map = orderWebMarketerService.getAppealOrderList(1);
		for (AppealVO appealVO : map.values()) {
			resultMessage = orderWebMarketerService.modifyAppealOrder(appealVO);
			break;
		}
		assertEquals(ResultMessage.success, resultMessage);
	}

}
