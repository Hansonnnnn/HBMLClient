
import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import businesslogic.hotelInfobl.HotelCustomerImpl;
import businesslogic.hotelInfobl.helper.HotelHelper;
import businesslogic.orderbl.OrderCustomerServiceImpl;
import businesslogic.orderbl.orderhelper.OrderList;
import businesslogicservice.hotelinfoblservice.HotelCustomerService;
import businesslogicservice.orderblservice.OrderCustomerService;
import presentation.controller.HotelInfoViewControllerImpl;
import presentation.controller.OrderViewControllerImpl;
import vo.HotelVO;

public class AllModuleTest {

	@Test
	public void testOrderShowOrderInfo() 
	{
//		OrderCustomerService customerservice = new OrderCustomerServiceImpl();
//		OrderViewControllerImpl controller = new OrderViewControllerImpl(customerservice);
//		MockObject_Order mock1 = new MockObject_Order("161113");
//		MockObject_Order mock2= new MockObject_Order("161112");
//		
//		OrderList list = new OrderList();
//		list.addItem(mock1);
//		list.addItem(mock2);
//		
//		OrderVO order = controller.showOrderInfo("161113");
//		assertEquals("161113",order.getId());
	}
	@Test
	public void testOrderShowOrderList(){}
	@Test
	public void testOrderUpdateOrderPO(){}
	@Test
	public void testOrderCustomerMakeOrder(){}
	@Test
	public void testOrderCustomerCancleOrder(){}
	@Test
	public void testOrderCustomerEditOrder(){}
	@Test
	public void testOrderCustomerEvaluateOrder(){}
	@Test
	public void testOrderCustomerSaveAppeal(){}
	@Test
	public void testOrderStaffExecuteOrder(){}
	@Test
	public void testOrderWebMarketCheckAppealReason(){}
	@Test
	public void testOrderWebMarketSaveAppealReason(){}
	@Test
	public void testOrderWebMarketShowAppealList(){}
	@Test
	public void testHotelGetHotelInfo() throws RemoteException
	{
//		HotelCustomerService customerservice = new HotelCustomerImpl(); 
//		HotelInfoViewControllerImpl controller = new HotelInfoViewControllerImpl(customerservice);
//		MockObject_Hotel mock1 = new MockObject_Hotel("Big");
//		MockObject_Hotel mock2 = new MockObject_Hotel("Small");
//		
//		HotelList list = new HotelList();
//		list.addHotel(mock1);
//		list.addHotel(mock2);
//		
//		HotelVO hotel = controller.showHotelInfo("Big");
//		assertEquals("Big", hotel.getName());
	}
	@Test
	public void testHotelAddHotel(){}
	@Test
	public void testHotelDeleteHotel(){}
	@Test
	public void testHotelGetHotelList(){}
	@Test
	public void testHotelModifyHotel(){}
	@Test
	public void testHotelCustomerShowOrderInfoAndList(){}
	@Test
	public void testHotelManagerModifyHotel(){}
	@Test
	public void testHotelWebMarketerAddHotel(){}
	@Test
	public void testHotelWebMarketerDeleteHotel(){}
	@Test
	public void testHotelWebMarketerGetHotelList(){}
	@Test
	public void testHotelWebMarketerModifyHotel(){}
	@Test
	public void testCreditAddCredit(){}
	@Test
	public void testCreditGetCreditInfo(){}
	@Test
	public void testCreditResumeCredit(){}
	@Test
	public void testCreditSetCreditValue(){}
	@Test
	public void testCreditShowCreditAndRecord(){}
	@Test
	public void testCreditCustomerGetAccount(){}
	@Test
	public void testCreditCustomerGetChangeType(){}
	@Test
	public void testCreditCustomerGetReasonType(){}
	
	
	@Test
	public void testUser()
	{
//		UserService userservice = new UserImpl(); 
//		UserViewControllerImpl controller = new UserViewControllerImpl(userservice);
//		MockObject_user mock1 = new MockObject_user("admin");
//		MockObject_user mock2 = new MockObject_user("user");
//		
//		UserList list = new UserList();
//		list.addHotel(mock1);
//		list.addHotel(mock2);
//		
//		UserVO user = controller.showUserInfo("admin");
//		assertEquals("admin", user.getName());
	}
	

	@Test
	public void testPromotionAddPromotion(){}
	@Test
	public void testPromotionDeletePromotion(){}
	@Test
	public void testPromotionGetPromotion(){}
	@Test
	public void testPromotionShowPromotionInfoAndList(){}
	@Test
	public void testAddRoom(){}
	@Test
	public void testRoomDeleteRoom(){}
	@Test
	public void testRoomGetRoomInfoAndList(){}
	@Test
	public void testRoomModifyRoomAndState(){}
	
	
	@Test
	public void testUserAddUser(){}
	@Test
	public void testUserDeleteUser(){}
	@Test
	public void testUserLogin(){}
	@Test
	public void testUserLogout(){}
	@Test
	public void testUserModify(){}
	@Test
	public void testUserShowUserInfoAndList(){}
	@Test
	public void testUserSignUp(){}
}
