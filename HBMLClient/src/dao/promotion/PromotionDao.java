package dao.promotion;

import java.util.ArrayList;

import message.ResultMessage;
import po.PromotionPO;
import vo.PromotionVO;

public interface PromotionDao {
	 public void showPromotion();
	 
	 public void showPromotionList();

	 
	 public ResultMessage addPromotion(PromotionPO po);
	 
	 public ResultMessage modifyPromotion(PromotionPO po);
	 

}
