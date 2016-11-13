package businesslogic.promotionbl;

import java.util.ArrayList;

import dao.promotion.PromotionDao;
import message.ResultMessage;
import po.HotelPromotionPO;
import po.WebPromotionPO;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public class PromotionDaoImpl_stub implements PromotionDao{

	@Override
	public void showPromotion() {
		// TODO 自动生成的方法存根
		System.out.println("show promotion success");
	}

	@Override
	public void showPromotionList() {
		// TODO 自动生成的方法存根
		System.out.println("show promotionlist success");
	}

	@Override
	public boolean addPromotion(HotelPromotionVO hotelPromotionVO) {
		// TODO 自动生成的方法存根
		System.out.println("add HotelPromotion success");
		return false;
	}

	@Override
	public boolean addPromotion(WebPromotionVO webPromotionVO) {
		// TODO 自动生成的方法存根
		System.out.println("add WebPromotion");
		return false;
	}

	@Override
	public boolean deletePromotion(String ID) {
		// TODO 自动生成的方法存根
		if(ID=="0001"){
			System.out.println("delete Promotion success");
		}
		return false;
	}

	@Override
	public boolean modify(HotelPromotionVO hotelPromotionVO) {
		// TODO 自动生成的方法存根
		System.out.println("modify hotelPromotion success");
		return false;
	}

	@Override
	public boolean modify(WebPromotionVO webPromotionVO) {
		// TODO 自动生成的方法存根
		System.out.println("modify webPromotion success");
		return false;
	}

	@Override
	public HotelPromotionVO getHotelPromotionVO() {
		// TODO 自动生成的方法存根
		System.out.println("get HotelpromotionVO success");
		return null;
	}

	@Override
	public WebPromotionVO getWebPromotionVO() {
		// TODO 自动生成的方法存根
		System.out.println("get WebPromotionVO success");
		return null;
	}

	@Override
	public WebPromotionVO showWebPromotion() {
		// TODO 自动生成的方法存根
		System.out.println("show WebPromotion success");
		return null;
	}

	@Override
	public ArrayList<WebPromotionVO> showWebPromotionList() {
		// TODO 自动生成的方法存根
		System.out.println("show WebPromotionList success");
		return null;
	}

	@Override
	public HotelPromotionVO showHotelPromotion() {
		// TODO 自动生成的方法存根
		System.out.println("show HotelPromotion success");
		return null;
	}

	@Override
	public ArrayList<HotelPromotionVO> showHotelPromotionList() {
		// TODO 自动生成的方法存根
		System.out.println("show HotelPrmotionList success");
		return null;
	}

	@Override
	public ResultMessage addHotelPromotion(HotelPromotionPO po) {
		// TODO 自动生成的方法存根
		System.out.println("add HotelPromotion success");
		return null;
	}

	@Override
	public ResultMessage modifyHotelPromotion(HotelPromotionPO po) {
		// TODO 自动生成的方法存根
		System.out.println("modify HotelPromotion success");
		return null;
	}

	@Override
	public ResultMessage addWebPromotion(WebPromotionPO po) {
		// TODO 自动生成的方法存根
		System.out.println("add WebPromotion success");
		return null;
	}

	@Override
	public ResultMessage modifyWebPromotion(WebPromotionPO po) {
		// TODO 自动生成的方法存根
		System.out.println("modify WebPromotion success");
		return null;
	}

	

}
