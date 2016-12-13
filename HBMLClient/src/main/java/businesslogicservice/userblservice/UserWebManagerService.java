package businesslogicservice.userblservice;

import message.ResultMessage;
import vo.UserVO;


/**
 * Created by alex on 16-11-9.
 */
public interface UserWebManagerService {
    public UserVO getUser(int userID);

    public ResultMessage addUser(UserVO vo);

    public ResultMessage deleteUser(UserVO vo);

    public ResultMessage modifyUser(UserVO vo);

    public ResultMessage login(String accountName,String pwd);

    public ResultMessage logout();

    public ResultMessage signup(UserVO vo);
}
