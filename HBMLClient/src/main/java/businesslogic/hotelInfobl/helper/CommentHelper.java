package businesslogic.hotelInfobl.helper;

import java.rmi.RemoteException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import businesslogic.utility.TransferImpl;
import businesslogicservice.TransferService;
import dao.HotelDao;
import message.ResultMessage;
import po.CommentInfoPO;
import rmi.ClientRunner;
import vo.CommentInfoVO;

/**
 * @author 凡
 *
 */
public class CommentHelper {

	Map<Integer, CommentInfoVO> commentInfoList;
	HotelDao hotelDao;
	TransferService commentInfoTransferService;
	public CommentHelper() {
		hotelDao = ClientRunner.remoteHelper.getHotelDao();
		commentInfoTransferService = new TransferImpl();
	}

	
	public Map<Integer, CommentInfoVO> getComments(int hotelID) {
		try {
			commentInfoList = new LinkedHashMap<>();
			List<CommentInfoPO> commentInfoPOs = hotelDao.getComments(hotelID);
			for (CommentInfoPO commentInfoPO : commentInfoPOs) {
				commentInfoList.put(commentInfoPO.getCommentID(), commentInfoTransferService.poToVo(commentInfoPO));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commentInfoList;
	}

	public ResultMessage addComment(CommentInfoVO commentInfoVO) {
		try {
			return hotelDao.addComment(commentInfoTransferService.voToPo(commentInfoVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.disconnection;
		}
	}
}
