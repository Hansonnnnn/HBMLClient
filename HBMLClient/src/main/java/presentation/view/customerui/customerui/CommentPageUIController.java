package presentation.view.customerui.customerui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CommentPageUIController {
		@FXML private Button backButton;
		@FXML private Button uncommentedButton; 
		@FXML private Button commentedButton;
		@FXML private VBox contentBox;
		@FXML private TableView list;
		
		private Stage stage;
		private Scene preScene;
		private Scene thisPage;
		
		public void init(Stage stage, Scene preScene,Scene thisPage)
		{
			this.stage = stage;
			this.preScene = preScene;
			this.thisPage = thisPage;
		}
		
		@FXML
		private void back()
		{
			stage.setScene(preScene);
		}
		
		@FXML
		private void firstAction()
		{
			contentBox.getChildren().remove(0);
			contentBox.getChildren().add(new CommentedHotelListPage(stage,thisPage));
		}
		
		@FXML 
		private void secondAction()
		{
			contentBox.getChildren().remove(0);
			contentBox.getChildren().add(new UnCommentedHotelListPage(stage,thisPage));
		}
}
