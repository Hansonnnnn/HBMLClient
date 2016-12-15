package businesslogicservice.userblservice;

import message.ResultMessage;
import vo.UserVO;


/**
 * Created by alex on 16-11-9.
 */
public interface UserStaffService {

    public UserVO getUserData(int userID);

    public UserVO getUserData(String accountName);

    public ResultMessage login(String accountName, String pwd);


    public ResultMessage signup(UserVO vo);
}
