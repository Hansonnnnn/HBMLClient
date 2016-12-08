package businesslogic.userbl;

import dao.user.UserDao;
import message.ResultMessage;
import po.UserPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by alex on 16-11-9.
 */
public class UserDaoImpl_stub implements UserDao{
    @Override
    public ArrayList<UserPO> getUserList() throws RemoteException {
        ArrayList<UserPO> userlist=new ArrayList<UserPO>();
//        userlist.add(new UserPO("0000000000"));
//        userlist.add(new UserPO("0000000001"));
//        userlist.add(new UserPO("0000000002"));
//        userlist.add(new UserPO("0000000003"));
        return userlist;
    }

    @Override
    public ResultMessage add(UserPO po) throws RemoteException {
        //Conundrums here: how to identify a po as an object?
        //in this method, we have to know what kind of po is so that we can call different methods
        //temporary solution::
        //1. create a general userPO
        //2. directly decoding the Object po so that the actual type is accessible
        //same conundrums as below
        //3. add an, maybe repeatedly, id into the parameter list.
        System.out.println("adding successfully!");
        return ResultMessage.success;
    }

    @Override
    public UserPO find(String id) throws RemoteException {
//        if(id.equals("0000000000")){
//            System.out.println("a customer found");
//            return new UserPO("9900000000");
//        }else if(id.equals("0200000000")){
//            System.out.println("a staff found");
//            return new UserPO("0200000000");
//        }else if(id.equals("0100000000")){
//            System.out.println("a web marketer found");
//            return new UserPO("0100000000");
//        }else if(id.equals("0000000000")){
//            System.out.println("a web manager found");
//            return new UserPO("0000000000");
//        }
//        System.out.println("find unsuccessfully");
        return null;
    }

    @Override
    public ResultMessage delete(UserPO po) throws RemoteException {
        System.out.println("delete successfully");
        return ResultMessage.success;
    }

    @Override
    public ResultMessage update(UserPO po) throws RemoteException {
        System.out.println("update successfully");
        return ResultMessage.success;
    }

    @Override
    public ResultMessage login(String id, String pwd) throws RemoteException {
        if(id.equals(pwd)) {
            if(id.equals("9900000000")){
                System.out.println("a customer logged in");
            }else if(id.equals("0200000000")){
                System.out.println("a staff logged in");
            }else if(id.equals("0100000000")){
                System.out.println("a web marketer logged in");
            }else if(id.equals("0000000000")){
                System.out.println("a web manager logged in");
            }
            return ResultMessage.success;
        }
        else{
            System.out.println("login unsuccessfully");
            return ResultMessage.failure;
        }
    }

    @Override
    public ResultMessage signup(UserPO po) throws RemoteException {
        //the processes of checking and DB operation are ignored
        System.out.println("signup successfully");
        return ResultMessage.success;
    }
}
