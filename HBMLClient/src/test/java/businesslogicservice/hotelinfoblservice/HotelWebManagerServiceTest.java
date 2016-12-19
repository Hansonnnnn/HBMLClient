package businesslogicservice.hotelinfoblservice;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.hotelInfobl.HotelWebManagerImpl;
import message.ResultMessage;
import rmi.ClientRunner;
import vo.HotelVO;

public class HotelWebManagerServiceTest {

	HotelWebManagerService hotelWebManagerService = new HotelWebManagerImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClientRunner clientRunner = new ClientRunner();

	}

	@Test
	public void testGetHotelList() {
		
		Map<Integer, HotelVO> map = hotelWebManagerService.getHotelList("君悦");
		assertNotNull(map);
	}

	@Test
	public void testGetAllHotel() {
		Map<Integer, HotelVO> map = hotelWebManagerService.getAllHotel();
		assertNotNull(map);
	}

	@Test
	public void testGetHotelInfo() {
		HotelVO hotelVO = hotelWebManagerService.getHotelInfo(120);
		assertNotNull(hotelVO);
	}

	@Test
	public void testAddHotel() {
		HotelVO hotelVO = hotelWebManagerService.getHotelInfo(143);
		int i = hotelWebManagerService.addHotel(hotelVO);
		assertEquals(146, i);
	}

	@Test
	public void testModifyHotel() {
		HotelVO hotelVO = hotelWebManagerService.getHotelInfo(120);
		ResultMessage resultMessage = hotelWebManagerService.modifyHotel(hotelVO);
		assertEquals(ResultMessage.success, resultMessage);
	}

	@Test
	public void testDeleteHotel() {
		ResultMessage resultMessage = hotelWebManagerService.deleteHotel(117);
		assertEquals(ResultMessage.success, resultMessage);	
	}

}
