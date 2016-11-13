package businesslogic.hotelInfobl.hotelhelper;

import java.awt.Image;
import java.rmi.RemoteException;
import java.util.List;

import businesslogic.hotelInfobl.HotelDaoImpl_stub;
import businesslogic.hotelInfobl.HotelTransferImpl;
import businesslogicservice.hotelinfoblservice.HotelTransferService;
import dao.hotel.HotelDao;
import message.ResultMessage;
import po.CommentInfoPO;
import po.HotelPO;
import po.OrderPO;
import po.RoomInfoPO;
import po.StaffAccountPO;
import vo.HotelVO;

public class Hotel {
	HotelDao hotelDao = new HotelDaoImpl_stub();
	HotelTransferService hotelTransferService = new HotelTransferImpl();
	String name;
	String id;
	int star;
	String address;
	String region;
	String introduction;
	String facility;
	Image environment;
	CommentInfoPO commentInfo;
	RoomInfoPO roomInfo;
	List<OrderPO> historyOrder;
	StaffAccountPO staffAccount;
	
	public HotelVO getPoFromData() {
		HotelPO hotelPO = null;
		try {
			hotelPO = hotelDao.getHotelInfo("0001");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return hotelTransferService.poToVo(hotelPO);
	}

	public ResultMessage addHotel() {
		
		return ResultMessage.success;
	}
	
	public ResultMessage deleteHotel() {
		
		return ResultMessage.success;
	}

	public ResultMessage modifyHotel() {
	
		return ResultMessage.success;
	}
}
