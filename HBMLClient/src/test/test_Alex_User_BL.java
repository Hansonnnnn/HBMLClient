import businesslogic.userbl.UserCustomerImpl;
import businesslogic.userbl.UserLogImpl;
import businesslogic.userbl.UserWebManagerImpl;
import businesslogicservice.userblservice.UserCustomerService;
import businesslogicservice.userblservice.UserLogService;
import businesslogicservice.userblservice.UserWebManagerService;
import model.UserType;
import vo.UserVO;


/**
 * Created by alex on 12/18/16.
 */
public class test_Alex_User_BL {
    public void signup()throws Exception{
        UserLogService userLogService=new UserLogImpl();
        UserVO userVO=new UserVO(UserType.Customer,"alex124","124");
        System.out.println(userLogService.signup(userVO));
    }

    public void login()throws Exception{
        UserLogService userLogService=new UserLogImpl();
        System.out.println(userLogService.login("alex2097","asdf"));
        System.out.println(userLogService.login("alex2097","123"));

        System.out.println(userLogService.login("alex2098","asdf"));
    }

    public void logout()throws Exception{
        UserLogService userLogService=new UserLogImpl();
        System.out.println(userLogService.logout("alex2097"));
        System.out.println(userLogService.logout("alex2098"));
    }

    public void modify() throws Exception{

    }

    public void getUserInfo()throws Exception{
        UserCustomerService userCustomerService=new UserCustomerImpl();
        UserVO userVO=userCustomerService.getUserData(1);
        System.out.println(userVO.getUserID());
        System.out.println(userVO.getRank());
        System.out.println(userVO.getMemberInfo());
        System.out.println(userVO.getUserID());

    }

    public void delete()throws Exception{
        UserWebManagerService userWebManagerService=new UserWebManagerImpl();
        userWebManagerService.deleteUser(3);

    }
}
