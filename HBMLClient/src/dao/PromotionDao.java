package dao;

import java.util.ArrayList;

import message.ResultMessage;
import po.HotelPromotionPO;
import po.WebPromotionPO;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public interface PromotionDao {
	 public void showPromotion();
	 
	 public void showPromotionList();
	 
	 public boolean addPromotion(HotelPromotionVO hotelPromotionVO);
	 
	 public boolean addPromotion(WebPromotionVO webPromotionVO);
	 
	 public boolean deletePromotion(String ID);
	 
	 public boolean modify(HotelPromotionVO hotelPromotionVO);
	 
	 public boolean modify(WebPromotionVO webPromotionVO);
	 
	 public HotelPromotionVO getHotelPromotionVO();
	 
	 public WebPromotionVO getWebPromotionVO();
	 
	 public WebPromotionVO showWebPromotion();
	 
	 public ArrayList<WebPromotionVO> showWebPromotionList();
	 
	 public HotelPromotionVO showHotelPromotion();
	 
	 public ArrayList<HotelPromotionVO> showHotelPromotionList();
	 
	 public ResultMessage addHotelPromotion(HotelPromotionPO po);
	 
	 public ResultMessage modifyHotelPromotion(HotelPromotionPO po);
	 
	 public ResultMessage addWebPromotion(WebPromotionPO po);
	 
	 public ResultMessage modifyWebPromotion(WebPromotionPO po);
}
