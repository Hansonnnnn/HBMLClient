package businesslogic.userbl;

import businesslogicservice.userblservice.UserBLService;
import vo.CustomerVO;
import vo.StaffVO;
import vo.WebManagerVO;
import vo.WebMarketerVO;

/**
 * Created by alex on 16-10-16.
 */

public class UserController implements UserBLService{
    private CustomerVO userVO;
    private StaffVO staffVO;
    private WebManagerVO webManagerVO;
    private WebMarketerVO webMarketerVO;
    private int typeint;
    public UserController(String id) {
        if(id.charAt(0)!='0'&&id.charAt(1)!='0') typeint=0;
            //indicating this user is a "user"
        else if(id.charAt(0)=='0'&&id.charAt(1)!='0') typeint=1;
            //indicating this user is a "hotel staff"
        else if(id.charAt(0)=='1'&&id.charAt(1)!='0') typeint=2;
            //indicating this user is a web manager
        else typeint=3;
        //indicating this user is a web marketer
    }


    @Override
    public void showUser(CustomerVO userVO) {
        userVO=new CustomerVO("wangshuaiwei");
    }

    @Override
    public void showStaff(StaffVO staffVO) {
        staffVO=new StaffVO("rentw666");
    }

    @Override
    public void showUserList(CustomerVO[] userVOs) {
        int i;
        userVOs=new CustomerVO[10];
        for(i=0;i<10;i++){
            userVOs[i]=new CustomerVO("wangshuaiwei10"+i+"fen");
        }
    }

    @Override 
    public void showStaffList(StaffVO[] staffVOs) {
        int i;
        staffVOs=new StaffVO[10];
        for(i=0;i<10;i++){
            staffVOs[i]=new StaffVO("rentw666");
        }
    }

    @Override
    public void showWebManager(WebManagerVO webManagerVO) {
        webManagerVO=new WebManagerVO("wangshuaiwei");
    }

    @Override
    public void showWebManagerList(WebManagerVO[] webManagerVOs) {
        int i;
        webManagerVOs=new WebManagerVO[10];
        for(i=0;i<10;i++){
            webManagerVOs[i]=new WebManagerVO("rentw666");
        }
    }

    @Override
    public void showWebMarketer(WebMarketerVO webMarketerVO) {
        webMarketerVO=new WebMarketerVO("wangshuaiwei");
    }

    @Override
    public void showwebMarketerList(WebMarketerVO[] webMarketerVOs) {
        int i;
        webMarketerVOs=new WebMarketerVO[10];
        for(i=0;i<10;i++){
            webMarketerVOs[i]=new WebMarketerVO("rentw666");
        }
    }

    @Override
    public boolean addUser(CustomerVO userVO) {
        System.out.println("a user successfully added!");
        return false;
    }

    @Override
    public boolean addStaff(StaffVO staffVO) {
        System.out.println("a staff successfully added!");
        return false;
    }

    @Override
    public boolean addWebManager(WebManagerVO webManagerVO) {
        System.out.println("a web manager successfully added!");
        return false;
    }

    @Override
    public boolean addwebMarketer(WebMarketerVO webMarketerVO) {
        System.out.println("a web marketer successfully added!");
        return false;
    }

    @Override
    public boolean deleteUser(String id) {
        System.out.println("a user successfully deleted!");
        return false;
    }

    @Override
    public boolean deleteStaff(String id) {
        System.out.println("a staff successfully deleted!");
        return false;
    }

    @Override
    public boolean deleteWebManager(String id) {
        System.out.println("a web manager successfully deleted!");
        return false;
    }

    @Override
    public boolean deleteWebMarketer(String id) {
        System.out.println("a web marketer successfully deleted!");
        return false;
    }

    @Override
    public boolean login(String id, String password) {
        if(typeint==0){
            System.out.println("user "+id+" successfully logged in");
        }else if(typeint==1){
            System.out.println("staff "+id+" successfully logged in");
        }else if(typeint==2){
            System.out.println("web manager "+id+" successfully logged in");
        }else{
            System.out.println("web marketer "+id+" successfully logged in");
        }
        return false;
    }

    @Override
    public boolean logout() {
        if (typeint == 0) {
            System.out.println("user  successfully logged in");
        } else if (typeint == 1) {
            System.out.println("staff  successfully logged in");
        } else if (typeint == 2) {
            System.out.println("web manager  successfully logged in");
        } else {
            System.out.println("web marketer  successfully logged in");
        }
        return false;
    }

    @Override
    public boolean signUp(CustomerVO userVO) {
        System.out.println("successfully signed up,here is your info");
        System.out.println("your name is "+userVO.getAccountName());
        return false;
    }

    @Override
    public boolean modify(CustomerVO userVO) {
        System.out.println("successfully modified your information, here is your info");
        System.out.println("your name is "+userVO.getAccountName());
        return false;
    }
}
