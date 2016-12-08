package businesslogic.hotelInfobl.helper;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import businesslogic.utility.TransferImpl;
import businesslogicservice.TransferService;
import dao.hotel.HotelDao;
import message.ResultMessage;
import model.HotelFilter;
import po.HotelPO;
import rmi.ClientRunner;
import vo.CommentInfoVO;
import vo.HotelVO;
import vo.RegionVO;

public class HotelHelper {

	Map<Integer, HotelVO> hotelList;
	HotelDao hotelDao ;
	TransferService hotelTransferService ;
	public HotelHelper() {
		hotelDao = ClientRunner.remoteHelper.getHotelDao();
		hotelTransferService = new TransferImpl();
	}
	
	
	public Map<Integer, HotelVO> getHotelList(HotelFilter filter,String order,Date date) {
		try {
			hotelList = new LinkedHashMap<>();
			Map<Integer, HotelPO> map = hotelDao.getHotelList(filter, order, date);
			for (int key : map.keySet()) {
				
				hotelList.put(key, hotelTransferService.poToVo(map.get(key)));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hotelList;
	}	
	
	public HotelVO getHotelInfo(int hotelID) {
		
		return hotelList.get(hotelID);
	}
	
	public ResultMessage addHotel(HotelVO vo) {
		try {
			return hotelDao.addHotel(hotelTransferService.voToPO(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.disconnection;
		}
	}
	
	public ResultMessage modifyHotel(HotelVO vo) {
		try {
			return hotelDao.modifyHotel(hotelTransferService.voToPO(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.disconnection;
		}
	}
	
	public ResultMessage deleteHotel(int hotel_ID) {
		try {
			return hotelDao.deleteHotel(hotel_ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.disconnection;
		}
	}
	


}
