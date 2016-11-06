package dao;
import java.rmi.Remote;
import java.rmi.RemoteException;
import message.ResultMessage;

/**
 * Created by alex on 16-11-6.
 */

public interface UserDAO extends Remote{
    public ResultMessage add(Object po) throws RemoteException;
    public Object find(String id) throws RemoteException;
    public ResultMessage delete(Object po) throws RemoteException;
    public ResultMessage update(Object po) throws RemoteException;
    public ResultMessage login(String id, String pwd) throws RemoteException;
    public ResultMessage signup(Object po) throws RemoteException;
}
