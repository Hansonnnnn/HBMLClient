package businesslogic.creditbl;

import java.util.Map;

import businesslogic.creditbl.helper.CreditHelper;
import businesslogicservice.creditblservice.CreditWebMarketerService;
import message.ResultMessage;
import vo.RankVO;

/**
 * Created by alex on 12/13/16.
 */
public class CreditWebMarketerImpl implements CreditWebMarketerService{

    CreditHelper creditHelper;

    public CreditWebMarketerImpl() {

        creditHelper=new CreditHelper();

    }


    @Override
    public ResultMessage resumeCreditValue(int userID, long price, int type,int orderID){

        return creditHelper.resumeCreditValue(userID,price,type,orderID);

    }

    @Override
    public ResultMessage addCreditValue(int UserID, long value){

    	 return creditHelper.addCreditValue(UserID,value);
    }


	@Override
	public Map<Integer, RankVO> getRankList() {
		
		return creditHelper.getRankList();
	}


	@Override
	public ResultMessage modifyRankRule(Map<Integer, RankVO> newRule) {
		
		return creditHelper.modifyRankRule(newRule);
	}
}
