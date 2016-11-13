package businesslogicservice.promotionblservice;

import java.lang.reflect.Array;
import java.util.ArrayList;

import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public interface PromotionCustemerService {
	public WebPromotionVO showWebPromotion();
	public ArrayList<WebPromotionVO> showWebPromotionList();
	public HotelPromotionVO showHotelPromotion();
	public ArrayList<HotelPromotionVO> showHotelPromotionList();
}
