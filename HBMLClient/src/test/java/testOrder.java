import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.orderbl.OrderCustomerServiceImpl;
import businesslogic.roomInfobl.RoomInfoCustomerServiceImpl;
import businesslogicservice.orderblservice.OrderCustomerService;
import businesslogicservice.roominfoblservice.RoomInfoCustomerService;
import rmi.ClientRunner;
import vo.OrderVO;
import vo.RoomInfoVO;

public class testOrder {

	public static void main(String[] args) {
		ClientRunner clientRunner = new ClientRunner();
		/*OrderCustomerService orderCustomerService = new OrderCustomerServiceImpl();
		Map<Integer, OrderVO> map = orderCustomerService.getAbnormalOrderList(1);
		for (OrderVO orderVO : map.values()) {
			System.out.println(orderVO);
		}*/
		
		
		RoomInfoCustomerService roominfoCustomerService = new RoomInfoCustomerServiceImpl();
		Map<String, RoomInfoVO> map = roominfoCustomerService.getRoomList(120, null);
		for (RoomInfoVO roomInfoVO : map.values()) {
			System.out.println(roomInfoVO);
		}
	}
}
