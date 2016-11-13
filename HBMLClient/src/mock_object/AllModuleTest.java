package mock_object;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import businesslogic.hotelInfobl.HotelCustomerImpl;
import businesslogic.hotelInfobl.hotelhelper.HotelList;
import businesslogic.orderbl.OrderCustomerServiceImpl;
import businesslogic.orderbl.orderhelper.OrderList;
import businesslogicservice.hotelinfoblservice.HotelCustomerService;
import businesslogicservice.orderblservice.OrderCustomerService;
import presentation.controller.HotelInfoViewControllerImpl;
import presentation.controller.OrderViewControllerImpl;
import vo.HotelVO;
import vo.OrderVO;

public class AllModuleTest {

	@Test
	public void testOrder() 
	{
		OrderCustomerService customerservice = new OrderCustomerServiceImpl();
		OrderViewControllerImpl controller = new OrderViewControllerImpl(customerservice);
		MockObject_Order mock1 = new MockObject_Order("161113");
		MockObject_Order mock2= new MockObject_Order("161112");
		
		OrderList list = new OrderList();
		list.addItem(mock1);
		list.addItem(mock2);
		
		OrderVO order = controller.showOrderInfo("161113");
		assertEquals("161113",order.getId());
	}

	public void testHotel() throws RemoteException
	{
		HotelCustomerService customerservice = new HotelCustomerImpl(); 
		HotelInfoViewControllerImpl controller = new HotelInfoViewControllerImpl(customerservice);
		MockObject_Hotel mock1 = new MockObject_Hotel("Big");
		MockObject_Hotel mock2 = new MockObject_Hotel("Small");
		
		HotelList list = new HotelList();
		list.addHotel(mock1);
		list.addHotel(mock2);
		
		HotelVO hotel = controller.showHotelInfo("Big");
		assertEquals("Big", hotel.getName());
	}
	
	public void testuser()
	{
		
	}
}
