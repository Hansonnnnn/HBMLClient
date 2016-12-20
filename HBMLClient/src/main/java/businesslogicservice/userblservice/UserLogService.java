package businesslogicservice.userblservice;

import message.ResultMessage;
import vo.UserVO;

/**
 * Created by alex on 12/20/16.
 */
public interface UserLogService {
    /**
     *
     * @param accountName
     * @param pwd
     * @return成功，失败(密码错误)，不存在
     */
    public ResultMessage login(String accountName, String pwd)throws Exception;

    /**
     *
     * @param vo
     * @return如果返回failure,提示用户名已存在；如果是success,可以调用登陆方法
     */
    public ResultMessage signup(UserVO vo)throws Exception;

    /**
     *
     * @param accountName
     * @return  如果返回failure,提示用户已经登出；如果是notexist,提示无此用户
     * @throws Exception
     */
    public ResultMessage logout(String accountName) throws Exception;
}
