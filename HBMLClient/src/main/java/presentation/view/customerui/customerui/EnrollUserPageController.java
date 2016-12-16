package presentation.view.customerui.customerui;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EnrollUserPageController
{
		@FXML private TextField nameField;
		@FXML private TextField passwordField;
		@FXML private Button enrollButton;
		
		private Stage stage;
		private Scene preScene;
		FirstPageUIController controller;
		
		public void init(Stage stage, Scene preScene, FirstPageUIController controller)
		{
			this.stage = stage;
			this.preScene = preScene;
			this.controller = controller;
		}
		
		@FXML
		private void enroll()
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
			//通过bl层方法，来创建该用户
			
			
			
			
			//切换个人信息中心界面
			controller.setState(true, name);
			stage.close();
		}
}
