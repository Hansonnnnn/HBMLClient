package businesslogicservice.orderblservice;

import java.util.Map;

import message.ResultMessage;
import vo.AppealVO;
import vo.OrderVO;

/**
 * @author 凡
 *
 */
public interface OrderWebMarketerService {
	/**
	 * 
	 * @TODO： 得到所有未执行订单
	 * @return
	 */
	public Map<Integer, OrderVO> getUnexecutedOrderList();
	
	
	/**
	 * @param userID   如果不为0就是你要查哪个用户的申诉订单  为0查所有
	 * @return	Map的Integer是AppealID
	 */
	public Map<Integer, AppealVO> getAppealOrderList(int userID);
	
	
	/**
	 * @param appealVO  选择申诉成功还是失败的时候用的，
	 * 						修改后的VO必须包含当前操作账号的ID，和修改后的状态（Success,Failure）
	 * @return
	 */
	public ResultMessage modifyAppealOrder(AppealVO appealVO);
}
