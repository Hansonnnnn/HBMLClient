package businesslogic.promotionbl;

import businesslogicservice.promotionblservice.PromotionWebMarketerService;
import dao.PromotionDao;
import message.ResultMessage;
import po.WebPromotionPO;

public class PromotionWebMarketerImpl implements PromotionWebMarketerService{
	
	private PromotionDao promotionDao;
	
	@Override
	public ResultMessage addWebPromotion(WebPromotionPO po) {
		promotionDao=new PromotionDaoImpl_stub();
		try {
			promotionDao.addWebPromotion(po);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage modifyWebPromotion(WebPromotionPO po) {
		// TODO 自动生成的方法存根
		promotionDao=new PromotionDaoImpl_stub();
		try {
			promotionDao.modifyWebPromotion(po);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
