package driver;

import businesslogicservice.TransferService;
import businesslogicservice.userblservice.*;
import model.MemberType;
import model.UserType;
import vo.UserVO;

/**
 * Created by alex on 16-11-9.
 */
public class UserInfoBLService_Driver {
    public void drive(UserCustomerService userCustomerService, UserStaffService userStaffService, UserWebMarketerService userWebMarketerService, UserWebManagerService userWebManagerService){
        //testing userCustomerService
        UserVO userVOTest=new UserVO(0, UserType.Customer,"alex2097","123","Alex Yu","13818052097",null,100, MemberType.Person,null,0,null,1);
        userCustomerService.getUserData(1);
        userCustomerService.getUserData("alex");
        userCustomerService.login("admin","123");
        userCustomerService.logout();
        userCustomerService.modifyUserInfo(userVOTest);
        userCustomerService.signup(userVOTest);

        //testing userStaffService
        userStaffService.signup(userVOTest);
        userStaffService.login("admin","123");
        userStaffService.getUserData("alex");
        userStaffService.getUserData(1);
        userStaffService.logout();

        //testing userWebMarketerService
        userWebMarketerService.login("admin","123");
        userWebMarketerService.logout();
        userWebMarketerService.signup(userVOTest);

        //testing userWebManagerService
        userWebManagerService.login("admin","123");
        userWebManagerService.signup(userVOTest);
        userWebManagerService.logout();
        userWebManagerService.addUser(userVOTest);
        userWebManagerService.deleteUser(1);
        userWebManagerService.modifyUser(userVOTest);
        userWebManagerService.getUser(1);
    }
}
