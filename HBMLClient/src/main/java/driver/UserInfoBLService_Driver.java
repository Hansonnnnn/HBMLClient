package driver;

import businesslogicservice.TransferService;
import businesslogicservice.userblservice.*;
import vo.UserVO;

/**
 * Created by alex on 16-11-9.
 */
public class UserInfoBLService_Driver {
    public void drive(TransferService userTransferService, UserCustomerService userCustomerService
            , UserStaffService userStaffService, UserWebMarketerService userWebMarketerService, UserWebManagerService userWebManagerService){
        userCustomerService.login("9900000000","9900000000");
        userCustomerService.logout();
        userCustomerService.modifyUserInfo(new UserVO("9900000000"));
        userCustomerService.showUserInfo();
        userCustomerService.signup(new UserVO("9900000001"));

        userStaffService.login("0200000001","0200000001");
        userStaffService.logout();
        userStaffService.showUserInfo();
        userStaffService.showUserInfoList();

        userWebMarketerService.login("0100000001","0100000001");
        userWebMarketerService.logout();

        userWebManagerService.login("0000000000","0000000000");
        userWebManagerService.logout();
        userWebManagerService.showUserInfo();
        userWebManagerService.showUserInfoList();
        userWebManagerService.addUser(new UserVO("0200000002"));
        userWebManagerService.addUser(new UserVO("0200000002"));
        userWebManagerService.deleteUser(new UserVO("12300000000"));
        userWebManagerService.findUser("0000000000");
        userWebManagerService.findUser("0100000000");
        userWebManagerService.findUser("0200000000");
        userWebManagerService.findUser("0300000000");
        userWebManagerService.modifyUserInfo(new UserVO("1231230000"));
    }
}
