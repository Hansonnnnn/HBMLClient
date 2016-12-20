import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.creditbl.CreditWebMarketerImpl;
import businesslogic.orderbl.OrderCustomerServiceImpl;
import businesslogic.roomInfobl.RoomInfoCustomerServiceImpl;
import businesslogic.userbl.UserCustomerImpl;
import businesslogic.userbl.UserStaffImpl;
import businesslogicservice.creditblservice.CreditWebMarketerService;
import businesslogicservice.orderblservice.OrderCustomerService;
import businesslogicservice.roominfoblservice.RoomInfoCustomerService;
import businesslogicservice.userblservice.UserCustomerService;
import businesslogicservice.userblservice.UserStaffService;
import dao.CreditDao;
import rmi.ClientRunner;
import vo.HotelVO;
import vo.OrderVO;
import vo.RankVO;
import vo.RoomInfoVO;

public class testOrder {

	public static void main(String[] args) {
		ClientRunner clientRunner = new ClientRunner();
		/*OrderCustomerService orderCustomerService = new OrderCustomerServiceImpl();
		Map<Integer, OrderVO> map = orderCustomerService.getAbnormalOrderList(1);
		for (OrderVO orderVO : map.values()) {
			System.out.println(orderVO);
		}*/
		
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
		
		
		UserStaffService userStaffService = new UserStaffImpl();
		try {
			System.out.println(userStaffService.getUserData(6).getUserType());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
