package businesslogicservice.creditblservice;


import vo.CreditRecordVO;

import java.util.Map;

public interface CreditCustomerService {
	/**
	 *	如果返回一个小于-50000的数，说明该UserID不合法，比如不存在该用户，或者该用户非Customer类型
	 * @param userID
	 * @return
	 */
	public long getCreditValue(int userID)throws Exception;

	public Map<Integer, CreditRecordVO> getCreditRecordList(int userID)throws Exception;

}
