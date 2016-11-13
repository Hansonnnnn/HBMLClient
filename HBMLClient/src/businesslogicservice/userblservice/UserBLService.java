package businesslogicservice.userblservice;

import vo.UserVO;

/**
 * Created by alex on 16-10-16.
 */
public interface UserBLService {
    public void showUser(UserVO vo);
    public void showUserList(UserVO[] vos);
    public boolean addUser(UserVO vo);
    public boolean deleteUser(String id);
    public boolean login(String id,String password);
    public boolean logout();
    public boolean signUp(UserVO vo);
    public boolean modify(UserVO vo);
}
