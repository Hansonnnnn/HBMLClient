package presentation.view.userinfoui;

import message.ResultMessage;
import vo.UserVO;

import java.util.ArrayList;

/**
 * Created by alex on 16-11-10.
 */
public interface UserInfoViewControllerService {
    public ResultMessage addUserInfo(UserVO vo);
    public ResultMessage deleteUserInfo(String id);
    public ResultMessage modifyUserInfo(UserVO vo);
    public UserVO findUserInfo(String id);
    public UserVO showUserInfo();
    public ArrayList<UserVO> showUserInfoList();
    public ResultMessage login(String id, String pwd);
    public ResultMessage logout();
    public ResultMessage signup(UserVO vo);

}
