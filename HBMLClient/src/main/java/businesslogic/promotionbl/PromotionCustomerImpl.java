package businesslogic.promotionbl;

import java.util.ArrayList;
import java.util.List;

import businesslogic.utility.TransferImpl;
import businesslogicservice.promotionblservice.PromotionCustemerService;
import dao.PromotionDao;
import po.PromotionPO;
import vo.PromotionVO;

public class PromotionCustomerImpl implements PromotionCustemerService{
	
	private PromotionDao promotionDao;
	
	PromotionVO webPromotionVO;
	
	@Override
	public PromotionVO showPromotion() {
		// TODO 自动生成的方法存根
		promotionDao=new PromotionDaoImpl_stub();
		try {
			TransferImpl transfer=new TransferImpl();
			webPromotionVO=transfer.poToVo(promotionDao.showPromotion());
			return webPromotionVO;
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
			TransferImpl transfer=new TransferImpl();
			List<PromotionPO> promotionPOs=promotionDao.showPromotionList();
			ArrayList<PromotionVO> promotionVOs=new ArrayList<PromotionVO>();
			for(int i=0;i<promotionPOs.size();i++){
				promotionVOs.add(transfer.poToVo(promotionPOs.get(i)));
			}
			return promotionVOs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
