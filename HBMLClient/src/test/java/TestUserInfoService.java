import java.rmi.RemoteException;
import java.util.Map;

import businesslogic.creditbl.CreditCustomerImpl;
import businesslogic.creditbl.CreditWebMarketerImpl;
import businesslogic.creditbl.helper.CreditHelper;
import businesslogic.orderbl.OrderWebMarketerServiceImpl;
import businesslogic.userbl.UserCustomerImpl;
import businesslogic.utility.UserInfoImpl;
import businesslogicservice.UserInfoService;
import businesslogicservice.creditblservice.CreditCustomerService;
import businesslogicservice.creditblservice.CreditWebMarketerService;
import businesslogicservice.orderblservice.OrderWebMarketerService;
import businesslogicservice.userblservice.UserCustomerService;
import dao.CreditDao;
import dao.UserDao;
import rmi.ClientRunner;
import vo.AppealVO;
import vo.OrderVO;
import vo.UserVO;

public class TestUserInfoService {

	public static void main(String[] args) {
		ClientRunner clientRunner = new ClientRunner();

		/*UserInfoService userInfoService = new UserInfoImpl();
		userInfoService.saveLocalUserInfo("谢振宇SB");
		System.out.println(userInfoService.getLocalUser());
		userInfoService.logout();*/
		
		/*UserCustomerService userCustomerService = new UserCustomerImpl();
		UserVO userVO = userCustomerService.getUserData(1);
		System.out.println(userVO);
		UserDao userDao = ClientRunner.remoteHelper.getUserDao();
		System.out.println(userDao);*/
			
	/*	UserDao userDao  = ClientRunner.remoteHelper.getUserDao();
		
		CreditDao creditDao = ClientRunner.remoteHelper.getCreditDao();
		try {
			System.out.println(userDao.getUserData(1));
			System.out.println(creditDao.getCreditValue(1));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*CreditCustomerService creditCustomerService = new CreditCustomerImpl();
		System.out.println(creditCustomerService.getCreditValue(1));
	*/
		OrderWebMarketerService orderWebMarketerService = new OrderWebMarketerServiceImpl();
		Map<Integer, AppealVO>map = orderWebMarketerService.getAppealOrderList(0);
	
		/*CreditWebMarketerService creditWebMarketerService = new CreditWebMarketerImpl();
		System.out.println(creditWebMarketerService.addCreditValue(1, 22));*/
	}
}
