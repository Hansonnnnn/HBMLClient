package businesslogic.utility;

import businesslogicservice.TransferService;
import po.CommentInfoPO;
import po.HotelPO;
import po.PromotionPO;
import po.RegionPO;
import po.RoomInfoPO;
import po.UserPO;
import vo.CommentInfoVO;
import vo.HotelVO;
import vo.PromotionVO;
import vo.RegionVO;
import vo.RoomInfoVO;
import vo.UserVO;

public class TransferImpl implements TransferService{
	@Override
	public HotelVO poToVo(HotelPO po) {
		
		HotelVO hotelVO = new HotelVO(po.getName(), po.getId(), po.getStar(), po.getAddress(), po.getRegion(), po.getIntroduction(), po.getFacility(), po.getEnvironment(), po.getScore(), po.getLowestPrice());
		return hotelVO;
	}

	@Override
	public HotelPO voToPO(HotelVO vo) {
		HotelPO hotelPO = new HotelPO(vo.getName(), vo.getId(), vo.getStar(), vo.getAddress(), vo.getRegion(), vo.getIntroduction(), vo.getFacility(), vo.getEnvironment(), vo.getScore(), vo.getLowestPrice());
		return hotelPO;
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
		return new UserVO("");
	}

	@Override
	public UserPO voToPo(UserVO vo) {
		return new UserPO(0);
	}

	@Override
	public PromotionVO poToVo(PromotionPO po) {
		return new PromotionVO(po.getId());
	}

	@Override
	public PromotionPO voToPo(PromotionVO vo) {
		return new PromotionPO(vo.getId());
	}

	@Override
	public CommentInfoVO poToVo(CommentInfoPO commentInfoPO) {
		
		
		return null;
	}

	@Override
	public CommentInfoPO voToPo(CommentInfoVO commentInfoVO) {
		
		
		return null;
	}

	@Override
	public RegionVO poToVo(RegionPO regionPO) {
		
		
		return null;
	}


}