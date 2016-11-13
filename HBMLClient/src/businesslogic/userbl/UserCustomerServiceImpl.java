package businesslogic.userbl;

import businesslogicservice.userblservice.UserCustomerService;
import dao.user.UserDao;
import message.ResultMessage;
import po.UserPO;
import rmi.ClientRunner;
import vo.CustomerVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by alex on 16-11-9.
 */
public class UserCustomerServiceImpl implements UserCustomerService{
    private ArrayList<Object> customerInfo;

    private UserDao userDao;

    public UserCustomerServiceImpl(){
        userDao= ClientRunner.remoteHelper.getUserDao();
        try{
            customerInfo=userDao.getUserList();
        }catch (RemoteException e){
            e.printStackTrace();
        }

    }


    @Override
    public ResultMessage modifyUserInfo(CustomerVO vo) {
        userDao=new UserDaoImpl_stub();
        try {
            UserTransferImpl trans=new UserTransferImpl();
            UserPO po=trans.toCustomerPO(vo);
            userDao.update(po);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResultMessage.failure;
    }

    @Override
    public CustomerVO showUserInfo() {
        userDao=new UserDaoImpl_stub();
        try {
            CustomerVO vo=(CustomerVO) userDao.getUserList().get(0);
            return(vo);
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

    @Override
    public ResultMessage signup(CustomerVO vo) {
        userDao=new UserDaoImpl_stub();
        try {
            userDao.signup(vo);
            return ResultMessage.success;
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResultMessage.failure;
    }
}
