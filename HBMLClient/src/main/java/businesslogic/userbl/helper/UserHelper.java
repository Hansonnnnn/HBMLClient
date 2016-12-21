package businesslogic.userbl.helper;

import businesslogic.utility.TransferImpl;
import businesslogicservice.TransferService;
import dao.UserDao;
import message.ResultMessage;
import po.UserPO;
import rmi.ClientRunner;
import vo.UserVO;

import java.rmi.RemoteException;

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

    public UserVO getUserData(int userID){

        UserPO userPO= null;
        try {
            userPO = userDao.getUserData(userID);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(userPO==null) return null;
        else {
            try {
                return userTransferService.poToVo(userPO);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    }

    public UserVO getUserData(String accountName){

        UserPO userPO= null;
        try {
            userPO = userDao.getUserData(accountName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(userPO==null) return null;
        else {
            try {
                return userTransferService.poToVo(userPO);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    }

    public ResultMessage addUser(UserVO vo){
        UserPO userPO= null;
        userPO = userTransferService.voToPo(vo);
        try {
            return userDao.addUser(userPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.sqlFailure;
        }
    }


    public ResultMessage deleteUser(int userID){
        try {
            return userDao.deleteUser(userID);
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.sqlFailure;
        }
    }


    public ResultMessage modifyUser(UserVO vo){

        UserPO userPO= null;
        userPO = userTransferService.voToPo(vo);
        try {
            return userDao.modifyUser(userPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.sqlFailure;
        }

    }

    public ResultMessage login(String accountName, String pwd){

        try {
            return userDao.login(accountName,pwd);
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.sqlFailure;
        }
    }

    public ResultMessage signup(UserVO vo){
        UserPO userPO = null;
        userPO = userTransferService.voToPo(vo);
        try {
            return userDao.signup(userPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.sqlFailure;
        }
    }



    public ResultMessage logout(String accountName){
        try {
            return userDao.logout(accountName);
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.sqlFailure;
        }
    }



}
