package presentation.view.customerui.customerui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CommentPageUIController {
		@FXML private Button backButton;
		@FXML private Button uncommentedButton; 
		@FXML private Button commentedButton;
		@FXML private VBox contentBox;
		
		private Stage stage;
		private Scene preScene;
		private Scene thisPage;
		private int userID;
		
		public void init(Stage stage, Scene preScene,Scene thisPage,int userID)
		{
			this.stage = stage;
			this.preScene = preScene;
			this.thisPage = thisPage;
			this.userID = userID;
			contentBox.getChildren().add(new CommentedHotelListPage(stage, thisPage,userID));
		}
		
		@FXML
		private void back()
		{
			stage.setScene(preScene);
		}
		
}
