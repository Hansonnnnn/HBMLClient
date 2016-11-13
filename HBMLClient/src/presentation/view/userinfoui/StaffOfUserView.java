package presentation.view.userinfoui;

import javax.swing.*;

/**
 * Created by alex on 16-11-10.
 */
public class StaffOfUserView extends JPanel{
    private static final long serialVersionUID = 1L;
    private UserInfoViewControllerService controller;
    public StaffOfUserView(UserInfoViewControllerService userInfoViewControllerService){
        controller=userInfoViewControllerService;
    }

    public void showUserInfo(){
        controller.showUserInfo();
    }

    public void showUserInfoList(){
        controller.showUserInfoList();
    }

    public void login(String id,String pwd){
        controller.login(id,pwd);
    }

    public void logout(){
        controller.logout();
    }
}
