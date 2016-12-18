package presentation.view.customerui.customerui;

import businesslogic.userbl.UserCustomerImpl;
import businesslogicservice.userblservice.UserCustomerService;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import message.ResultMessage;
import presentation.view.application.MyDialog;
import vo.UserVO;

public class LoginPageUIController 
{
	@FXML private TextField nameField;
	@FXML private PasswordField passwordField;
	@FXML private Button enrollButton;
	@FXML private Button loginButton;
	@FXML private Button cancelButton;
	@FXML private Button findPasswordButton;
	private ResultMessage resultMessage;
	
	private Stage stage;
	private Scene loginScene;

	private FirstPageUIController controller;
	private UserVO userVO;
	private UserCustomerService customerService;
	
	public void init(Stage stage, Scene loginScene, FirstPageUIController controller)
	{
		customerService = new UserCustomerImpl();
		resultMessage = ResultMessage.failure;
		this.stage = stage;
		this.loginScene = loginScene;
		this.controller = controller;
	}
	
	
	@FXML
	private void login()
	{
		String name = "";
		String password = "";
		if(nameField.getText()!=null&&!nameField.getText().isEmpty())
		{
			name = nameField.getText();
			try {
				if(customerService.getUserData(name)!=null)
				{
					userVO = customerService.getUserData(name);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		if(passwordField.getText()!=null&&!passwordField.getText().isEmpty())
		{
			password = passwordField.getText();
		}
		//bl层来检查用户名和密码是否匹配
		//如果
		try {
			resultMessage = customerService.login(name, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(resultMessage == ResultMessage.success)
		{
			controller.setState(true, name, userVO.getUserID());
			stage.close();
		}else if(resultMessage == ResultMessage.notexist)
		{
			//显示不存在提示对话框
			new MyDialog(stage,"该用户名不存在" , 0);
		}else
		{
			new MyDialog(stage,"用户名或密码错误" ,1);
		}
	}
	
	@FXML
	private void enroll()
	{
		stage.setScene(new EnrollUserPage(new Group(), stage, loginScene, controller));
	}
	
	@FXML 
	private void cancel()
	{
		stage.close();
	}
	
	@FXML
	private void findPassword()
	{
		stage.setScene(new FindPasswordPageUI(new Group(),stage,loginScene));
	}
	
}
