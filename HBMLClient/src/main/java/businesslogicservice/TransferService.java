package businesslogicservice;

import po.HotelPO;
import po.PromotionPO;
import po.RoomInfoPO;
import po.UserPO;
import vo.HotelVO;
import vo.PromotionVO;
import vo.RoomInfoVO;
import vo.UserVO;
/*
 * PO  VO 之间的转换
 */
public interface TransferService {
	//po变成vo
	public HotelVO poToVo(HotelPO po);
	//vo变成po
	public HotelPO voToPO(HotelVO vo);
	
	public RoomInfoVO poToVo(RoomInfoPO po);
	//vo变成po
	public RoomInfoPO voToPO(RoomInfoVO vo);
	
	public UserVO poToVo(UserPO po);
	
	public UserPO voToPo(UserVO vo);
	
	public PromotionVO poToVo(PromotionPO po);
	
	public PromotionPO voToPo(PromotionVO vo);
}