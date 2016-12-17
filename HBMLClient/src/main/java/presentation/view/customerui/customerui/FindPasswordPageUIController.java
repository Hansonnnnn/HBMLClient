package presentation.view.customerui.customerui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FindPasswordPageUIController
{
		@FXML private Button backButton;
		private Stage stage;
		private Scene preScene;
		
		public void init(Stage stage, Scene preScene)
		{
			this.stage =stage;
			this.preScene = preScene;
		}
		
		@FXML
		private void back()
		{
			stage.setScene(preScene);
		}
}
