package businesslogic.userbl;

import businesslogic.userbl.helper.UserHelper;
import businesslogicservice.userblservice.UserWebMarketerService;
import message.ResultMessage;
import model.UserType;
import vo.UserVO;

/**
 * Created by alex on 12/13/16.
 */
public class UserWebMarketerImpl implements UserWebMarketerService {

    UserHelper userHelper;

    public UserWebMarketerImpl() {

        userHelper=new UserHelper();

    }


    @Override
    public UserVO getUserData(int userID){

        UserVO userVO=userHelper.getUserData(userID);
        if(userVO!=null){
            if(userVO.getUserType().equals(UserType.WebMarketer)) return userVO;
            else return null;
        }
        return userVO;

    }

    @Override
    public UserVO getUserData(String accountName){

        UserVO userVO=userHelper.getUserData(accountName);
        if(userVO!=null){
            if(userVO.getUserType().equals(UserType.WebMarketer)) return userVO;
            else return null;
        }
        return userVO;

    }

}