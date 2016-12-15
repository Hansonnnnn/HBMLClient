package businesslogic.userbl;

import businesslogic.userbl.helper.UserHelper;
import businesslogicservice.userblservice.UserCustomerService;
import message.ResultMessage;
import vo.UserVO;

/**
 * Created by alex on 12/13/16.
 */
public class UserCustomerImpl implements UserCustomerService{

    UserHelper userHelper;

    public UserCustomerImpl() {
        userHelper=new UserHelper();
    }


    @Override
    public UserVO getUserData(int userID) throws Exception{
        return userHelper.getUserData(userID);
    }

    @Override
    public UserVO getUserData(String accountName) throws Exception{
        return userHelper.getUserData(accountName);
    }

    @Override
    public ResultMessage modifyUser(UserVO vo) throws Exception{
        return userHelper.modifyUser(vo);
    }

    @Override
    public ResultMessage login(String accountName, String pwd) throws Exception{
        return userHelper.login(accountName,pwd);
    }

    @Override
    public ResultMessage signup(UserVO vo) throws Exception{
        return userHelper.signup(vo);
    }
}
