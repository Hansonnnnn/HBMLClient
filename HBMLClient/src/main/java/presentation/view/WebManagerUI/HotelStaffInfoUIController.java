package presentation.view.WebManagerUI;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Created by LENOVO on 2016/12/9.
 */
public class HotelStaffinfoUIController {

    @FXML private TextField staffIdTextField;
    @FXML private TextField staffAccountTextField;
    @FXML private TextField staffPasswordTextField;
    @FXML private TextField staffNameTextField;
    @FXML private TextField staffHotelNameTextField;
    @FXML private TextField staffPhoneTextField;

    private VBox infoVBox;
    private VBox beforeVBox;
    public void init(VBox infoVBox,VBox beforeVBox){
        this.infoVBox=infoVBox;
        this.beforeVBox=beforeVBox;
    }

    /**
     * 点击返回按钮
     */
    @FXML
    private void back(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(beforeVBox);
    }

    /**
     * 点击编辑按钮，编辑酒店工作人员信息
     */
    @FXML
    private void edit(){
        staffIdTextField.setDisable(false);
        staffAccountTextField.setDisable(false);
        staffPasswordTextField.setDisable(false);
        staffNameTextField.setDisable(false);
        staffHotelNameTextField.setDisable(false);
        staffPhoneTextField.setDisable(false);
    }

    /**
     * 点击确认修改按钮，保存信息
     */
    @FXML
    private void confirm(){
        staffIdTextField.setDisable(true);
        staffAccountTextField.setDisable(true);
        staffPasswordTextField.setDisable(true);
        staffNameTextField.setDisable(true);
        staffHotelNameTextField.setDisable(true);
        staffPhoneTextField.setDisable(true);
    }
}
