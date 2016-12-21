import businesslogic.utility.UserInfoImpl;
import businesslogicservice.UserInfoService;

public class TestUserInfoService {

	public static void main(String[] args) {
		UserInfoService userInfoService = new UserInfoImpl();
		userInfoService.saveLocalUserInfo("谢振宇SB");
		System.out.println(userInfoService.getLocalUser());
		userInfoService.logout();
	}
}
