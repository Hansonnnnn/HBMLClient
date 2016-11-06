package dataservice.userdataservice;

import po.CustomerPO;
import po.StaffPO;
import po.WebManagerPO;
import po.WebMarketerPO;

/**
 * Created by alex on 16-10-16.
 */
public interface UserDataService {
    public void insert(CustomerPO userPO);
    public void insert(StaffPO staffPO);
    public void insert(WebManagerPO webManagerPO);
    public void insert(WebMarketerPO webMarketerPO);
    public void delete(String id);
    public void update(CustomerPO userPO);
    public void update(StaffPO staffPO);
    public void update(WebManagerPO webManagerPO);
    public void update(WebMarketerPO webMarketerPO);
    public Object findUser(Object UserPo,String id);
}
