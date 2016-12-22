package presentation.view.customerui.customerui;

import businesslogic.userbl.UserLogImpl;
import businesslogic.utility.UserInfoImpl;
import businesslogicservice.UserInfoService;
import businesslogicservice.userblservice.UserLogService;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import message.ResultMessage;
import presentation.view.application.MyDialog;
import vo.UserVO;

public class WelcomePageController 
{
		@FXML private Button exitButton;
		@FXML private TextField nameField;
		@FXML private PasswordField passwordField;
		@FXML private Button enrollButton;
		@FXML private Button loginButton;
		@FXML private Button findPasswordButton;
		@FXML private Button secondButton;
		@FXML private Label label;
		@FXML private ImageView imageView;
		
		
		private Stage stage;
		private Scene loginPageScene;
		
		private ResultMessage resultMessage;
		private UserVO userVO;
		private UserLogService userLogService;
		private UserInfoService userInfoService;
		
		public void init(Stage stage, Scene loginPageScene)
		{
			this.stage = stage;
			this.loginPageScene = loginPageScene;
			userLogService=new UserLogImpl();
			userInfoService = new UserInfoImpl();
			resultMessage = ResultMessage.failure;
		}
		
		@FXML
		private void login()
		{
			String name = "";
			String password = "";
			if(nameField.getText()!=null&&!nameField.getText().isEmpty())
			{
				name = nameField.getText();
				if(userInfoService.getLocalUser()==null)
				{
					userInfoService.saveLocalUserInfo(name);
					try {
						if(userLogService.getUserData(name)!=null)
						{
							userVO = userLogService.getUserData(name);
						}
						//检验密码
						if(passwordField.getText()!=null&&!passwordField.getText().isEmpty())
						{
							password = passwordField.getText();
						}
						//bl层来检查用户名和密码是否匹配
						//如果
						try {
							resultMessage = userLogService.login(name, password);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(resultMessage == ResultMessage.success)
						{
							new MyDialog(stage, "登录成功", 2);
							stage.setScene(new FirstPageUI(new Group(), stage, userVO, true));
						}else if(resultMessage == ResultMessage.notexist)
						{
							//显示不存在提示对话框
							new MyDialog(stage,"该用户名不存在" , 0);
						}else if(resultMessage == ResultMessage.failure)
						{
							new MyDialog(stage,"您已在其他地点登录，不能同时登录" ,1);
						}else if(resultMessage == ResultMessage.wrongPassword)
						{
							new MyDialog(stage, "用户名或密码错误", 1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}else
				{
					try {
						if(userLogService.getUserData(name)!=null)
						{
							userVO = userLogService.getUserData(name);
						}
						//检验密码
						if(passwordField.getText()!=null&&!passwordField.getText().isEmpty())
						{
							password = passwordField.getText();
						}
						//bl层来检查用户名和密码是否匹配
						//如果
						try {
							resultMessage = userLogService.login(name, password);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(resultMessage == ResultMessage.success || resultMessage == ResultMessage.failure)
						{
							new MyDialog(stage, "登录成功", 2);
							stage.setScene(new FirstPageUI(new Group(), stage, userVO, true));
						}else if(resultMessage == ResultMessage.notexist)
						{
							//显示不存在提示对话框
							new MyDialog(stage,"该用户名不存在" , 0);
						}else if(resultMessage == ResultMessage.wrongPassword)
						{
							new MyDialog(stage, "用户名或密码错误", 1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
				
			}
			
		}
		
		@FXML
		private void enroll()
		{
			stage.setScene(new EnrollUserPageNew(new Group(),stage, loginPageScene));
		}
		
		@FXML
		private void secondLogin()
		{
			stage.setScene(new FirstPageUI(new Group(), stage,null, false));
		}
		
		@FXML
		private void findPassword()
		{
			stage.setScene(new FindPasswordPageUINew(new Group(),stage,loginPageScene));
		}
		
		@FXML
		private void exit()
		{
			userInfoService.logout();
			stage.close();
		}
}
