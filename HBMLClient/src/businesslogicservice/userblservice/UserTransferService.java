package businesslogicservice.userblservice;

import vo.CustomerVO;
import vo.StaffVO;
import vo.WebManagerVO;
import vo.WebMarketerVO;

/**
 * Created by alex on 16-11-9.
 */
public interface UserTransferService {
    public CustomerVO findCustomer(String id);
    public CustomerPO toCustomerPO(CustomerVO vo);
    public StaffVO findStaff(String id);
    public StaffPO toStaffPO(StaffVO vo);
    public WebMarketerVO findWebMarketer(String id);
    public WebMarketerPO toWebMarketerPO(WebMarketerVO vo);
    public WebManagerVO findWebManager(String id);
    public WebManagerPO toWebManagerPO(WebManagerVO vo);
}
