package businesslogicservice.userblservice;

/**
 * Created by alex on 16-10-16.
 */
public interface UserBLService {
    public void showUser(Object vo);
    public void showUserList(Object[] vos);
    public boolean addUser(Object vo);
    public boolean deleteUser(String id);
    public boolean login(String id,String password);
    public boolean logout();
    public boolean signUp(Object vo);
    public boolean modify(Object vo);
}
