package businesslogic.hotelInfobl;

import java.rmi.RemoteException;

import PO.HotelPO;
import VO.HotelVO;
import businesslogicservice.hotelinfoblservice.HotelWebManagerService;
import dao.HotelDao;
import rmi.ClientRunner;

public class HotelWebManagerImpl implements HotelWebManagerService{
	
	private HotelPO[] hotelList;
	
	private HotelDao hotelDao;
	
	public HotelWebManagerImpl() {
		hotelDao = ClientRunner.remoteHelper.getHotelDao();
		try {
			hotelList = hotelDao.getHotelList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public HotelVO showHotelInfo(String hotel_ID) {
		// TODO Auto-generated method stub
		hotelDao = new HotelDaoImpl_stub();
		try {
			hotelDao.getHotelInfo("0001");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean addHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		hotelDao = new HotelDaoImpl_stub();
		try {
			hotelDao.addHotel(new HotelPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	public boolean modifyHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		hotelDao = new HotelDaoImpl_stub();
		try {
			hotelDao.modifyHotel(new HotelPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean deleteHotel(String hotel_ID) {
		// TODO Auto-generated method stub
		hotelDao = new HotelDaoImpl_stub();
		try {
			hotelDao.deleteHotel("0001");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public HotelVO[] showHotelList(String hotel_region) {
		hotelDao = new HotelDaoImpl_stub();
		try {
			hotelDao.getHotelList("0001");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}