package businesslogic.userbl;

import businesslogic.creditbl.helper.CreditHelper;
import businesslogic.userbl.helper.UserHelper;
import businesslogicservice.userblservice.UserCustomerService;
import message.ResultMessage;
import model.UserType;
import vo.UserVO;

/**
 * Created by alex on 12/13/16.
 */
public class UserCustomerImpl implements UserCustomerService{

    UserHelper userHelper;
    CreditHelper creditHelper;

    public UserCustomerImpl() {

        userHelper=new UserHelper();
        creditHelper=new CreditHelper();

    }


    @Override
    public UserVO getUserData(int userID) throws Exception{

        UserVO userVO=userHelper.getUserData(userID);
        if(userVO!=null){
            if(userVO.getUserType().equals(UserType.Customer)) return userVO;
            else return null;
        }
        return userVO;

    }

    @Override
    public UserVO getUserData(String accountName) throws Exception{

        UserVO userVO=userHelper.getUserData(accountName);
        if(userVO!=null){
            if(userVO.getUserType().equals(UserType.Customer)) return userVO;
            else return null;
        }
        return userVO;

    }

    @Override
    public ResultMessage modifyUser(UserVO vo) throws Exception{

        if(!vo.getUserType().equals(UserType.Customer)) return ResultMessage.failure;
        UserVO oldInfo=userHelper.getUserData(vo.getAccountName());
        if(oldInfo==null) return ResultMessage.notexist;
        return userHelper.modifyUser(vo);

    }

    @Override
    public ResultMessage login(String accountName, String pwd) throws Exception{

        return userHelper.login(accountName,pwd);

    }

    @Override
    public ResultMessage signup(UserVO vo) throws Exception{
        ResultMessage resultMessage=userHelper.signup(vo);
        if(resultMessage.equals(ResultMessage.success)){
            System.out.println("successfully signing up a user!");
        }
        return resultMessage;
    }

    @Override
    public ResultMessage logout(String accountName) throws Exception {
        return userHelper.logout(accountName);
    }
}
