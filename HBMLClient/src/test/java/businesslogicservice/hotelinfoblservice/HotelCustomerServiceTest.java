package businesslogicservice.hotelinfoblservice;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.hotelInfobl.HotelCustomerImpl;
import message.OrderStateMessage;
import message.ResultMessage;
import rmi.ClientRunner;
import vo.CommentInfoVO;
import vo.HotelVO;

public class HotelCustomerServiceTest {
	HotelCustomerService hotelCustomerService= new HotelCustomerImpl();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClientRunner clientRunner = new ClientRunner();

	}

	@Test
	public void testGetHotelList() {
		Map<Integer, HotelVO	> map = hotelCustomerService.getHotelList(null, null, new Date());
		assertNotNull(map);
	}

	@Test
	public void testHotelRecord() {
		Set<Integer> set =hotelCustomerService.hotelRecord(1, OrderStateMessage.Abnormal);
		assertNotNull(set);
	}

	@Test
	public void testGetHotelInfo() {
		HotelVO hotelVO = hotelCustomerService.getHotelInfo(120);
		assertNotNull(hotelVO);
	}

	@Test
	public void testAddComment() {
		ResultMessage resultMessage = hotelCustomerService.addComment(new CommentInfoVO(0, new Date(), 120, 8, "great", null, null, null));
		assertEquals(ResultMessage.success, resultMessage);
	}

}
