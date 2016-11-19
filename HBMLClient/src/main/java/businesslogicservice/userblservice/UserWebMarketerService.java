package businesslogicservice.userblservice;

import message.ResultMessage;

/**
 * Created by alex on 16-11-9.
 */
public interface UserWebMarketerService {
    public ResultMessage login(String id,String pwd);
    public ResultMessage logout();

}
