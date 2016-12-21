package presentation.view.customerui.customerui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vo.UserVO;

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
	private UserVO userVO;
	
	public void init(Stage stage, Scene preScene, UserVO userVO)
	{
		this.stage = stage;
		this.preScene = preScene;
		this.userVO = userVO;
	}
	
	@FXML
	private void back()
	{
		stage.setScene(preScene);
	}
}
