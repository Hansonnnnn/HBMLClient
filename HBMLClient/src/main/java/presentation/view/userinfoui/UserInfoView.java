package presentation.view.userinfoui;

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
        userInfoViewControllerService.addUserInfo(new UserVO("1234500000"));
        userInfoViewControllerService.deleteUserInfo("1234500000");
        userInfoViewControllerService.findUserInfo("0001");
        userInfoViewControllerService.modifyUserInfo(new UserVO("1234000010"));
        userInfoViewControllerService.login("0000000000","0000000000");
        userInfoViewControllerService.login("0000000001","0000000001");
        userInfoViewControllerService.login("0000000002","0000000002");
        userInfoViewControllerService.login("0000000003","0000000003");
        userInfoViewControllerService.logout();
        userInfoViewControllerService.signup(new UserVO("0100000011"));
        userInfoViewControllerService.signup(new UserVO("0100011111"));
        userInfoViewControllerService.showUserInfoList();
    }
}
