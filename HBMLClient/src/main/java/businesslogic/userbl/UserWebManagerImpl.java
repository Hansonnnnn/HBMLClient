package businesslogic.userbl;

import businesslogic.userbl.helper.UserHelper;
import businesslogicservice.userblservice.UserWebManagerService;
import businesslogicservice.userblservice.UserWebMarketerService;
import message.ResultMessage;
import model.UserType;
import vo.UserVO;

/**
 * Created by alex on 12/13/16.
 */
public class UserWebManagerImpl implements UserWebManagerService{

    UserHelper userHelper;

    public UserWebManagerImpl() {

        userHelper=new UserHelper();

    }


    @Override
    public UserVO getUserData(int userID){

        UserVO userVO=userHelper.getUserData(userID);
        if(userVO!=null){
            if(userVO.getUserType().equals(UserType.WebManager)) return userVO;
            else return null;
        }
        return userVO;

    }

    @Override
    public UserVO getUserData(String accountName){

        UserVO userVO=userHelper.getUserData(accountName);
        if(userVO!=null){
            if(userVO.getUserType().equals(UserType.WebManager)) return userVO;
            else return null;
        }
        return userVO;
    }

    @Override
    public ResultMessage addUser(UserVO vo){

        //judge whether the userInfo is sufficient
        if(vo.getUserType().equals(UserType.Staff)||vo.getUserType().equals(UserType.WebMarketer)){
            return userHelper.addUser(vo);
        }else return ResultMessage.failure;

    }

    @Override
    public ResultMessage deleteUser(int userID){

        return userHelper.deleteUser(userID);

    }

    @Override
    public ResultMessage modifyUser(UserVO vo){

        return userHelper.modifyUser(vo);

    }

}
