package businesslogicservice.hotelinfoblservice;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

import businesslogic.hotelInfobl.HotelCustomerImpl;
import businesslogic.hotelInfobl.HotelStaffImpl;
import message.ResultMessage;
import rmi.ClientRunner;
import vo.CommentInfoVO;
import vo.HotelVO;

public class HotelStaffServiceTest {
	HotelCustomerService hotelCustomerService = new HotelCustomerImpl();
	HotelStaffService hotelStaffService = new HotelStaffImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClientRunner clientRunner = new ClientRunner();

	}

	@Test
	public void testModifyHotel() {
		HotelVO hotelVO = hotelCustomerService.getHotelInfo(111);
		ResultMessage resultMessage = hotelStaffService.modifyHotel(hotelVO);
		assertEquals(ResultMessage.success, resultMessage);
	}

	@Test
	public void testGetComments() {
		Map<Integer, CommentInfoVO> map = hotelStaffService.getComments(120);
		assertNotNull(map);
	}

}
