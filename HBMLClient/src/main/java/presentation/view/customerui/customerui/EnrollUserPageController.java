package presentation.view.customerui.customerui;
import businesslogic.userbl.UserCustomerImpl;
import businesslogic.userbl.UserLogImpl;
import businesslogicservice.userblservice.UserCustomerService;
import businesslogicservice.userblservice.UserLogService;
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
		private UserVO userVO;
		private UserCustomerService customerService;
		private UserLogService userLogService;
		
		public void init(Stage stage, Scene preScene, FirstPageUIController controller)
		{
			this.stage = stage;
			this.preScene = preScene;
			this.controller = controller;
			customerService = new UserCustomerImpl();
			userLogService=new UserLogImpl();
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
				try {
					System.out.println("*****************");
					userLogService.signup(new UserVO(UserType.Customer, name, password));
					
					userVO = customerService.getUserData(name);
					System.out.println(userVO.getUserID());
					//切换个人信息中心界面
					controller.setState(true, name,userVO.getUserID());
					stage.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
