package presentation.view.userinfoui;

import message.ResultMessage;
import model.UserTypeHelper;
import vo.UserVO;

import java.util.ArrayList;

/**
 * Created by alex on 16-11-10.
 */
public class UserInfoViewControlloerService_stub implements UserInfoViewControllerService{
    String users_type;
    String users_ID;
    public UserInfoViewControlloerService_stub(String type,String id) {
        this.users_type=type;
        this.users_ID=id;
    }

    @Override
    public ResultMessage addUserInfo(UserVO vo) {
        if(this.users_type.equals("Customer")){
            //add a customer
            return ResultMessage.success;
        }else if(this.users_type.equals("Staff")){
            //add a staff
            return ResultMessage.success;
        }else if(this.users_type.equals("WebMarketer")){
            //add a web marketer
            return ResultMessage.success;
        }else if(this.users_type.equals("WebManager")){
            //add a web manager
            return ResultMessage.success;
        }
        return ResultMessage.failure;
    }

    @Override
    public ResultMessage deleteUserInfo(String id) {
        UserTypeHelper userTypeHelper=new UserTypeHelper();
//        if(userTypeHelper.getUserType(id).equals(UserType.Customer)){
//            //delete the customer
//            return ResultMessage.success;
//        }else if(userTypeHelper.getUserType(id).equals(UserType.Staff)){
//            //delete the staff
//            return ResultMessage.success;
//        }else if(userTypeHelper.getUserType(id).equals(UserType.WebMarketer)){
//            //delete the web marketer
//            return ResultMessage.success;
//        }else if(userTypeHelper.getUserType(id).equals(UserType.WebManager)){
//            //delete the web mananger
//            return ResultMessage.success;
//        }else return ResultMessage.failure;
        return null;
    }

    @Override
    public ResultMessage modifyUserInfo(UserVO vo) {
        if(this.users_type.equals("Customer")){
            //modify the customer
            return ResultMessage.success;
        }else if(this.users_type.equals("Staff")){
            //modify the staff
            return ResultMessage.success;
        }else if(this.users_type.equals("WebMarketer")){
            //modify the web marketer
            return ResultMessage.success;
        }else if(this.users_type.equals("WebManager")){
            //modify the web manager
            return ResultMessage.success;
        }
        return ResultMessage.failure;
    }

    @Override
    public UserVO findUserInfo(String id) {
//        UserTypeHelper userTypeHelper=new UserTypeHelper();
//        if(userTypeHelper.getUserType(id).equals(UserType.NoSuchUser)){
//            return null;
//        }else{
//            //fetch by id
//            return new UserVO(id);
//        }
    	return null;
    }

    @Override
    public UserVO showUserInfo() {
        return this.findUserInfo(this.users_ID);
    }

    @Override
    public ArrayList<UserVO> showUserInfoList() {
//        UserTypeHelper userTypeHelper=new UserTypeHelper();
//        if(userTypeHelper.getUserType(this.users_ID).equals(UserType.Customer)){
//            //fetch by id
//            ArrayList<UserVO> vos=new ArrayList<UserVO>();
//            vos.add(new UserVO("1230000000"));
//            vos.add(new UserVO("1230000001"));
//            vos.add(new UserVO("1230000002"));
//            return vos;
//        }else if(userTypeHelper.getUserType(this.users_ID).equals(UserType.WebMarketer)){
//            //fetch by id
//            ArrayList<UserVO> vos=new ArrayList<UserVO>();
//            vos.add(new UserVO("0200000000"));
//            vos.add(new UserVO("0200000001"));
//            vos.add(new UserVO("0200000002"));
//            return vos;
//        }
        return null;
    }

    @Override
    public ResultMessage login(String id, String pwd) {
        return ResultMessage.success;
    }

    @Override
    public ResultMessage logout() {
        return ResultMessage.success;
    }

    @Override
    public ResultMessage signup(UserVO vo) {
        return ResultMessage.success;
    }
}
