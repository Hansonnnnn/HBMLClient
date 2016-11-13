package presentation.view.userinfoui;

import message.ResultMessage;

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
    public ResultMessage addUserInfo(Object vo) {
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
    public ResultMessage deleteUserInfo(Object vo) {
        if(this.users_type.equals("Customer")){
            //delete the customer
            return ResultMessage.success;
        }else if(this.users_type.equals("Staff")){
            //delete th staff
            return ResultMessage.success;
        }else if(this.users_type.equals("WebMarketer")){
            //delete the web marketer
            return ResultMessage.success;
        }else if(this.users_type.equals("WebManager")){
            //delete the web manager
            return ResultMessage.success;
        }
        return ResultMessage.failure;
    }

    @Override
    public ResultMessage modifyUserInfo(Object vo) {
        if(this.users_type.equals("Customer")){
            //modify the customer
            return ResultMessage.success;
        }else if(this.users_type.equals("Staff")){
            //modify th staff
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
    public Object findUserInfo(String id) {
        if(id.equals("0000")){
            //fetch by id
            return new CustomerVO(id);
        }else if(id.equals("0001")){
            //fetch by id
            return new StaffVO(id);
        }else if(id.equals("0002")){
            //fetch by id
            return new WebMarketerVO(id);
        }else if(id.equals("0003")){
            //fetch by id
            return new WebManagerVO(id);
        }
        return ResultMessage.failure;
    }

    @Override
    public Object showUserInfo() {
        if(this.users_ID.equals("0000")){
            //fetch by id
            return new CustomerVO(this.users_ID);
        }else if(this.users_ID.equals("0001")){
            //fetch by id
            return new StaffVO(this.users_ID);
        }else if(this.users_ID.equals("0002")){
            //fetch by id
            return new WebMarketerVO(this.users_ID);
        }else if(this.users_ID.equals("0003")){
            //fetch by id
            return new WebManagerVO(this.users_ID);
        }
        return ResultMessage.failure;
    }

    @Override
    public ArrayList<Object> showUserInfoList() {
        if(this.users_ID.equals("0001")){
            //fetch by id
            ArrayList<Object> vos=new ArrayList<Object>();
            vos.add(new CustomerVO("0000"));
            vos.add(new CustomerVO("000000"));
            vos.add(new CustomerVO("0000000"));
            return vos;
        }else if(this.users_ID.equals("0003")){
            //fetch by id
            ArrayList<Object> vos=new ArrayList<Object>();
            vos.add(new CustomerVO("0002"));
            vos.add(new CustomerVO("000200"));
            vos.add(new CustomerVO("0002000"));
        }
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
    public ResultMessage signup(CustomerVO vo) {
        return ResultMessage.success;
    }
}
