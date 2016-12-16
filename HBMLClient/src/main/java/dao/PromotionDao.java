package dao;

import message.ResultMessage;
import model.PromotionFilter;
import po.PromotionPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface PromotionDao extends Remote{
	public Map<Integer, PromotionPO> getHotelPromotionList(PromotionFilter promotionFilter)throws RemoteException,Exception;

	public Map<Integer, PromotionPO> getWebPromotionList(PromotionFilter promotionFilter)throws RemoteException,Exception;

	public ResultMessage addPromotion(PromotionPO po)throws RemoteException,Exception;

	public ResultMessage deletePromotion(int id)throws RemoteException,Exception;

	public ResultMessage updatePromotion(PromotionPO po)throws RemoteException,Exception;
	 

}
