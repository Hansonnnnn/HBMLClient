package businesslogicservice.promotionblservice;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.promotionbl.PromotionWebMarketerImpl;
import message.ResultMessage;
import rmi.ClientRunner;
import vo.PromotionVO;

public class PromotionWebMarketerServiceTest {
	PromotionWebMarketerService promotionWebMarketerService = new PromotionWebMarketerImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClientRunner clientRunner = new ClientRunner();
	}
	@Test
	public void testGetWebPromotionList() {
		Map<Integer, PromotionVO> map =null;
		try {
			map = promotionWebMarketerService.getWebPromotionList(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(map);
	}

	@Test
	public void testGetPromotion() {
		PromotionVO promotionVO = null;
		promotionVO = promotionWebMarketerService.getPromotion(2);
		assertNotNull(promotionVO);
	}

	@Test
	public void testAddWebPromotion() {
		PromotionVO vo= promotionWebMarketerService.getPromotion(2);
		ResultMessage resultMessage = null;
		try {
			resultMessage = promotionWebMarketerService.addWebPromotion(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(ResultMessage.success, resultMessage);
	}

	@Test
	public void testDeleteWebPromotion() {
		ResultMessage resultMessage = null;
		try {
			resultMessage = promotionWebMarketerService.deleteWebPromotion(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(ResultMessage.success, resultMessage);
	}

	@Test
	public void testModifyWebPromotion() {
		PromotionVO vo= promotionWebMarketerService.getPromotion(2);
		ResultMessage resultMessage = null;
		try {
			resultMessage = promotionWebMarketerService.modifyWebPromotion(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(ResultMessage.success, resultMessage);
		
	}

}
