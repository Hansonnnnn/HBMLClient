package businesslogic.userbl;

import businesslogic.userbl.helper.UserHelper;
import businesslogicservice.userblservice.UserLogService;
import message.ResultMessage;
import model.UserType;
import vo.UserVO;

/**
 * Created by alex on 12/20/16.
 */
public class UserLogImpl implements UserLogService{

    UserHelper userHelper;

    public UserLogImpl(){
        userHelper=new UserHelper();
    }
    @Override
    public ResultMessage login(String accountName, String pwd) throws Exception {

        return userHelper.login(accountName,pwd);

    }

    @Override
    public ResultMessage signup(UserVO vo){

        ResultMessage resultMessage=userHelper.signup(vo);
        if(resultMessage.equals(ResultMessage.success)){
            System.out.println("successfully signing up a user!");
        }
        return resultMessage;

    }

    @Override
    public ResultMessage logout(String accountName){

        return userHelper.logout(accountName);

    }

    @Override
    public UserVO getUserData(int userID){

        UserVO userVO=userHelper.getUserData(userID);

        return userVO;

    }

    @Override
    public UserVO getUserData(String accountName){

        UserVO userVO=userHelper.getUserData(accountName);
        return userVO;

    }
}
