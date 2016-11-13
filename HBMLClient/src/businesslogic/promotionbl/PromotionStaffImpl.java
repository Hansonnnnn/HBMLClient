package businesslogic.promotionbl;

import businesslogicservice.promotionblservice.PromotionStaffService;
import dao.promotion.PromotionDao;
import message.ResultMessage;
import po.HotelPromotionPO;

public class PromotionStaffImpl implements PromotionStaffService{
	
	private PromotionDao promotionDao;
	
	@Override
	public ResultMessage addHotelPromotion(HotelPromotionPO po) {
		// TODO 自动生成的方法存根
		promotionDao=new PromotionDaoImpl_stub();
		try {
			promotionDao.addHotelPromotion(po);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage modifyHotelPromotion(HotelPromotionPO po) {
		// TODO 自动生成的方法存根
		promotionDao=new PromotionDaoImpl_stub();
		try {
			promotionDao.modifyHotelPromotion(po);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
