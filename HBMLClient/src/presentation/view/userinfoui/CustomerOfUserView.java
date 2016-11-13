package presentation.view.userinfoui;

import vo.CustomerVO;

import javax.swing.*;

/**
 * Created by alex on 16-11-10.
 */
public class CustomerOfUserView extends JPanel{
    private static final long serialVersionUID = 1L;
    private UserInfoViewControllerService controller;
    public CustomerOfUserView(UserInfoViewControllerService userInfoViewControllerService){
        this.controller=userInfoViewControllerService;
    }
    public void signup(){
        controller.signup(new CustomerVO("123123"));
    }

    public void showUserInfo(){
        controller.showUserInfo();
    }


    public void login(String id,String pwd){
        controller.login(id,pwd);
    }

    public void logout(){
        controller.logout();
    }

    public void addUserInfo(){
        controller.addUserInfo(new CustomerVO("0000"));
    }

    public void modifyUserInfo(){
        controller.modifyUserInfo(new CustomerVO("00010"));
    }
}
