package businesslogicservice.hotelinfoblservice;

import po.HotelPO;
import vo.HotelVO;

public interface HotelTransferService {
	//将data层拿回的po变成vo
	public HotelVO findHotel(String ID);
	//强vo变成po
	public HotelPO toPO(HotelVO vo);
}