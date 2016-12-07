package presentation.view.customerui.customerui;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PersonInfoPageFirstController {
	@FXML private Button backButton;
	@FXML private Button editImageButton;
	@FXML private Button vipEnrollButton;
	@FXML private ImageView headImage;
	@FXML private Label creditValueLabel;
	@FXML private TextField nameField;
	@FXML private DatePicker yearPicker;
	@FXML private TextField numberField;
	@FXML private TextField infoField;
	
	
	private Stage stage;
	private Scene preScene;
	private Scene presentScene;
	
	public void init(Stage stage, Scene preScene, Scene presentScene)
	{
		this.stage = stage;
		this.preScene = preScene;
		this.presentScene = presentScene;
	}
	
	@FXML
	private void back()
	{
		stage.setScene(preScene);
	}
	
	@FXML
	private void enroll()
	{
		stage.setScene(new EnrollVIPPage(new Group(), stage, presentScene));
	}
	
	@FXML
	private void editImage()
	{
		
	}
}
