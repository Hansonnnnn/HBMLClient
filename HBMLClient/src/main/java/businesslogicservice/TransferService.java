package businesslogicservice;

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
	
	public CommentInfoVO poToVo(CommentInfoPO commentInfoPO);

	public CommentInfoPO voToPo(CommentInfoVO commentInfoVO);

	public RegionVO poToVo(RegionPO regionPO);
}