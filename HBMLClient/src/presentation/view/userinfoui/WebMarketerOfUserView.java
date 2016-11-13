package presentation.view.userinfoui;

import javax.swing.*;

/**
 * Created by alex on 16-11-10.
 */
public class WebMarketerOfUserView extends JPanel{
    private static final long serialVersionUID = 1L;
    private UserInfoViewControllerService controller;
    public WebMarketerOfUserView(UserInfoViewControllerService userInfoViewControllerService){
        this.controller=userInfoViewControllerService;
    }
    public void login(String id,String pwd){
        controller.login(id,pwd);
    }

    public void logout(){
        controller.logout();
    }
}
