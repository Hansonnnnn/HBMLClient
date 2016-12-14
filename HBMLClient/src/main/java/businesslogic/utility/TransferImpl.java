package businesslogic.utility;

import businesslogicservice.TransferService;
import po.*;
import vo.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

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
		UserVO userVO=new UserVO(po.getUserID(),po.getUserType(),po.getAccountName(),po.getPassword(),po.getName(),po.getContact(), ImageIO.read(po.getPortrait()),po.getCreditValue(),po.getMemberType(),po.getMemberInfo(),po.getRank(),po.getWorkid(),po.getHotelid());
		return userVO;
	}

	@Override
	public UserPO voToPo(UserVO vo) throws Exception{
		File file=null;
		BufferedImage bufImg = new BufferedImage(vo.getPortrait().getWidth(null), vo.getPortrait().getHeight(null),BufferedImage.TYPE_INT_RGB);
		Graphics g = bufImg .createGraphics();
		g.drawImage(vo.getPortrait(), 0, 0, null);
		g.dispose();
		ImageIO.write(bufImg,"jpg",file);
		UserPO userPO=new UserPO(vo.getUserID(),vo.getUserType(),vo.getAccountName(),vo.getPassword(),vo.getName(),vo.getContact(),file,vo.getCreditValue(),vo.getMemberType(),vo.getMemberInfo(),vo.getRank(),vo.getWorkid(),vo.getHotelid());
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


}