package dao.promotion;

import java.util.ArrayList;
import java.util.List;

import message.ResultMessage;
import po.PromotionPO;
import vo.PromotionVO;

public interface PromotionDao {
	 public PromotionPO showPromotion();
	 
	 public List<PromotionPO> showPromotionList();

	 
	 public ResultMessage addPromotion(PromotionPO po);
	 
	 public ResultMessage modifyPromotion(PromotionPO po);
	 

}
