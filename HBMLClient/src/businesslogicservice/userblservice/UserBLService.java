package businesslogicservice.userblservice;

import vo.CustomerVO;
import vo.StaffVO;
import vo.WebManagerVO;
import vo.WebMarketerVO;

/**
 * Created by alex on 16-10-16.
 */
public interface UserBLService {
    public void showUser(CustomerVO userVO);
    public void showStaff(StaffVO staffVO);
    public void showUserList(CustomerVO[] userVOs);
    public void showStaffList(StaffVO[] staffVOs);
    public void showWebManager(WebManagerVO webManagerVO);
    public void showWebManagerList(WebManagerVO[] webManagerVOs);
    public void showWebMarketer(WebMarketerVO webMarketerVO);
    public void showwebMarketerList(WebMarketerVO[] webMarketerVOs);
    public boolean addUser(CustomerVO userVO);
    public boolean addStaff(StaffVO staffVO);
    public boolean addWebManager(WebManagerVO webManagerVO);
    public boolean addwebMarketer(WebMarketerVO webMarketerVO);
    public boolean deleteUser(String id);
    public boolean deleteStaff(String id);
    public boolean deleteWebManager(String id);
    public boolean deleteWebMarketer(String id);
    public boolean login(String id,String password);
    public boolean logout();
    public boolean signUp(CustomerVO userVO);
    public boolean modify(CustomerVO userVO);
}
