package businesslogic.creditbl.helper;

import businesslogic.utility.TransferImpl;
import businesslogicservice.TransferService;
import dao.CreditDao;

import dao.UserDao;
import message.ResultMessage;
import model.CreditRecordReasonTypeHelper;
import model.UserType;
import po.CreditRecordPO;
import po.RankPO;
import po.UserPO;
import rmi.ClientRunner;
import vo.CreditRecordVO;
import vo.RankVO;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by alex on 12/15/16.
 */
public class CreditHelper {
    Map<Integer, CreditRecordVO> creditRecordList;
    CreditDao creditDao;
    UserDao userDao;
    TransferService creditTransferService;

    public CreditHelper() {

        userDao= ClientRunner.remoteHelper.getUserDao();
        creditDao= ClientRunner.remoteHelper.getCreditDao();
        creditTransferService=new TransferImpl();

    }



    public Map<Integer, CreditRecordVO> getCreditRecordList(int userID) throws Exception{

        Map<Integer, CreditRecordPO> map=creditDao.getCreditRecordList(userID);
        creditRecordList=new LinkedHashMap<>();
        for(int key:map.keySet()){
            creditRecordList.put(key,creditTransferService.poToVo(map.get(key)));
        }
        return creditRecordList;

    }


    public long getCreditValue(int userID)throws Exception{

        UserPO userPO=userDao.getUserData(userID);
        if(userPO!=null&&userPO.getUserType().equals(UserType.Customer)){
            return creditDao.getCreditValue(userID);
        }else return -50001;

    }


    public ResultMessage resumeCreditValue(int userID, long price, int type,int OrderID)throws Exception{

        CreditRecordReasonTypeHelper creditRecordReasonTypeHelper=new CreditRecordReasonTypeHelper();
        if(type==0){
            price=price/2;
        }
        CreditRecordVO creditRecordVO=new CreditRecordVO(new Date(),creditRecordReasonTypeHelper.getCreditRecordReasonType(2),price,OrderID);
        long creditValue=creditDao.getCreditValue(userID);
        creditValue+=price;
        creditDao.setCreditValue(userID,creditValue);
        return creditDao.addCreditRecord(creditTransferService.voToPo(creditRecordVO));

    }


    public ResultMessage addCreditValue(int UserID,long value)throws Exception{

        CreditRecordReasonTypeHelper creditRecordReasonTypeHelper=new CreditRecordReasonTypeHelper();
        CreditRecordVO creditRecordVO=new CreditRecordVO(UserID,new Date(),creditRecordReasonTypeHelper.getCreditRecordReasonType(3),value);
        long creditValue=creditDao.getCreditValue(UserID);
        creditValue+=value;
        creditDao.setCreditValue(UserID,creditValue);
        return creditDao.addCreditRecord(creditTransferService.voToPo(creditRecordVO));

    }



	public Map<Integer, RankVO> getRankList() {
		Map<Integer, RankVO> List = new LinkedHashMap<>();
		try {
			Map<Integer, RankPO> map = creditDao.getRankList();
			RankVO rankVO;
			for (RankPO rankPO : map.values()) {
				rankVO = creditTransferService.poToVo(rankPO);
				List.put(rankVO.getRank(), rankVO);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 
		return List;
	}



	public ResultMessage modifyRankRule(Map<Integer, RankVO> newRule) {
		Map<Integer, RankPO> map = new LinkedHashMap<>();;
	
		for (RankVO rankVO : newRule.values()) {
			map.put(rankVO.getRank(), creditTransferService.voToPo(rankVO));
		}
	
		try {
			return creditDao.modifyRankRule(map);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.failure;
		}
	}
}
