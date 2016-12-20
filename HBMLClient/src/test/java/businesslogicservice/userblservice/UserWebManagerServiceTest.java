//package businesslogicservice.userblservice;
//
//import static org.junit.Assert.*;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import businesslogic.userbl.UserWebManagerImpl;
//import message.ResultMessage;
//import rmi.ClientRunner;
//import vo.UserVO;
//
//public class UserWebManagerServiceTest {
//
//	UserWebManagerService userWebManagerService = new UserWebManagerImpl();
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		ClientRunner clientRunner = new ClientRunner();
//	}
//
//	@Test
//	public void testGetUserDataInt() {
//		UserVO userVO = null;
//		try {
//			userVO = userWebManagerService.getUserData(1);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertNotNull(userVO);
//	}
//
//	@Test
//	public void testGetUserDataString() {
//		UserVO userVO = null;
//		try {
//			userVO = userWebManagerService.getUserData("小俊");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertNotNull(userVO);
//		}
//
//	@Test
//	public void testLogin() {
//		ResultMessage resultMessage = null;
//		try {
//			resultMessage = userWebManagerService.login("小俊","66666666");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertEquals(ResultMessage.success, resultMessage);
//	}
//
//	@Test
//	public void testSignup() {
//		UserVO userVO = null;
//		ResultMessage resultMessage = null;
//		try {
//			userVO = userWebManagerService.getUserData("小俊");
//			userVO.setAccountName("小俊7");
//			resultMessage = userWebManagerService.signup(userVO);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertEquals(ResultMessage.success, resultMessage);
//	}
//
//
//	@Test
//	public void testAddUser() {
//		UserVO userVO = null;
//		ResultMessage resultMessage = null;
//		try {
//			userVO = userWebManagerService.getUserData("小俊");
//			userVO.setAccountName("小俊8");
//			resultMessage = userWebManagerService.addUser(userVO);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertEquals(ResultMessage.success, resultMessage);
//
//	}
//
//	@Test
//	public void testDeleteUser() {
//		fail("Not yet implemented");
//	}
//
//
//}
