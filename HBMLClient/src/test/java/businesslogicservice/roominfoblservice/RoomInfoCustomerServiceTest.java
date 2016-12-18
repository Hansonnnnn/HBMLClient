package businesslogicservice.roominfoblservice;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.roomInfobl.RoomInfoCustomerServiceImpl;
import rmi.ClientRunner;
import vo.RoomInfoVO;

public class RoomInfoCustomerServiceTest {

	RoomInfoCustomerService roominfoCustomerService = new RoomInfoCustomerServiceImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClientRunner clientRunner = new ClientRunner();
	}

	@Test
	public void testGetRoomList() {
		Map<String, RoomInfoVO> map = roominfoCustomerService.getRoomList(120, null);
	
		assertNotNull(map.values());
	}

}
