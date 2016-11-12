package businesslogic.hotelInfobl.hotelhelper;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import businesslogic.hotelInfobl.HotelDaoImpl_stub;
import businesslogic.hotelInfobl.HotelTransferImpl;
import businesslogicservice.hotelinfoblservice.HotelTransferService;
import dao.hotel.HotelDao;
import message.ResultMessage;
import po.HotelPO;
import vo.HotelVO;

public class HotelList {
	Hotel hotel ;
	Map<String, HotelVO> hotelList;
	HotelDao hotelDao = new HotelDaoImpl_stub();
	HotelTransferService hotelTransferService = new HotelTransferImpl();
	public HotelList() {
		hotel = new Hotel();
		hotelList = new HashMap<String, HotelVO>();
	}
	
	public Map<String, HotelVO> getHotelList() {
		try {
			Map<String , HotelPO> hotelPoList = hotelDao.getHotelList();
			for (String string:hotelPoList.keySet()) {
				if (string != null) {
					hotelList.put(string,hotelTransferService.poToVo(hotelPoList.get(string)));
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotelList;
	}
	  
	public ResultMessage addHotel() {
		
		
		return hotel.addHotel();
	}
	
	public ResultMessage deleteHotel() {
		
		return hotel.deleteHotel();
	}
	
	public ResultMessage modifyHotel() {
		
		return hotel.modifyHotel();
	}
}
