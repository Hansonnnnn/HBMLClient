package businesslogicservice.userblservice;

import message.ResultMessage;
import vo.StaffVO;
import vo.WebMarketerVO;

import java.util.ArrayList;

/**
 * Created by alex on 16-11-9.
 */
public interface UserWebManagerService {
    public ResultMessage addUser(Object vo);
    public ResultMessage deleteUser(Object vo);
    public Object findUser(String id);
    public ResultMessage modifyUserInfo(Object vo);
    public Object showUserInfo();
    public ArrayList<Object> showUserInfoList();
    public ResultMessage login(String id,String pwd);
    public ResultMessage logout();
}
