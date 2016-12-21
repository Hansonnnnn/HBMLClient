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
    public UserVO getUserData(int userID){

        UserVO userVO=userHelper.getUserData(userID);
        if(userVO!=null){
            if(userVO.getUserType().equals(UserType.Staff)) return userVO;
            else return null;
        }
        return userVO;

    }

    @Override
    public UserVO getUserData(String accountName){

        UserVO userVO=userHelper.getUserData(accountName);
        if(userVO!=null){
            if(userVO.getUserType().equals(UserType.Staff)) return userVO;
            else return null;
        }
        return userVO;

    }

}
