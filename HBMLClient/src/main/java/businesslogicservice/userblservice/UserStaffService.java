package businesslogicservice.userblservice;

import message.ResultMessage;
import vo.UserVO;

import java.util.ArrayList;

/**
 * Created by alex on 16-11-9.
 */
public interface UserStaffService {
    public UserVO showUserInfo();
    public ArrayList<UserVO> showUserInfoList();
    public ResultMessage login(String id, String pwd);
    public ResultMessage logout();
}
