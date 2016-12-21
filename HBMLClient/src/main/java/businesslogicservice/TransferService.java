package businesslogicservice;

import po.*;
import vo.*;

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

	public CreditRecordVO poToVo(CreditRecordPO po);

	public CreditRecordPO voToPo(CreditRecordVO vo);
	
	public OrderVO poToVo(OrderPO orderPO);
	
	public AppealVO poToVo(AppealPO appealPO);
	
	public OrderPO voToPo(OrderVO orderVO);
	
	public AppealPO voToPo(AppealVO appealVO);
	
	public RankVO poToVo(RankPO rankPO);
	
	public RankPO voToPo(RankVO rankVO);
}