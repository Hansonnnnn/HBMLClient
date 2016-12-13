package businesslogic.userbl;

import businesslogicservice.userblservice.UserWebManagerService;
import businesslogicservice.userblservice.UserWebMarketerService;
import message.ResultMessage;
import vo.UserVO;

/**
 * Created by alex on 12/13/16.
 */
public class UserWebManagerImpl implements UserWebManagerService{
    @Override
    public UserVO getUser(int userID) {
        return null;
    }

    @Override
    public ResultMessage addUser(UserVO vo) {
        return null;
    }

    @Override
    public ResultMessage deleteUser(int userID) {
        return null;
    }

    @Override
    public ResultMessage modifyUser(UserVO vo) {
        return null;
    }

    @Override
    public ResultMessage login(String accountName, String pwd) {
        return null;
    }

    @Override
    public ResultMessage logout() {
        return null;
    }

    @Override
    public ResultMessage signup(UserVO vo) {
        return null;
    }
}
