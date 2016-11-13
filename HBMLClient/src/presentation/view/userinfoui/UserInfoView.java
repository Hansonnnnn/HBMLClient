package presentation.view.userinfoui;

import vo.CustomerVO;

/**
 * Created by alex on 16-11-10.
 */
public class UserInfoView {
    private CustomerOfUserView customerOfUserView;
    private StaffOfUserView staffOfUserView;
    private WebMarketerOfUserView webMarketerOfUserView;
    private WebManagerOfUserView webManagerOfUserView;
    UserInfoViewControllerService controller;
    public UserInfoView(UserInfoViewControllerService userInfoViewControllerService){
        controller=userInfoViewControllerService;
    }

    public static void main(String args[]){
        UserInfoViewControllerService userInfoViewControllerService=new UserInfoViewControlloerService_stub(null,"0001");
        userInfoViewControllerService.showUserInfo();
        userInfoViewControllerService.addUserInfo(new CustomerVO("00000"));
        userInfoViewControllerService.deleteUserInfo(new CustomerVO("00000"));
        userInfoViewControllerService.findUserInfo("0001");
        userInfoViewControllerService.modifyUserInfo(new CustomerVO("000010"));
        userInfoViewControllerService.login("0000","0000");
        userInfoViewControllerService.login("0001","0001");
        userInfoViewControllerService.login("0002","0002");
        userInfoViewControllerService.login("0003","0003");
        userInfoViewControllerService.logout();
        userInfoViewControllerService.signup(new CustomerVO("00011"));
        userInfoViewControllerService.signup(new CustomerVO("11111"));
        userInfoViewControllerService.showUserInfoList();
    }
}
