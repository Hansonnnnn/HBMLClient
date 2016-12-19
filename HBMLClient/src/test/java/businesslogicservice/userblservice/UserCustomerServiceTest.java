package businesslogicservice.userblservice;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.userbl.UserCustomerImpl;
import message.ResultMessage;
import rmi.ClientRunner;
import vo.UserVO;

public class UserCustomerServiceTest {

	UserCustomerService userCustomerService = new UserCustomerImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClientRunner clientRunner = new ClientRunner();
	}

	@Test
	public void testGetUserDataInt() {
		UserVO userVO = null;
		try {
			userVO = userCustomerService.getUserData(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(userVO);
	}

	@Test
	public void testGetUserDataString() {
		UserVO userVO = null;
		try {
			userVO = userCustomerService.getUserData("小俊");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(userVO);
		}

	@Test
	public void testModifyUser() {
		UserVO userVO = null;
		ResultMessage resultMessage = null;
		try {
			userVO = userCustomerService.getUserData("小俊");
			resultMessage = userCustomerService.modifyUser(userVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(ResultMessage.success, resultMessage);
	}

	@Test
	public void testLogin() {
		ResultMessage resultMessage = null;
		try {
			resultMessage = userCustomerService.login("小俊","66666666");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(ResultMessage.success, resultMessage);
	}

	@Test
	public void testSignup() {
		UserVO userVO = null;
		ResultMessage resultMessage = null;
		try {
			userVO = userCustomerService.getUserData("小俊");
			userVO.setAccountName("小俊6");
			resultMessage = userCustomerService.signup(userVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(ResultMessage.success, resultMessage);
	}
}
