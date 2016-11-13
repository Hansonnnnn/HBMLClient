package businesslogicservice.userblservice;

import message.ResultMessage;
import vo.CustomerVO;

import java.util.ArrayList;

/**
 * Created by alex on 16-11-9.
 */
public interface UserStaffService {
    public CustomerVO showUserInfo();
    public ArrayList<CustomerVO> showUserInfoList();
    public ResultMessage login(String id, String pwd);
    public ResultMessage logout();
}
