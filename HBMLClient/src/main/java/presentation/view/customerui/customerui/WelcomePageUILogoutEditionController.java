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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import vo.UserVO;

public class WelcomePageUILogoutEditionController 
{
		@FXML private Button backFirstPageButton;
		@FXML private Button logoutButton;
		@FXML private Label nameLabel;
		
		private Stage stage;
		private Scene preScene;
		private FirstPageUIController controller;
		private UserVO userVO;
		private UserInfoService cUserInfoService;
		private UserLogService cLogService;
		private ImageView imageView;
	
		public void init(Stage stage, Scene preScene, FirstPageUIController controller, UserVO userVO)
		{
			this.stage = stage;
			this.preScene = preScene;
			this.controller = controller;
			this.userVO = userVO;
			nameLabel.setText(userVO.getAccountName());
			Image  headImage=new Image("file:///"+userVO.getPortrait().getAbsolutePath().replace('\\', '/').replaceAll("HBMLClient/HBMLClient", "Final_HBMSServer/HBMSServer"));
			imageView.setImage(headImage);
			cUserInfoService = new UserInfoImpl();
			cLogService = new UserLogImpl();
		}
		
		@FXML 
		private void logout()
		{
			cLogService.logout(userVO.getAccountName());
			controller.setState(false);
			cUserInfoService.logout();
			stage.setScene(new WelcomePageUI(new Group(), stage));
		}
		
		@FXML
		private void back()
		{
			stage.setScene(preScene);
		}
}
