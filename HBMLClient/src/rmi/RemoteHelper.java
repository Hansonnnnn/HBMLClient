package rmi;

import java.rmi.Remote;

import dao.hotel.HotelDao;
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

	public UserDao getUserDao(){return (UserDao)remote;}
}