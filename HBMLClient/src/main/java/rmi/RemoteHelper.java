package rmi;

import java.rmi.Remote;

import dao.credit.CreditDao;
import dao.hotel.HotelDao;
import dao.order.OrderDao;
import dao.promotion.PromotionDao;
import dao.roominfo.RoomDao;
import dao.user.UserDao;


public class RemoteHelper {
	private Remote remote;

	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	public HotelDao getHotelDao(){
		return (HotelDao)remote;
	}
	//别的Dao加在这里，与此类似

	public RoomDao getRoomDao() {
		
		return (RoomDao)remote;
	}

	public UserDao getUserDao(){
		
		return (UserDao)remote;
	}
	
	public OrderDao getOrderDao() {
		
		return (OrderDao)remote;
	}
	
	public PromotionDao getPromotionDao() {
		
		return (PromotionDao)remote;
	}
	
	public CreditDao getCreditDao() {
	
	return (CreditDao)remote;
	}
}