package businesslogicservice.roominfoblservice;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.roomInfobl.RoomInfoStaffServiceImpl;
import message.ResultMessage;
import message.RoomStateMessage;
import vo.RoomInfoVO;

public class RoomInfoStaffServiceTest {

	RoomInfoStaffService roomInfoStaffService= new RoomInfoStaffServiceImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	public void testGetRoomList() {
		Map<String, RoomInfoVO> map = roomInfoStaffService.getRoomList(120);
		assertNotNull(map);
	}

	@Test
	public void testGetRoomInfo() {
		RoomInfoVO roomInfoVO = roomInfoStaffService.getRoomInfo("测试房");
		assertNotNull(roomInfoVO);
	}

	@Test
	public void testAddRoom() {
		RoomInfoVO roomInfoVO = roomInfoStaffService.getRoomInfo("测试房");
		ResultMessage resultMessage = roomInfoStaffService.addRoom(roomInfoVO);
		assertEquals(ResultMessage.success, resultMessage);
	}

	@Test
	public void testModifyRoom() {
		RoomInfoVO roomInfoVO = roomInfoStaffService.getRoomInfo("测试房");
		ResultMessage resultMessage = roomInfoStaffService.modifyRoom(roomInfoVO);
		assertEquals(ResultMessage.success, resultMessage);
	}

	@Test
	public void testDeleteRoomInt() {
		ResultMessage resultMessage = roomInfoStaffService.deleteRoom(21);
		assertEquals(ResultMessage.success, resultMessage);
	}

	@Test
	public void testDeleteRoomIntString() {
		ResultMessage resultMessage = roomInfoStaffService.deleteRoom(120, "测试房2");
		assertEquals(ResultMessage.success, resultMessage);

	}

	@Test
	public void testModifyRoomState() {
		ResultMessage resultMessage = roomInfoStaffService.modifyRoomState(8, RoomStateMessage.Booked);
		assertEquals(ResultMessage.success, resultMessage);	
	}

	@Test
	public void testSetPrice() {
		ResultMessage resultMessage = roomInfoStaffService.setPrice(14, 221);
		assertEquals(ResultMessage.success, resultMessage);
	}

}
