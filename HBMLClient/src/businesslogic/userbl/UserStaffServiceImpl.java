package businesslogic.userbl;

import businesslogicservice.userblservice.UserStaffService;
import dao.user.UserDao;
import message.ResultMessage;
import rmi.ClientRunner;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by alex on 16-11-9.
 */
public class UserStaffServiceImpl implements UserStaffService{
    private ArrayList<Object> customerInfo;

    private UserDao userDao;

    public UserStaffServiceImpl(){
        userDao= ClientRunner.remoteHelper.getUserDao();
        try {
            customerInfo = userDao.getUserList();
        }catch(RemoteException e){
            e.printStackTrace();
        }
    }

    @Override
    public CustomerVO showUserInfo() {
        userDao=new UserDaoImpl_stub();
        try {
            CustomerVO vo=(CustomerVO) userDao.getUserList().get(0);
            return vo;
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<CustomerVO> showUserInfoList() {
        userDao=new UserDaoImpl_stub();
        try {
            customerInfo=userDao.getUserList();//seems necessary because the data may be modified during the thread
            ArrayList<CustomerVO> vos=new ArrayList<CustomerVO>();
            for(int i=0;i<customerInfo.size()-1;i++){
                vos.add((CustomerVO)customerInfo.get(i));
            }
            return vos;
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
