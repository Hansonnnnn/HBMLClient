package businesslogicservice.userblservice;

import message.ResultMessage;
import vo.UserVO;

/**
 * Created by alex on 16-11-9.
 */
public interface UserCustomerService {
    public ResultMessage modifyUserInfo(UserVO vo);
    public UserVO showUserInfo();
    public ResultMessage login(String id,String pwd);
    public ResultMessage logout();
    public ResultMessage signup(UserVO vo);
}
