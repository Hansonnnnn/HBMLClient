package presentation.view.userinfoui;

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
        //controller.signup(new UserVO("1231230000"));
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
        //controller.addUserInfo(new UserVO("1234120000"));
    }

    public void modifyUserInfo(){
        //controller.modifyUserInfo(new UserVO("1234512345"));
    }
}
