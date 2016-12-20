package businesslogic.utility;

import businesslogicservice.TransferService;
import dao.HotelDao;
import po.*;
import rmi.ClientRunner;
import vo.*;

import java.io.File;
import java.rmi.RemoteException;

public class TransferImpl implements TransferService{
	@Override
	public HotelVO poToVo(HotelPO po) {
		HotelVO hotelVO = new HotelVO(po.getName(), po.getId(), po.getStar(), po.getAddress(), po.getRegion(), po.getIntroduction(), po.getFacility(), po.getEnvironment(), po.getScore(), po.getLowestPrice(),po.getAccountName());
		return hotelVO;
	}

	@Override
	public HotelPO voToPO(HotelVO vo) {

		HotelPO hotelPO = new HotelPO(vo.getName(), vo.getId(), vo.getStar(), vo.getAddress(), vo.getRegion(), vo.getIntroduction(), vo.getFacility(),vo.getEnvironment() , vo.getScore(), vo.getLowestPrice(),vo.getAccountName());
		return hotelPO;
	}

	@Override
	public RoomInfoVO poToVo(RoomInfoPO po) {
		RoomInfoVO roomInfoVO = new RoomInfoVO(po.getRoomInfoID(), po.getHotelID(), po.getRoomID(), po.getRoomType(), po.getDefaultPrice(), po.getRoomState(), po.getDetailedInfo1(), po.getDetailedInfo2());
		return roomInfoVO;
	}

	@Override
	public RoomInfoPO voToPO(RoomInfoVO vo) {
		RoomInfoPO roomInfoPO = new RoomInfoPO(vo.getRoomInfoID(), vo.getHotelID(), vo.getRoomID(), vo.getRoomType(), vo.getDefaultPrice(), vo.getRoomState(), vo.getDetailedInfo1(), vo.getDetailedInfo2());
		return roomInfoPO;
	}

	@Override
	public UserVO poToVo(UserPO po) throws Exception{
		UserVO userVO=new UserVO(po.getUserID(),po.getUserType(),po.getAccountName(),po.getPassword(),po.getName(),po.getContact(), po.getPortrait(),po.getCreditValue(),po.getMemberType(),po.getMemberInfo(),po.getRank(),po.getWorkid(),po.getHotelid());
		return userVO;
	}

	@Override
	public UserPO voToPo(UserVO vo) throws Exception{

		UserPO userPO=new UserPO(vo.getUserID(),vo.getUserType(),vo.getAccountName(),vo.getPassword(),vo.getName(),vo.getContact(),vo.getPortrait(),vo.getCreditValue(),vo.getMemberType(),vo.getMemberInfo(),vo.getRank(),vo.getWorkid(),vo.getHotelid());
		return userPO;
	}

	@Override
	public PromotionVO poToVo(PromotionPO po) {
		PromotionVO promotionVO=new PromotionVO(po.getPromotionID(),po.getPromotionType(),po.getRegion(),po.getName(),po.getContent(),po.getStartDate(),po.getEndDate(),po.getMinRankAvailable(),po.getMaxRankAvailable(),po.getType(),po.getDiscount(),po.getDiscount());
		return promotionVO;
	}

	@Override
	public PromotionPO voToPo(PromotionVO vo) {
		PromotionPO promotionPO=new PromotionPO(vo.getPromotionID(),vo.getPromotionType(),vo.getRegion(),vo.getName(),vo.getContent(),vo.getStartDate(),vo.getEndDate(),vo.getMinRankAvailable(),vo.getMaxRankAvailable(),vo.getType(),vo.getDiscount(),vo.getDiscount());
		return promotionPO;
	}

	@Override
	public CommentInfoVO poToVo(CommentInfoPO commentInfoPO) {
		CommentInfoVO commentInfoVO = new CommentInfoVO(commentInfoPO.getCommentID(), commentInfoPO.getTime(), commentInfoPO.getHotelID(), commentInfoPO.getScore(), commentInfoPO.getComment(),null,null,null,commentInfoPO.getOrderID());
		if (commentInfoPO.getPicture1()!=null) {
			commentInfoVO.setPicture1(commentInfoPO.getPicture1());
		}
		if (commentInfoPO.getPicture2()!=null) {
			commentInfoVO.setPicture2(commentInfoPO.getPicture2());
		}
		if (commentInfoPO.getPicture3()!=null) {
			commentInfoVO.setPicture3(commentInfoPO.getPicture3());
		}
		return commentInfoVO;
	}

	@Override
	public CommentInfoPO voToPo(CommentInfoVO commentInfoVO) {
		File file1 =commentInfoVO.getPicture1();
		File file2 =commentInfoVO.getPicture2();
		File file3 =commentInfoVO.getPicture3();

		CommentInfoPO commentInfoPO = new CommentInfoPO(commentInfoVO.getCommentID(), commentInfoVO.getTime(), commentInfoVO.getHotelID(), commentInfoVO.getScore(), commentInfoVO.getComment(), file1, file2, file3,commentInfoVO.getOrderID());
		return commentInfoPO;
	}

	@Override
	public RegionVO poToVo(RegionPO regionPO) {
		
		RegionVO regionVO = new RegionVO(regionPO.getRegionID(), regionPO.getProvince(), regionPO.getCity(), regionPO.getRegionName());
		return regionVO;
	}

	@Override
	public CreditRecordVO poToVo(CreditRecordPO po) {
		CreditRecordVO creditRecordVO=new CreditRecordVO(po.getCreditRecordID(),po.getTime(),po.getUserID(),po.getReasonType(),po.getAmount(),po.getOrderID());
		return creditRecordVO;
	}

	@Override
	public CreditRecordPO voToPo(CreditRecordVO vo) {
		CreditRecordPO creditRecordPO=new CreditRecordPO(vo.getCreditRecordID(),vo.getTime(),vo.getUserID(),vo.getReasonType(),vo.getAmount(),vo.getOrderID());
		return creditRecordPO;
	}

	@Override
	public OrderVO poToVo(OrderPO orderPO) {
		
		OrderVO orderVO = new OrderVO(orderPO.getOrderID(), orderPO.getUserID(), orderPO.getHotelID(), null, orderPO.getRoomInfoID(), orderPO.getOrderState(), orderPO.getGenerateTime(), orderPO.getCancelTime(), orderPO.getExecuteDDl(), orderPO.getCheckinTime(), orderPO.getCheckoutTime(), orderPO.getNumber(), orderPO.getHasChild(), orderPO.getPrice());	 
		HotelDao hoteldao= ClientRunner.remoteHelper.getHotelDao();
		try {
			HotelPO hotelPO = hoteldao.getHotelInfo(orderPO.getHotelID());
			orderVO.setHotelName(hotelPO.getName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderVO;
	}

	@Override
	public AppealVO poToVo(AppealPO appealPO) {
		
		AppealVO appealVO = new AppealVO(appealPO.getAppealID(), appealPO.getOrderID(), appealPO.getUserID(), appealPO.getWebMarketerID(), appealPO.getAppealTime(), appealPO.getContent(), appealPO.getAppealState(),appealPO.getPrice());
		 
		return appealVO;
	}

	@Override
	public OrderPO voToPo(OrderVO orderVO) {
		
		OrderPO orderPO = new OrderPO(orderVO.getOrderID(), orderVO.getUserID(), orderVO.getHotelID(), orderVO.getRoomInfoID(), orderVO.getOrderState(), orderVO.getGenerateTime(), orderVO.getCancelTime(), orderVO.getExecuteDDl(), orderVO.getCheckinTime(), orderVO.getCheckoutTime(), orderVO.getNumber(), orderVO.getHasChild(), orderVO.getPrice());
		 
		return orderPO;
	}

	@Override
	public AppealPO voToPo(AppealVO appealVO) {
		
		AppealPO appealPO = new AppealPO(appealVO.getAppealID(), appealVO.getOrderID(), appealVO.getUserID(), appealVO.getWebMarketerID(), appealVO.getAppealTime(), appealVO.getContent(), appealVO.getAppealState(),appealVO.getPrice());
		 
		 
		return appealPO;
	}
	public RankPO voToPo(RankVO rankVO){
		RankPO rankPO = new RankPO(rankVO.getRank(), rankVO.getDiscount(), rankVO.getValue());
		return rankPO;
	}
	
	public RankVO poToVo(RankPO rankPO){
		RankVO rankVO = new RankVO(rankPO.getRank(), rankPO.getDiscount(), rankPO.getValue());
		return rankVO;
	}

}