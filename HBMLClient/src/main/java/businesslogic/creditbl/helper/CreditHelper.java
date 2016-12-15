package businesslogic.creditbl.helper;

import businesslogic.creditbl.Credit;
import businesslogic.utility.TransferImpl;
import businesslogicservice.TransferService;
import dao.CreditDao;

import dao.UserDao;
import message.ResultMessage;
import model.CreditRecordReasonTypeHelper;
import model.UserType;
import po.CreditRecordPO;
import po.UserPO;
import rmi.ClientRunner;
import vo.CreditRecordVO;

import java.util.Date;
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


    public ResultMessage resumeCreditValue(int userID, long price, int type)throws Exception{
        CreditRecordReasonTypeHelper creditRecordReasonTypeHelper=new CreditRecordReasonTypeHelper();
        if(type==0){
            price=price/2;
        }
        CreditRecordVO creditRecordVO=new CreditRecordVO(new Date(),creditRecordReasonTypeHelper.getCreditRecordReasonType(2),price);
        return creditDao.addCreditRecord(creditTransferService.voToPo(creditRecordVO));
    }


    public ResultMessage addCreditValue(int UserID,long value)throws Exception{
        CreditRecordReasonTypeHelper creditRecordReasonTypeHelper=new CreditRecordReasonTypeHelper();
        CreditRecordVO creditRecordVO=new CreditRecordVO(new Date(),creditRecordReasonTypeHelper.getCreditRecordReasonType(3),value);
        return creditDao.addCreditRecord(creditTransferService.voToPo(creditRecordVO));
    }
}
