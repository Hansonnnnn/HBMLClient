package presentation.view.customerui.customerui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CommentSubmitPageController 
{
		@FXML private Button backButton;
		@FXML private Button submitButton;
		@FXML private TextArea commentArea;
		@FXML private Button submitImageButton;
//		@FXML private 
		private Stage stage;
		private Scene preScene;
		
		public void init(Stage stage, Scene preScene)
		{
			this.stage = stage;
			this.preScene = preScene;
		}
}
