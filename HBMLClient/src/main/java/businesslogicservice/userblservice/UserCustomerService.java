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
    public UserVO getUserData(int userID);

    public UserVO getUserData(String accountName);

    public ResultMessage modifyUser(UserVO vo);

    /**
     *
     * @param accountName
     * @param pwd
     * @return成功，失败(密码错误)，不存在
     */
    public ResultMessage login(String accountName,String pwd);

    /**
     *
     * @param vo
     * @return如果返回failure,提示用户名已存在；如果是success,可以调用登陆方法
     */
    public ResultMessage signup(UserVO vo);
}
