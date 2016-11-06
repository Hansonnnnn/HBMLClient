package businesslogic.hotelInfobl;

import java.rmi.RemoteException;

import businesslogicservice.hotelinfoblservice.HotelTransferService;
import dao.hotel.HotelDao;
import po.HotelPO;
import rmi.ClientRunner;
import vo.HotelVO;

public class HotelTransferImpl implements HotelTransferService{

	private HotelPO[] hotelList;
	
	private HotelDao hotelDao;
	
	public HotelTransferImpl() {
		hotelDao = ClientRunner.remoteHelper.getHotelDao();
		try {
			hotelList = hotelDao.getHotelList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public HotelVO findHotel(String ID) {
		hotelDao = new HotelDaoImpl_stub();
		try {
			hotelDao.getHotelInfo("0001");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public HotelPO toPO(HotelVO vo) {
		
		return new HotelPO();
	}

}