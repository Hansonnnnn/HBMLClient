package presentation.view.userinfoui;

import message.ResultMessage;
import vo.CustomerVO;

import java.util.ArrayList;

/**
 * Created by alex on 16-11-10.
 */
public interface UserInfoViewControllerService {
    public ResultMessage addUserInfo(Object vo);
    public ResultMessage deleteUserInfo(Object vo);
    public ResultMessage modifyUserInfo(Object vo);
    public Object findUserInfo(String id);
    public Object showUserInfo();
    public ArrayList<Object> showUserInfoList();
    public ResultMessage login(String id, String pwd);
    public ResultMessage logout();
    public ResultMessage signup(CustomerVO vo);

}
