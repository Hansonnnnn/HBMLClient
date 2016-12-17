package presentation.view.customerui.customerui;
import businesslogic.userbl.UserCustomerImpl;
import businesslogicservice.userblservice.UserCustomerService;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.UserType;
import presentation.view.application.MyDialog;
import vo.UserVO;

public class EnrollUserPageController
{
		@FXML private TextField nameField;
		@FXML private TextField passwordField;
		@FXML private Button enrollButton;
		@FXML private Button backButton;
		
		private Stage stage;
		private Scene preScene;
		FirstPageUIController controller;
		private UserCustomerService service;
		
		public void init(Stage stage, Scene preScene, FirstPageUIController controller)
		{
			this.stage = stage;
			this.preScene = preScene;
			this.controller = controller;
			service = new UserCustomerImpl();
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
			if(name.equals("")&&password.equals(""))
			{
				new MyDialog(stage, "请输入用户名和密码", 1);
			}else
			{
//				service.signup(new UserVO(UserType.Customer, password, name));
			}
			
			
			//切换个人信息中心界面
			controller.setState(true, name);
			stage.close();
		}
		
		@FXML 
		private void enrollPageBack()
		{
			stage.setScene(preScene);
		}
		
		@FXML 
		private void back()
		{
			stage.setScene(preScene);
		}
}
