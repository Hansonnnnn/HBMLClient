package presentation.view.HotelManagerUI;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by LENOVO on 2016/11/25.
 */
public class HotelOrderInfoUIController {

    @FXML private Label userLabel;
    @FXML private Button cancelButton;

    @FXML private Label customerLabel;
    @FXML private VBox customerVBox;
    @FXML private Label nameLabel;
    @FXML private Label userIdLabel;
    @FXML private Label phoneLabel;

    @FXML private Label orderIDLabel;
    @FXML private Label orderStartLabel;
    @FXML private Label orderRevokeLabel;
    @FXML private Label orderStateLabel;
    @FXML private Label orderPriceLabel;
    @FXML private Label roomInLabel;
    @FXML private Label roomOutLabel;

    @FXML private Label roomIDLabel;
    @FXML private Label roomTypeLabel;
    @FXML private Label checkInNumberLabel;
    @FXML private Label havaChildLabel;

    @FXML private Button backButton;
    @FXML private Button operationButton;
    @FXML private Button revokeButton;

    private Stage stage;
    private Scene beforeScene;
    private Scene loginScene;

    public void getScene(Stage stage,Scene beforeScene,Scene loginScene){
        this.stage=stage;
        this.beforeScene=beforeScene;
        this.loginScene=loginScene;
    }


    @FXML
    private void back(){
        stage.setScene(beforeScene);
    }

    @FXML
    private void backToLogin(){
        stage.setScene(loginScene);
    }




}
