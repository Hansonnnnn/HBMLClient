/*package businesslogic.userbl;

import businesslogicservice.userblservice.UserWebMarketerService;
import dao.UserDao;
import message.ResultMessage;
import rmi.ClientRunner;

import java.rmi.RemoteException;

*//**
 * Created by alex on 16-11-9.
 *//*
public class UserWebMarkerServiceImpl implements UserWebMarketerService{
    UserDao userDao;
    public UserWebMarkerServiceImpl(){
        userDao= ClientRunner.remoteHelper.getUserDao();
    }

    @Override
    public ResultMessage login(String id, String pwd) {
        userDao=new UserDaoImpl_stub();
        try {
            userDao.login(id,pwd);
            return ResultMessage.success;
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResultMessage.failure;
    }

    @Override
    public ResultMessage logout() {
        return ResultMessage.success;
    }
}
*/