package businesslogicservice.userblservice;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.userbl.UserWebMarketerImpl;
import message.ResultMessage;
import rmi.ClientRunner;
import vo.UserVO;

public class UserWebMarketerServiceTest {
	UserWebMarketerService userWebMarketerService = new UserWebMarketerImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClientRunner clientRunner = new ClientRunner();
	}

	@Test
	public void testGetUserDataInt() {
		UserVO userVO = null;
		try {
			userVO = userWebMarketerService.getUserData(1);
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
			userVO = userWebMarketerService.getUserData("小俊");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(userVO);
		}


	@Test
	public void testLogin() {
		ResultMessage resultMessage = null;
		try {
			resultMessage = userWebMarketerService.login("小俊","66666666");
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
			userVO = userWebMarketerService.getUserData("小俊");
			userVO.setAccountName("小俊6");
			resultMessage = userWebMarketerService.signup(userVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(ResultMessage.success, resultMessage);
	}

}
