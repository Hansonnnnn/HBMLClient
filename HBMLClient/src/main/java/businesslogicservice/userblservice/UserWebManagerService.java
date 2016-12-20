package businesslogicservice.userblservice;

import message.ResultMessage;
import vo.UserVO;


/**
 * Created by alex on 16-11-9.
 */
public interface UserWebManagerService {
    //getPortrait获得Image对象
    public UserVO getUserData(int userID)throws Exception;

    public UserVO getUserData(String accountName)throws Exception;

    /**
     *
     * @param vo
     * @return
     * @throws Exception
     */
    public ResultMessage addUser(UserVO vo)throws Exception;

    public ResultMessage deleteUser(int userID)throws Exception;

    public ResultMessage modifyUser(UserVO vo)throws Exception;

    public ResultMessage login(String accountName,String pwd)throws Exception;

    public ResultMessage signup(UserVO vo)throws Exception;

    /**
     *
     * @param accountName
     * @return  如果返回failure,提示用户已经登出；如果是notexist,提示无此用户
     * @throws Exception
     */
    public ResultMessage logout(String accountName) throws Exception;
}
