import businesslogic.userbl.UserCustomerImpl;
import businesslogicservice.userblservice.UserCustomerService;
import model.UserType;
import vo.UserVO;


/**
 * Created by alex on 12/18/16.
 */
public class test_Alex_User_BL {
    public void signup()throws Exception{
        UserCustomerService userCustomerService=new UserCustomerImpl();
        UserVO userVO=new UserVO(UserType.Customer,"fuck","pwd");
        System.out.println(userCustomerService.signup(userVO));
    }
}
