package businesslogicservice.userblservice;

import message.ResultMessage;
import vo.UserVO;

/**
 * Created by alex on 16-11-9.
 */
public interface UserCustomerService {
    /**
     * 如果未找到该用户，返回VO为ｎｕｌｌ
     * @param userID
     * @return
     */
    public UserVO getUserData(int userID)throws Exception;

    public UserVO getUserData(String accountName)throws Exception;

    /**
     *
     * @param vo
     * @return  成功返回ResultMessage.success,如果vo信息矛盾返回ResultMessage.failure
     * @throws Exception
     */
    public ResultMessage modifyUser(UserVO vo)throws Exception;
}
