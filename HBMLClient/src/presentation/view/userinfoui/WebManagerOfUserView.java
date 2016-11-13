package presentation.view.userinfoui;

import javax.swing.*;

/**
 * Created by alex on 16-11-10.
 */
public class WebManagerOfUserView extends JPanel{
    private static final long serialVersionUID = 1L;
    private UserInfoViewControllerService controller;
    public WebManagerOfUserView(UserInfoViewControllerService userInfoViewControllerService){
        this.controller=userInfoViewControllerService;
    }

    public void showUser(){
        controller.showUserInfo();
    }

    public void showUserList(){
        controller.showUserInfoList();
    }

    public void login(String id,String pwd){
        controller.login(id,pwd);
    }

    public void logout(){
        controller.logout();
    }

    public void modifyUserInfo(){
        controller.modifyUserInfo(new WebMarketerVO("00020"));
    }

    public void addUserInfo(){
        controller.addUserInfo(new WebMarketerVO("00020"));
    }

    public void deleteUserInfo(){
        controller.deleteUserInfo(new WebMarketerVO("00020"));
    }
}
