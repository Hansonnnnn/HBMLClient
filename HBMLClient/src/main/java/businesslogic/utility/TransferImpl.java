package businesslogic.utility;

import businesslogicservice.TransferService;
import po.HotelPO;
import po.PromotionPO;
import po.RoomInfoPO;
import po.UserPO;
import vo.HotelVO;
import vo.PromotionVO;
import vo.RoomInfoVO;
import vo.UserVO;

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

	@Override
	public UserVO poToVo(UserPO po) {
		return new UserVO(po.getId());
	}

	@Override
	public UserPO voToPo(UserVO vo) {
		return new UserPO(vo.getId());
	}

	@Override
	public PromotionVO poToVo(PromotionPO po) {
		return new PromotionVO(po.getId());
	}

	@Override
	public PromotionPO voToPo(PromotionVO vo) {
		return new PromotionPO(vo.getId());
	}


}