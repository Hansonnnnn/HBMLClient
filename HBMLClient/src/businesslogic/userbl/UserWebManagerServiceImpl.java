package businesslogic.userbl;

import businesslogicservice.userblservice.UserWebManagerService;
import dao.user.UserDao;
import message.ResultMessage;
import rmi.ClientRunner;
import vo.CustomerVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by alex on 16-11-9.
 */
public class UserWebManagerServiceImpl implements UserWebManagerService{
    private ArrayList<Object> userInfo;

    private UserDao userDao;

    public UserWebManagerServiceImpl(){
        userDao= ClientRunner.remoteHelper.getUserDao();
        try {
            userInfo = userDao.getUserList();
        }catch(RemoteException e){
            e.printStackTrace();
        }
    }

    @Override
    public ResultMessage addUser(Object vo) {
        userDao=new UserDaoImpl_stub();
        try {
            UserTransferImpl trans=new UserTransferImpl();
            //have to judge whether the vo is CustomerVO
            CustomerPO po=trans.toCustomerPO((CustomerVO) vo);
            userDao.add(po);
            return ResultMessage.success;
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResultMessage.failure;
    }


    @Override
    public ResultMessage deleteUser(Object vo) {
        userDao=new UserDaoImpl_stub();
        try {
            UserTransferImpl trans=new UserTransferImpl();
            //have to judge whether the vo is CustomerVO
            CustomerPO po=trans.toCustomerPO((CustomerVO) vo);
            userDao.delete(po);
            return ResultMessage.success;
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResultMessage.failure;
    }

    @Override
    public Object findUser(String id) {
        userDao=new UserDaoImpl_stub();
        try {
            return userDao.find(id);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResultMessage.failure;
    }

    @Override
    public ResultMessage modifyUserInfo(Object vo) {
        userDao=new UserDaoImpl_stub();
        try {
            UserTransferImpl trans=new UserTransferImpl();
            //have to judge whether the vo is CustomerVO
            CustomerPO po=trans.toCustomerPO((CustomerVO) vo);
            userDao.update(po);
            return ResultMessage.success;
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResultMessage.failure;
    }

    @Override
    public Object showUserInfo() {
        userDao=new UserDaoImpl_stub();
        try {
            ArrayList<Object> userList=userDao.getUserList();
            return userList.get(0);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResultMessage.failure;
    }

    @Override
    public ArrayList<Object> showUserInfoList() {
        userDao=new UserDaoImpl_stub();
        try {
            ArrayList<Object> userList=userDao.getUserList();
            return userList;
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultMessage login(String id, String pwd) {
        userDao=new UserDaoImpl_stub();
        try {
            return userDao.login(id,pwd);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResultMessage.failure;
    }

    @Override
    public ResultMessage logout(){
        return ResultMessage.success;
    }
}
