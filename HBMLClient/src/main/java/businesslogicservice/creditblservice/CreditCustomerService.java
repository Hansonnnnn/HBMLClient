package businesslogicservice.creditblservice;


import vo.CreditRecordVO;

import java.util.Map;

public interface CreditCustomerService {
	/**
	 *	如果返回-1，说明该UserID不合法，比如不存在该用户，或者该用户非Customer类型
	 * @param userID
	 * @return
	 */
	public long getCreditValue(int userID);

	public Map<Integer, CreditRecordVO> getCreditRecordList(int userID);

}
