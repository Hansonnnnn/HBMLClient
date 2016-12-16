package businesslogic.promotionbl.helper;

import businesslogic.utility.TransferImpl;
import businesslogicservice.TransferService;
import dao.HotelDao;
import dao.PromotionDao;
import dao.UserDao;
import message.ResultMessage;
import model.PromotionFilter;
import po.PromotionPO;
import rmi.ClientRunner;
import vo.*;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by alex on 12/15/16.
 */
public class PromotionHelper {

    Map<Integer, PromotionVO> promotionList;
    PromotionDao promotionDao;
    UserDao userDao;
    HotelDao hotelDao;
    TransferService promotionTranserService;

    public PromotionHelper() {

        promotionDao= ClientRunner.remoteHelper.getPromotionDao();
        userDao=ClientRunner.remoteHelper.getUserDao();
        hotelDao=ClientRunner.remoteHelper.getHotelDao();
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


    public PromotionVO getPromotion(int promotionID) {

        return promotionList.get(promotionID);

    }

    public SelectedPromotionVO getSelectedPromotion(OrderVO orderVO)throws Exception{
        // to be finished
        int userID=orderVO.getUserID();
        int hotelID=orderVO.getHotelID();
        int currentPrice=orderVO.getPrice();
        Date generateTime=orderVO.getGenerateTime();
        UserVO userVO=promotionTranserService.poToVo(userDao.getUserData(userID));
        PromotionFilter promotionFilter=new PromotionFilter();
        promotionFilter.add("startDate","<",generateTime);
        promotionFilter.add("endDate",">",generateTime);

        Map<Integer,PromotionVO> hotelPromotionList=getHotelPromotionList(promotionFilter);
        Map<Integer,PromotionVO> webPromotionList=getWebPromotionList(promotionFilter);
        Map<Integer,SelectedPromotionVO> selectedPromotionVOMap=new LinkedHashMap<>();
        PromotionVO tempPromotion;
        for(int key: hotelPromotionList.keySet()){
            tempPromotion=hotelPromotionList.get(key);


        }




        return null;
    }


    public ResultMessage addHotelPromotion(PromotionVO vo) throws Exception{

        return promotionDao.addPromotion(promotionTranserService.voToPo(vo));

    }

    public ResultMessage addWebPromotion(PromotionVO vo) throws Exception{

        return promotionDao.addPromotion(promotionTranserService.voToPo(vo));

    }

    public ResultMessage deleteHotelPromotion(int promotionID) throws Exception{

        return promotionDao.deletePromotion(promotionID);

    }

    public ResultMessage deleteWebPromotion(int promotionID) throws Exception{

        return promotionDao.deletePromotion(promotionID);

    }

    public ResultMessage modifyHotelPromotion(PromotionVO vo) throws Exception{

        return promotionDao.updatePromotion(promotionTranserService.voToPo(vo));

    }

    public ResultMessage modifyWebPromotion(PromotionVO vo)throws Exception{

        return promotionDao.updatePromotion(promotionTranserService.voToPo(vo));

    }
}
