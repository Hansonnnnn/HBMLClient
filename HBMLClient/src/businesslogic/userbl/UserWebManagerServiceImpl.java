package businesslogic.userbl;

import businesslogic.utility.TransferImpl;
import businesslogicservice.userblservice.UserWebManagerService;
import dao.user.UserDao;
import message.ResultMessage;
import po.UserPO;
import rmi.ClientRunner;
import vo.UserVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by alex on 16-11-9.
 */
public class UserWebManagerServiceImpl implements UserWebManagerService{
    private ArrayList<UserPO> userInfo;

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
    public ResultMessage addUser(UserVO vo) {
        userDao=new UserDaoImpl_stub();
        try {
            TransferImpl transfer=new TransferImpl();
            UserPO po=transfer.voToPo(vo);
            userDao.add(po);
            return ResultMessage.success;
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResultMessage.failure;
    }


    @Override
    public ResultMessage deleteUser(UserVO vo) {
        userDao=new UserDaoImpl_stub();
        try {
            TransferImpl transfer=new TransferImpl();
            UserPO po=transfer.voToPo(vo);
            userDao.delete(po);
            return ResultMessage.success;
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResultMessage.failure;
    }

    @Override
    public UserVO findUser(String id) {
        userDao=new UserDaoImpl_stub();
        try {
            TransferImpl transfer=new TransferImpl();
            return transfer.poToVo(userDao.find(id));
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultMessage modifyUserInfo(UserVO vo) {
        userDao=new UserDaoImpl_stub();
        try {
            TransferImpl transfer=new TransferImpl();
            UserPO po=transfer.voToPo(vo);
            userDao.update(po);
            return ResultMessage.success;
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResultMessage.failure;
    }

    @Override
    public UserVO showUserInfo() {
        userDao=new UserDaoImpl_stub();
        try {
            TransferImpl transfer=new TransferImpl();
            ArrayList<UserPO> userList=userDao.getUserList();
            return transfer.poToVo(userList.get(0));
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<UserVO> showUserInfoList() {
        int i;
        userDao=new UserDaoImpl_stub();
        try {
            TransferImpl transfer=new TransferImpl();
            ArrayList<UserPO> userList=userDao.getUserList();
            ArrayList<UserVO> userListVOver=new ArrayList<UserVO>();
            for(i=0;i<userList.size();i++){
                userListVOver.add(transfer.poToVo(userList.get(i)));
            }
            return userListVOver;
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
