package businesslogicservice.hotelinfoblservice;

import po.HotelPO;
import vo.HotelVO;

public interface HotelTransferService {
	//po变成vo
	public HotelVO poToVo(HotelPO po);
	//vo变成po
	public HotelPO voToPO(HotelVO vo);
}