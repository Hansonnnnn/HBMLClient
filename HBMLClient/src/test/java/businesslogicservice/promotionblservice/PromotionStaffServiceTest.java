package businesslogicservice.promotionblservice;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.promotionbl.PromotionStaffImpl;
import message.ResultMessage;
import rmi.ClientRunner;
import vo.PromotionVO;

public class PromotionStaffServiceTest {
	PromotionStaffService promotionStaffService = new PromotionStaffImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClientRunner clientRunner = new ClientRunner();
	}
	@Test
	public void testGetHotelPromotionList() {
		Map<Integer, PromotionVO> map =null;
		try {
			map = promotionStaffService.getHotelPromotionList(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(map);
	}

	@Test
	public void testGetPromotion() {
		PromotionVO promotionVO = null;
		promotionVO = promotionStaffService.getPromotion(1);
		assertNotNull(promotionVO);
	}

	@Test
	public void testAddHotelPromotion() {
		PromotionVO vo= promotionStaffService.getPromotion(1);
		ResultMessage resultMessage = null;
		try {
			resultMessage = promotionStaffService.addHotelPromotion(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(ResultMessage.success, resultMessage);
	}

	@Test
	public void testDeleteHotelPromotion() {
		ResultMessage resultMessage = null;
		try {
			resultMessage = promotionStaffService.deleteHotelPromotion(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(ResultMessage.success, resultMessage);
	}

	@Test
	public void testModifyHotelPromotion() {
		PromotionVO vo= promotionStaffService.getPromotion(1);
		ResultMessage resultMessage = null;
		try {
			resultMessage = promotionStaffService.modifyHotelPromotion(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(ResultMessage.success, resultMessage);
		
	}

}
