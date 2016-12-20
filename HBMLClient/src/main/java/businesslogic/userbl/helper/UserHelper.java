package businesslogic.userbl.helper;

import businesslogic.utility.TransferImpl;
import businesslogicservice.TransferService;
import dao.UserDao;
import message.ResultMessage;
import po.UserPO;
import rmi.ClientRunner;
import vo.UserVO;

/**
 * Created by alex on 12/15/16.
 */
public class UserHelper {
    UserVO userVO;
    UserDao userDao;
    TransferService userTransferService;


    public UserHelper() {

        userDao= ClientRunner.remoteHelper.getUserDao();
        userTransferService=new TransferImpl();

    }

    public UserVO getUserData(int userID)throws Exception{

        UserPO userPO=userDao.getUserData(userID);
        if(userPO==null) return null;
        else return userTransferService.poToVo(userPO);

    }

    public UserVO getUserData(String accountName)throws Exception{

        UserPO userPO=userDao.getUserData(accountName);
        if(userPO==null) return null;
        else return userTransferService.poToVo(userPO);

    }

    public ResultMessage addUser(UserVO vo)throws Exception{
        UserPO userPO=userTransferService.voToPo(vo);
        return userDao.addUser(userPO);
    }


    public ResultMessage deleteUser(int userID)throws Exception{
        return userDao.deleteUser(userID);
    }


    public ResultMessage modifyUser(UserVO vo)throws Exception{

        UserPO userPO=userTransferService.voToPo(vo);
        return userDao.modifyUser(userPO);

    }

    public ResultMessage login(String accountName, String pwd)throws Exception{

        return userDao.login(accountName,pwd);
    }

    public ResultMessage signup(UserVO vo) throws Exception{
        UserPO userPO = userTransferService.voToPo(vo);
        return userDao.signup(userPO);
    }



    public ResultMessage logout(String accountName) throws Exception{
        return userDao.logout(accountName);
    }



}
