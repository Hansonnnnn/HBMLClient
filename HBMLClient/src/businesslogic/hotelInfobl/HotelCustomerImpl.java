package businesslogic.hotelInfobl;

import java.rmi.RemoteException;

import businesslogicservice.hotelinfoblservice.HotelCustomerService;
import dao.hotel.HotelDao;
import po.HotelPO;
import rmi.ClientRunner;
import vo.HotelVO;

public class HotelCustomerImpl implements HotelCustomerService{

	private HotelPO[] hotelList;
	
	private HotelDao hotelDao;
	
	public HotelCustomerImpl() throws RemoteException {
		hotelDao = ClientRunner.remoteHelper.getHotelDao();
		hotelList = hotelDao.getHotelList();
	}
	
	
	public HotelVO[] showHotelList(String hotel_region) {
		// TODO Auto-generated method stub
		hotelDao = new HotelDaoImpl_stub();
		try {
			hotelDao.getHotelList("0001");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
}