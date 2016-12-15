package businesslogic.promotionbl.helper;

import businesslogic.utility.TransferImpl;
import businesslogicservice.TransferService;
import dao.PromotionDao;
import model.PromotionFilter;
import po.PromotionPO;
import rmi.ClientRunner;
import vo.PromotionVO;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by alex on 12/15/16.
 */
public class PromotionHelper {

    Map<Integer, PromotionVO> promotionList;
    PromotionDao promotionDao;
    TransferService promotionTranserService;

    public PromotionHelper() {
        promotionDao= ClientRunner.remoteHelper.getPromotionDao();
        promotionTranserService=new TransferImpl();
    }

    public Map<Integer, PromotionVO> getHotelPromotionList(PromotionFilter promotionFilter) throws Exception{
        Map<Integer,PromotionPO> map=promotionDao.getHotelPromotionList(promotionFilter);
        promotionList=new LinkedHashMap<>();
        for(int key:map.keySet()){
            promotionList.put(key,promotionTranserService.poToVo(map.get(key)));
        }
        return promotionList;
    }

    public Map<Integer, PromotionVO> getWebPromotionList(PromotionFilter promotionFilter)throws Exception {
        Map<Integer,PromotionPO> map=promotionDao.getWebPromotionList(promotionFilter);
        promotionList=new LinkedHashMap<>();
        for(int key:map.keySet()){
            promotionList.put(key,promotionTranserService.poToVo(map.get(key)));
        }
        return promotionList;
    }



}
