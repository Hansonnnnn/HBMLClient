package businesslogic.hotelInfobl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import businesslogicservice.hotelinfoblservice.HotelStaffService;
import dao.hotel.HotelDao;
import po.HotelPO;
import rmi.ClientRunner;
import vo.HotelVO;

public class HotelManagerImpl implements HotelStaffService{

	
	private int hotel_ID;
	
	private Map<String, HotelVO> hotelList;
	
	private HotelDao hotelDao;
	
	public HotelManagerImpl(int hotel_ID) throws RemoteException {
		this.hotel_ID = hotel_ID;
		hotelDao = ClientRunner.remoteHelper.getHotelDao();
		hotelList = new HashMap<>();
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