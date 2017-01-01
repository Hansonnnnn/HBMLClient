package businesslogicservice.creditblservice;


import vo.CreditRecordVO;

import java.util.Map;

public interface CreditCustomerService {
	/**
	 *	获得信用值
	 *	如果返回一个小于-50000的数，说明该UserID不合法，比如不存在该用户，或者该用户非Customer类型
	 * @param userID
	 * @return 返回信用值为long值
	 */
	public long getCreditValue(int userID);


	/**
	 * 获得某个用户的信用记录列表
	 * 如果UserID不合法，比如不存在该用户，或者该用户非Customer类型，返回null值
	 * @param userID
	 * @return
	 */
	public Map<Integer, CreditRecordVO> getCreditRecordList(int userID);

}
