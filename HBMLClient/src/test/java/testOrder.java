

import java.util.Map;

import businesslogic.orderbl.OrderCustomerServiceImpl;
import businesslogic.orderbl.OrderStaffServiceImpl;
import businesslogicservice.orderblservice.OrderCustomerService;
import businesslogicservice.orderblservice.OrderStaffService;
import rmi.ClientRunner;
import vo.OrderVO;
public class testOrder {

	public static void main(String[] args) {
		ClientRunner clientRunner = new ClientRunner();
		OrderCustomerService orderCustomerService = new OrderCustomerServiceImpl();
		Map<Integer, OrderVO> map = orderCustomerService.getAbnormalOrderList(1);
		for (OrderVO orderVO : map.values()) {
			System.out.println(orderVO);
		}
		
		/*
		/*RoomInfoCustomerService roominfoCustomerService = new RoomInfoCustomerServiceImpl();
		Map<String, RoomInfoVO> map = roominfoCustomerService.getRoomList(119, new Date());
		for (RoomInfoVO roomInfoVO : map.values()) {
			System.out.println(roomInfoVO);
		}*/
		/*CreditWebMarketerService creditWebMarketerService = new CreditWebMarketerImpl();
		Map<Integer, RankVO> map = creditWebMarketerService.getRankList();
		
		for (RankVO rankVO : map.values()) {
			System.out.println(rankVO);
		}*/
	/*	RoomInfoCustomerService roomInfoCustomerService = new RoomInfoCustomerServiceImpl();
		Map<String, RoomInfoVO> map = roomInfoCustomerService.getRoomList(120, new Date());
		for (RoomInfoVO roomInfoVO : map.values()) {
			System.out.println(roomInfoVO);
		}*/

		/*UserStaffService userStaffService = new UserStaffImpl();
		try {
			System.out.println(userStaffService.getUserData(6).getUserType());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*OrderWebMarketerService orderWebMarketerService = new OrderWebMarketerServiceImpl();
		Map<Integer, AppealVO> map = orderWebMarketerService.getAppealOrderList(8);
		for (AppealVO appealVO : map.values()) {
			System.out.println(appealVO);
		}*/
		
		OrderStaffService orderStaffService = new OrderStaffServiceImpl();
		for (OrderVO orderVO :orderStaffService.getExecutedOrderList(120).values() ) {
			System.out.println(orderVO);
		}
	}
}
