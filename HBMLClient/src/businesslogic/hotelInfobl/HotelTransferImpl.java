package businesslogic.hotelInfobl;

import businesslogicservice.hotelinfoblservice.HotelTransferService;
import po.HotelPO;
import vo.HotelVO;

public class HotelTransferImpl implements HotelTransferService{
	HotelPO newPo = null;
	HotelVO newVo = null;
	@Override
	public HotelVO poToVo(HotelPO po) {
		
		return newVo;
	}

	@Override
	public HotelPO voToPO(HotelVO vo) {
		
		return newPo;
	}


}