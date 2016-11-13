package businesslogic.utility;

import businesslogicservice.TransferService;
import po.HotelPO;
import po.RoomInfoPO;
import vo.HotelVO;
import vo.RoomInfoVO;

public class TransferImpl implements TransferService{
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

	@Override
	public RoomInfoVO poToVo(RoomInfoPO po) {
		
		return null;
	}

	@Override
	public RoomInfoPO voToPO(RoomInfoVO vo) {
		
		return null;
	}




}