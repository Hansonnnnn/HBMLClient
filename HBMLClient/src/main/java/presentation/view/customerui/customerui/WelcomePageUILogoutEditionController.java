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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import vo.UserVO;

/**
 * 登出界面的controller
 * @author xiezhenyu
 *
 */
public class WelcomePageUILogoutEditionController 
{
		@FXML private Button backFirstPageButton;
		@FXML private Button logoutButton;
		@FXML private Label nameLabel;
		@FXML private ImageView imageView;
		private Stage stage;
		private Scene preScene;
		private FirstPageUIController controller;
		private UserVO userVO;
		private UserInfoService cUserInfoService;
		private UserLogService cLogService;
		
		/**
		 * 初始化配置信息，设置头像，初始化BL层服务的对象的实例
		 * @param stage
		 * @param preScene
		 * @param controller
		 * @param userVO
		 */
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
		
		//登出事件的事件响应
		@FXML 
		private void logout()
		{
			cLogService.logout(userVO.getAccountName());
			controller.setState(false);
			cUserInfoService.logout();
			stage.setScene(new WelcomePageUI(new Group(), stage));
		}
		
		//返回事件的事件响应
		@FXML
		private void back()
		{
			stage.setScene(preScene);
		}
}
