package businesslogic.hotelInfobl;

import java.rmi.RemoteException;

import PO.HotelPO;
import VO.HotelVO;
import businesslogicservice.hotelinfoblservice.HotelManagerService;
import dao.HotelDao;
import rmi.ClientRunner;

public class HotelManagerImpl implements HotelManagerService{

	
	private int hotel_ID;
	
	private HotelPO[] hotelList;
	
	private HotelDao hotelDao;
	
	public HotelManagerImpl(int hotel_ID) {
		this.hotel_ID = hotel_ID;
		hotelDao = ClientRunner.remoteHelper.getHotelDao();
		try {
			hotelList = hotelDao.getHotelList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean modifyHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		hotelDao = new HotelDaoImpl_stub();
		try {
			hotelDao.modifyHotel(new HotelPO()	);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}