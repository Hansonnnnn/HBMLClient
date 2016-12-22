package businesslogicservice;

import message.ResultMessage;

public interface UserInfoService {

	public String getLocalUser();
	
	public ResultMessage saveLocalUserInfo(String accoutName);
	
	public ResultMessage logout();
}
