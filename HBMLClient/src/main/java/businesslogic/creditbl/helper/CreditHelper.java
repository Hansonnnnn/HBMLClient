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



    public Map<Integer, CreditRecordVO> getCreditRecordList(int userID){

        Map<Integer, CreditRecordPO> map= null;
        try {
            map = creditDao.getCreditRecordList(userID);
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("cannot get credit record!!!");
            return null;
        }
        creditRecordList=new LinkedHashMap<>();
        for(int key:map.keySet()){
            creditRecordList.put(key,creditTransferService.poToVo(map.get(key)));
        }
        return creditRecordList;

    }


    public long getCreditValue(int userID){
        UserPO userPO= null;
        try {
            userPO = userDao.getUserData(userID);
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("cannot get user data!!!");
            return -50001;
        }
        if(userPO!=null&&userPO.getUserType().equals(UserType.Customer)){
            try {
                return creditDao.getCreditValue(userID);
            } catch (RemoteException e) {
                e.printStackTrace();
                System.out.println("cannot get credit value!!!");
                return -50001;
            }
        }else return -50001;

    }


    public ResultMessage resumeCreditValue(int userID, long price, int type,int OrderID){

        CreditRecordReasonTypeHelper creditRecordReasonTypeHelper=new CreditRecordReasonTypeHelper();
        if(type==0){
            price=price/2;
        }
        CreditRecordVO creditRecordVO=new CreditRecordVO(new Date(),creditRecordReasonTypeHelper.getCreditRecordReasonType(2),price,OrderID);
        long creditValue= 0;
        try {
            creditValue = creditDao.getCreditValue(userID);
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("cannot get credit value!!!");
            return ResultMessage.sqlFailure;
        }
        creditValue+=price;
        try {
            creditDao.setCreditValue(userID,creditValue);
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("cannot set credit value!!!");
            return ResultMessage.sqlFailure;
        }
        try {
            return creditDao.addCreditRecord(creditTransferService.voToPo(creditRecordVO));
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("cannot add credit value!!!");
            return ResultMessage.sqlFailure;
        }

    }


    public ResultMessage addCreditValue(int UserID,long value){

        CreditRecordReasonTypeHelper creditRecordReasonTypeHelper=new CreditRecordReasonTypeHelper();
        CreditRecordVO creditRecordVO=new CreditRecordVO(UserID,new Date(),creditRecordReasonTypeHelper.getCreditRecordReasonType(3),value);
        long creditValue= 0;
        try {
            creditValue = creditDao.getCreditValue(UserID);
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("cannot get credit value!!!");
            return ResultMessage.sqlFailure;
        }
        creditValue+=value;
        try {
            creditDao.setCreditValue(UserID,creditValue);
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("cannot set credit value!!!");
            return ResultMessage.sqlFailure;
        }
        try {
            return creditDao.addCreditRecord(creditTransferService.voToPo(creditRecordVO));
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("cannot add credit value!!!");
            return ResultMessage.sqlFailure;
        }

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
