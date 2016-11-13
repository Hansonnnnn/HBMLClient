package businesslogicservice.userblservice;

import message.ResultMessage;

/**
 * Created by alex on 16-11-9.
 */
public interface UserCustomerService {
    public ResultMessage modifyUserInfo(CustomerVO vo);
    public CustomerVO showUserInfo();
    public ResultMessage login(String id,String pwd);
    public ResultMessage logout();
    public ResultMessage signup(CustomerVO vo);
}
