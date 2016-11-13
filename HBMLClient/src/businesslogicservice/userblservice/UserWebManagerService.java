package businesslogicservice.userblservice;

import message.ResultMessage;
import vo.UserVO;

import java.util.ArrayList;

/**
 * Created by alex on 16-11-9.
 */
public interface UserWebManagerService {
    public ResultMessage addUser(UserVO vo);
    public ResultMessage deleteUser(UserVO vo);
    public UserVO findUser(String id);
    public ResultMessage modifyUserInfo(UserVO vo);
    public UserVO showUserInfo();
    public ArrayList<UserVO> showUserInfoList();
    public ResultMessage login(String id,String pwd);
    public ResultMessage logout();
}
