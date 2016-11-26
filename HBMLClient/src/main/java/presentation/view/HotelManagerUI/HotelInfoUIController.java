package presentation.view.HotelManagerUI;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by LENOVO on 2016/11/26.
 */
public class HotelInfoUIController {

    @FXML private TextField hotelNameTextField;
    @FXML private ComboBox hotelRegionComboBox;
    @FXML private TextField hotelAddressTextField;
    @FXML private TextArea hotelIntroTextArea;


    private Stage stage;
    private Scene beforeScene;
    private Scene loginScene;
    public void init(Stage stage,Scene beforeScene,Scene loginScene){
        this.stage=stage;
        this.beforeScene=beforeScene;
        this.loginScene=loginScene;
    }

    /**
     * 点击返回按钮，返回到上一个界面
     */
    @FXML
    private void back(){
        stage.setScene(beforeScene);
    }

    /**
     * 点击注销按钮，返回到登录界面
     */
    @FXML
    private void backToLogin(){
        stage.setScene(loginScene);
    }

    /**
     * 点击编辑按钮，编辑酒店信息
     */
    @FXML
    private void editHotelInfo(){
        hotelNameTextField.setEditable(true);
        hotelRegionComboBox.setDisable(false);
        hotelAddressTextField.setEditable(true);
        hotelIntroTextArea.setEditable(true);
    }

    /**
     * 点击确认修改，保存酒店信息
     */
    @FXML
    private void confirmHotelInfo(){
        hotelNameTextField.setEditable(false);
        hotelRegionComboBox.setDisable(true);
        hotelAddressTextField.setEditable(false);
        hotelIntroTextArea.setEditable(false);
    }
}
