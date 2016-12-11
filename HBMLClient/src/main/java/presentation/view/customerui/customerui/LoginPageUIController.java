package presentation.view.customerui.customerui;

import javafx.fxml.FXML;
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
//	private Scene preScene;
//	
	public void init(Stage stage)
	{
		this.stage = stage;
//		this.preScene = preScene;
	}
	
	
	@FXML
	private void login()
	{
		stage.close();
	}
	
	@FXML
	private void enroll()
	{
		
	}
	
//	private void createUser(String userName, String )
//	{
//		
//	}
}
