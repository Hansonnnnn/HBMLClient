package presentation.view.customerui.customerui;

import businesslogic.userbl.UserCustomerImpl;
import businesslogic.userbl.UserLogImpl;
import businesslogic.utility.UserInfoImpl;
import businesslogicservice.UserInfoService;
import businesslogicservice.userblservice.UserCustomerService;
import businesslogicservice.userblservice.UserLogService;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.UserType;
import presentation.view.application.MyDialog;
import vo.UserVO;

public class EnrollUserPageNewController {
	@FXML private TextField nameField;
	@FXML private PasswordField passwordField;
	@FXML private Button enrollButton;
	@FXML private Button backButton;
	
	
	private Stage stage;
	private Scene preScene;
	
	private UserVO userVO;
	private UserCustomerService customerService;
	private UserLogService userLogService;

	private UserInfoService userInfoService;
	
	public void init(Stage stage, Scene preScene)
	{
		this.stage = stage;
		this.preScene = preScene;
		customerService = new UserCustomerImpl();
		userLogService=new UserLogImpl();
		userInfoService = new UserInfoImpl();
	}
	
	@FXML
	private void back()
	{
		stage.setScene(preScene);
	}
	
	@FXML
	private void enroll()
	{
		String name = "";
		String password = "";
		if(nameField.getText()!=null&&!nameField.getText().isEmpty())
		{
			name = nameField.getText();
			userInfoService.saveLocalUserInfo(name);
		}
		if(passwordField.getText()!=null&&!passwordField.getText().isEmpty())
		{
			password = passwordField.getText();
		}
		//通过bl层方法，来创建该用户
		if(name.equals("")&&password.equals(""))
		{
			new MyDialog(stage, "请输入用户名和密码", 1);
		}else
		{
			try {
				userLogService.signup(new UserVO(UserType.Customer, name, password));
				new MyDialog(stage, "恭喜您注册成功！", 2);
				userVO = customerService.getUserData(name);
				//切换个人信息中心界面
//				controller.setState(true, name,userVO.getUserID());
				stage.setScene(new FirstPageUI(new Group(), stage, userVO, true));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
