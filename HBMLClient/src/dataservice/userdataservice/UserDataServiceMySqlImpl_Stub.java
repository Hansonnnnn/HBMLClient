package dataservice.userdataservice;

import po.CustomerPO;
import po.StaffPO;
import po.WebManagerPO;
import po.WebMarketerPO;

/**
 * Created by alex on 16-10-16.
 */
public class UserDataServiceMySqlImpl_Stub implements UserDataService {
    public UserDataServiceMySqlImpl_Stub() {
    }

    @Override
    public void insert(CustomerPO userPO) {
        System.out.println("a user successfully inserted!");
    }

    @Override
    public void insert(StaffPO staffPO) {
        System.out.println("a staff successfully inserted!");
    }

    @Override
    public void insert(WebManagerPO webManagerPO) {
        System.out.println("a web manager successfully inserted!");
    }

    @Override
    public void insert(WebMarketerPO webMarketerPO) {
        System.out.println("a web marketer successfully inserted!");
    }

    @Override
    public void delete(String id) {
        System.out.println("id "+id+" successfully deleted!");
    }

    @Override
    public void update(CustomerPO userPO) {
        System.out.println("a user successfully updated!");
    }

    @Override
    public void update(StaffPO staffPO) {
        System.out.println("a staff successfully updated!");
    }

    @Override
    public void update(WebManagerPO webManagerPO) {
        System.out.println("a web manager successfully updated!");
    }

    @Override
    public void update(WebMarketerPO webMarketerPO) {
        System.out.println("a web marketer successfully updated!");
    }

    @Override
    public Object findUser(Object userPo,String id) {
        if(id.charAt(0)!='0'&&id.charAt(1)!='0')
            return new CustomerPO(id);
        else if(id.charAt(0)=='0'&&id.charAt(1)!='0')
            return new StaffPO(id);
        else if(id.charAt(0)=='1'&&id.charAt(1)!='0')
            return new WebManagerPO(id);
        else return new WebMarketerPO(id);
    }
}
