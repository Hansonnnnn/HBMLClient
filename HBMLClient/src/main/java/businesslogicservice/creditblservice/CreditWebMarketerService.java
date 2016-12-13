package businesslogicservice.creditblservice;

import message.ResultMessage;

/**
 * Created by alex on 12/13/16.
 */
public interface CreditWebMarketerService {

    public ResultMessage resumeCreditValue(int userID,long value);

    public ResultMessage addCreditValue(int UserID,long value);
}
