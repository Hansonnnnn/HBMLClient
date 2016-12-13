package businesslogic.userbl;

import businesslogicservice.userblservice.UserWebMarketerService;
import message.ResultMessage;
import vo.UserVO;

/**
 * Created by alex on 12/13/16.
 */
public class UserWebMarketerImpl implements UserWebMarketerService{
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
