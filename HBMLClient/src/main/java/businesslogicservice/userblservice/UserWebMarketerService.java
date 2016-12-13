package businesslogicservice.userblservice;

import message.ResultMessage;
import vo.UserVO;

/**
 * Created by alex on 16-11-9.
 */
public interface UserWebMarketerService {

    public ResultMessage login(String accountName,String pwd);

    public ResultMessage logout();

    public ResultMessage signup(UserVO vo);

}
