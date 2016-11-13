package dao.promotion;

import java.util.ArrayList;

import message.ResultMessage;
import po.PromotionPO;
import vo.PromotionVO;

public interface PromotionDao {
	 public void showPromotion();
	 
	 public void showPromotionList();
	 
	 public boolean addPromotion(PromotionVO hotelPromotionVO);
	 

	 
	 public boolean deletePromotion(String ID);
	 
	 public boolean modify(PromotionVO hotelPromotionVO);
	 

	 
	 public PromotionVO getHotelPromotionVO();
	 
	 public PromotionVO getWebPromotionVO();
	 
	 public PromotionVO showWebPromotion();
	 
	 public ArrayList<PromotionVO> showWebPromotionList();
	 
	 public PromotionVO showHotelPromotion();
	 
	 public ArrayList<PromotionVO> showHotelPromotionList();
	 
	 public ResultMessage addHotelPromotion(PromotionPO po);
	 
	 public ResultMessage modifyHotelPromotion(PromotionPO po);
	 
	 public ResultMessage addWebPromotion(PromotionPO po);
	 
	 public ResultMessage modifyWebPromotion(PromotionPO po);
}
