package businesslogicservice.creditblservice;

import java.util.Map;

import message.ResultMessage;
import po.RankPO;
import vo.RankVO;

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
    public ResultMessage resumeCreditValue(int userID,long price,int type)throws Exception;

    public ResultMessage addCreditValue(int UserID,long value)throws Exception;
    
    
    
    
    /**
     * @TODO：得到当前的等级制度  RankVO里三个参数  rank表示等级，discount表示折扣。value表示达到该等级所需信用值
     * @return  Map的key  （integer）为 RankVO.rank
     */
    public Map<Integer, RankVO> getRankList() ;
	
    
    
	/**
	 * @TODO： 修改等级规则
	 * @param newRule  这个Map就是这个Map  里面的对象就这么多不能变   改哪个等级 用newRule.get(key) 方法得到
	 * 			RankVO修改 
	 * @return
	 */
	public ResultMessage modifyRankRule(Map<Integer, RankVO> newRule) ;

}
