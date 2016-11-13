package businesslogicservice.userblservice;

import po.UserPO;

/**
 * Created by alex on 16-11-9.
 */
public interface UserTransferService {
    public CustomerVO findCustomer(String id);
    public UserPO toCustomerPO(CustomerVO vo);
    public StaffVO findStaff(String id);
    public UserPO toStaffPO(StaffVO vo);
    public WebMarketerVO findWebMarketer(String id);
    public UserPO toWebMarketerPO(WebMarketerVO vo);
    public WebManagerVO findWebManager(String id);
    public UserPO toWebManagerPO(WebManagerVO vo);
}
