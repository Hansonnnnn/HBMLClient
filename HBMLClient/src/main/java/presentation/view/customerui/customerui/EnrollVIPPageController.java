package presentation.view.customerui.customerui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EnrollVIPPageController {
	@FXML private Button backButton;
	@FXML private Button commonVIPButton;
	@FXML private Button companyVIPButton;
	@FXML private TextField nameField;
	@FXML private DatePicker birthPicker;
	@FXML private TextField numberField;
	@FXML private Button enrollButton;
	
	private Stage stage;
	private Scene preScene;
	
	public void init(Stage stage, Scene preScene)
	{
		this.stage = stage;
		this.preScene = preScene;
		
	}
	
	@FXML
	private void back()
	{
		stage.setScene(preScene);
	}
}
