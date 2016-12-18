import businesslogic.userbl.UserCustomerImpl;
import businesslogic.userbl.UserWebManagerImpl;
import businesslogicservice.userblservice.UserCustomerService;
import businesslogicservice.userblservice.UserWebManagerService;
import model.UserType;
import vo.UserVO;


/**
 * Created by alex on 12/18/16.
 */
public class test_Alex_User_BL {
    public void signup()throws Exception{
        UserCustomerService userCustomerService=new UserCustomerImpl();
        UserVO userVO=new UserVO(UserType.Customer,"alex124","124");
        System.out.println(userCustomerService.signup(userVO));
    }

    public void login()throws Exception{
        UserCustomerService userCustomerService=new UserCustomerImpl();
        System.out.println(userCustomerService.login("alex124","124"));
        System.out.println(userCustomerService.login("alex124","123"));
        System.out.println(userCustomerService.login("alex125","123"));
    }

    public void modify() throws Exception{

    }

    public void getUserInfo()throws Exception{
        UserCustomerService userCustomerService=new UserCustomerImpl();
        UserVO userVO=userCustomerService.getUserData("alex124");
        System.out.println(userVO.getRank());
        System.out.println(userVO.getMemberInfo());
        System.out.println(userVO.getUserID());

    }

    public void delete()throws Exception{
        UserWebManagerService userWebManagerService=new UserWebManagerImpl();
        userWebManagerService.deleteUser(3);

    }
}