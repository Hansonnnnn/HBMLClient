package businesslogicservice.creditblservice;

import message.ResultMessage;

/**
 * Created by alex on 12/13/16.
 */
public interface CreditWebMarketerService {
    /**
     * 恢复全部，输入type==1,恢复一半，输入type==0
     *
     * @param userID
     * @param
     * @return
     */
    public ResultMessage resumeCreditValue(int userID,long price,int type);

    public ResultMessage addCreditValue(int UserID,long value);
}
