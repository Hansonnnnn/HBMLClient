package driver;

import businesslogicservice.userblservice.*;

/**
 * Created by alex on 16-11-9.
 */
public class UserInfoBLService_Driver {
    public void drive(TransferService userTransferService, UserCustomerService userCustomerService
            , UserStaffService userStaffService, UserWebMarketerService userWebMarketerService, UserWebManagerService userWebManagerService){
        userTransferService.findCustomer("0000");
        userTransferService.findStaff("0001");
        userTransferService.findWebMarketer("0002");
        userTransferService.findWebManager("0003");
        userTransferService.toCustomerPO(new CustomerVO("0000"));
        userTransferService.toStaffPO(new StaffVO("0001"));
        userTransferService.toWebMarketerPO(new WebMarketerVO("0002"));
        userTransferService.toWebManagerPO(new WebManagerVO("0003"));

        userCustomerService.login("0000","0000");
        userCustomerService.logout();
        userCustomerService.modifyUserInfo(new CustomerVO("10000"));
        userCustomerService.showUserInfo();
        userCustomerService.signup(new CustomerVO("11111"));

        userStaffService.login("0001","0001");
        userStaffService.logout();
        userStaffService.showUserInfo();
        userStaffService.showUserInfoList();

        userWebMarketerService.login("0002","0002");
        userWebMarketerService.logout();

        userWebManagerService.login("0003","0003");
        userWebManagerService.logout();
        userWebManagerService.showUserInfo();
        userWebManagerService.showUserInfoList();
        userWebManagerService.addUser(new StaffVO("00022"));
        userWebManagerService.addUser(new WebMarketerVO("123123"));
        userWebManagerService.deleteUser(new CustomerVO("123"));
        userWebManagerService.findUser("0000");
        userWebManagerService.findUser("0001");
        userWebManagerService.findUser("0002");
        userWebManagerService.findUser("0003");
        userWebManagerService.modifyUserInfo(new StaffVO("123123"));
    }
}
