package presentation.view.customerui.customerui;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPageUIController 
{
	@FXML private TextField nameField;
	@FXML private PasswordField passwordField;
	@FXML private Button enrollButton;
	@FXML private Button loginButton;
	
	private Stage stage;
	private Scene loginScene;

	private FirstPageUIController controller;
	
	public void init(Stage stage, Scene loginScene, FirstPageUIController controller)
	{
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
		}
		if(passwordField.getText()!=null&&!passwordField.getText().isEmpty())
		{
			password = passwordField.getText();
		}
		//bl层来检查用户名和密码是否匹配
		//如果
		
		
		controller.setState(true, name);
		stage.close();
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
		stage.setScene(new FindPasswordPageUI(new Group()));
	}
//	private void createUser(String userName, String )
//	{
//		
//	}
}
