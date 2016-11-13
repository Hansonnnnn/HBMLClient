package businesslogic.promotionbl;

import java.util.ArrayList;

import businesslogicservice.promotionblservice.PromotionCustemerService;
import dao.promotion.PromotionDao;
import vo.PromotionVO;

public class PromotionCustomerImpl implements PromotionCustemerService{
	
	private PromotionDao promotionDao;
	
	PromotionVO webPromotionVO;
	
	@Override
	public PromotionVO showPromotion() {
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
	public ArrayList<PromotionVO> showPromotionList() {
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

}
