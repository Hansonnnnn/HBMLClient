package businesslogic.userbl;

import businesslogic.userbl.helper.UserHelper;
import businesslogicservice.userblservice.UserStaffService;
import message.ResultMessage;
import model.UserType;
import vo.UserVO;

/**
 * Created by alex on 12/13/16.
 */
public class UserStaffImpl implements UserStaffService{

    UserHelper userHelper;

    public UserStaffImpl() {

        userHelper=new UserHelper();

    }


    @Override
    public UserVO getUserData(int userID) throws Exception{

        UserVO userVO=userHelper.getUserData(userID);
        if(userVO!=null){
            if(userVO.getUserType().equals(UserType.Staff)) return userVO;
            else return null;
        }
        return userVO;

    }

    @Override
    public UserVO getUserData(String accountName) throws Exception{

        UserVO userVO=userHelper.getUserData(accountName);
        if(userVO!=null){
            if(userVO.getUserType().equals(UserType.Staff)) return userVO;
            else return null;
        }
        return userVO;

    }

    @Override
    public ResultMessage login(String accountName, String pwd) throws Exception{

        return userHelper.login(accountName,pwd);

    }

    @Override
    public ResultMessage signup(UserVO vo) throws Exception{

        return userHelper.signup(vo);

    }

    @Override
    public ResultMessage logout(String accountName) throws Exception {
        return userHelper.logout(accountName);
    }
}
