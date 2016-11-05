package businesslogicservice.hotelinfoblservice;

import PO.HotelPO;
import VO.HotelVO;

public interface HotelTransferService {
	//将data层拿回的po变成vo
	public HotelVO findHotel(String ID);
	//强vo变成po
	public HotelPO toPO(HotelVO vo);
}