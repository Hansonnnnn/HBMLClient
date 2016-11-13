package businesslogic.promotionbl;

import java.util.ArrayList;

import businesslogicservice.promotionblservice.PromotionCustemerService;
import dao.PromotionDao;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public class PromotionCustomerImpl implements PromotionCustemerService{
	
	private PromotionDao promotionDao;
	
	WebPromotionVO webPromotionVO;
	
	@Override
	public WebPromotionVO showWebPromotion() {
		// TODO 自动生成的方法存根
		promotionDao=new PromotionDaoImpl_stub();
		try {
			webPromotionVO=promotionDao.showWebPromotion();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<WebPromotionVO> showWebPromotionList() {
		// TODO 自动生成的方法存根
		promotionDao=new PromotionDaoImpl_stub();
		try {
			promotionDao.showWebPromotionList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public HotelPromotionVO showHotelPromotion() {
		// TODO 自动生成的方法存根
		promotionDao=new PromotionDaoImpl_stub();
		try {
			promotionDao.showHotelPromotion();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public ArrayList<HotelPromotionVO> showHotelPromotionList() {
		// TODO 自动生成的方法存根
		promotionDao=new PromotionDaoImpl_stub();
		try {
			promotionDao.showHotelPromotionList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
