package presentation.view.customerui.customerui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LogoutPageUIController {
		@FXML private Button backButton;
		@FXML private Button logoutButton;
		
		private Stage stage;
		private Scene preScene;
		private FirstPageUIController controller;
		
		public void init(Stage stage, Scene preScene, FirstPageUIController controller)
		{
			this.stage = stage;
			this.preScene = preScene;
			this.controller = controller;
		}
		
		@FXML
		private void back()
		{
			stage.setScene(preScene);
		}
		
		@FXML
		private void logout()
		{
			controller.setState(false);
			stage.close();
		}
}
