package presentation.view.customerui.customerui;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FindPasswordPageUINewController {
		@FXML private Button findPasswordButton;
		@FXML private Button backButton;
		private Stage stage;
		private Scene preScene;
		
		public void init(Stage stage, Scene preScene)
		{
			this.preScene = preScene;
			this.stage = stage;
		}
		
		@FXML
		private void back()
		{
			stage.setScene(preScene);
		}
		@FXML 
		private void findPassword()
		{
			stage.setScene(new FindPasswordPageUINew(new Group(), stage, preScene));
		}
		
}
