package businesslogicservice.userblservice;

import message.ResultMessage;
import vo.UserVO;


/**
 * Created by alex on 16-11-9.
 */
public interface UserWebManagerService {
    //getPortrait获得Image对象
    public UserVO getUserData(int userID);

    public UserVO getUserData(String accountName);

    /**
     *
     * @param vo
     * @return
     * @throws Exception
     */
    public ResultMessage addUser(UserVO vo);

    public ResultMessage deleteUser(int userID);

    public ResultMessage modifyUser(UserVO vo);
}
