package businesslogic.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import businesslogicservice.UserInfoService;
import message.ResultMessage;

public class UserInfoImpl implements UserInfoService{

	@Override
	public String getLocalUser() {
		File file = new File("localUserInfo.txt");
		if (!file.exists()) {
			return null;
		}
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String accountName =null ;
		try {
			accountName = bufferedReader.readLine();
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountName;
	}

	@Override
	public ResultMessage saveLocalUserInfo(String accoutName) {
		File file = new File("localUserInfo.txt");
		try {
			file.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(accoutName.getBytes());
			fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.failure;
		}
		
		 
		return ResultMessage.success;
	}

	@Override
	public ResultMessage logout() {
		File file = new File("localUserInfo.txt");
		file.delete();
		return ResultMessage.success;
	}

}
