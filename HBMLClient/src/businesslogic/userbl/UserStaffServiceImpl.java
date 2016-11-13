package businesslogic.userbl;

import businesslogic.utility.TransferImpl;
import businesslogicservice.userblservice.UserStaffService;
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
public class UserStaffServiceImpl implements UserStaffService{
    private ArrayList<UserPO> customerInfo;

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
    public UserVO showUserInfo() {
        userDao=new UserDaoImpl_stub();
        try {
            TransferImpl transfer=new TransferImpl();
            UserVO vo=transfer.poToVo(userDao.getUserList().get(0));
            return vo;
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<UserVO> showUserInfoList() {
        userDao=new UserDaoImpl_stub();
        try {
            customerInfo=userDao.getUserList();
            ArrayList<UserVO> vos=new ArrayList<UserVO>();
            TransferImpl transfer=new TransferImpl();
            for(int i=0;i<customerInfo.size()-1;i++){
                vos.add(transfer.poToVo(customerInfo.get(i)));
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
