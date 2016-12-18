package businesslogicservice.promotionblservice;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.promotionbl.PromotionCustomerImpl;
import message.OrderStateMessage;
import message.ResultMessage;
import rmi.ClientRunner;
import vo.OrderVO;
import vo.PromotionVO;
import vo.SelectedPromotionVO;

public class PromotionCustomerServiceTest {

	PromotionCustomerService promotionCustomerService = new PromotionCustomerImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClientRunner clientRunner = new ClientRunner();
	}

	@Test
	public void testGetHotelPromotionList() {
		Map<Integer, PromotionVO> map = null;
		try {
			map = promotionCustomerService.getHotelPromotionList(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(map);
	}

	@Test
	public void testGetWebPromotionList() {
		Map<Integer, PromotionVO> map = null;
		try {
			map = promotionCustomerService.getWebPromotionList(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(map);
	}

	@Test
	public void testGetPromotion() {
		PromotionVO promotionVO = promotionCustomerService.getPromotion(1);
		assertNotNull(promotionVO);
	}

	@Test
	public void testGetSelectedPromotion() {
		SelectedPromotionVO selectedPromotionVO = null;
		try {
			selectedPromotionVO = promotionCustomerService.getSelectedPromotion(new OrderVO(0, 1, 120, "", 1, OrderStateMessage.Unexecuted, null,null,new Date(),null, null, 1,0,10000));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(selectedPromotionVO);
	}

}
