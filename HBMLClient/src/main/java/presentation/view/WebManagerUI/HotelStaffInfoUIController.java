package presentation.view.WebManagerUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import javax.xml.soap.Text;

/**
 * Created by LENOVO on 2016/11/29.
 */
public class HotelStaffInfoUIController {

    @FXML private TextField seekStaffIdTextField;
    @FXML private Label tipLabel;
    @FXML private VBox infoVBox;
    @FXML private TextField staffIdTextField;
    @FXML private TextField staffAccountTextField;
    @FXML private TextField staffPasswordTextField;
    @FXML private TextField staffNameTextField;
    @FXML private TextField staffHotelNameTextField;
    @FXML private TextField staffPhoneTextField;
    public void init(){

    }

    /**
     * 点击搜索按钮，显示酒店工作人员信息
     */
    @FXML
    private void seekStaffInfo(){
        if(seekStaffIdTextField.getText().equals("01")){
            infoVBox.setVisible(true);
            tipLabel.setVisible(false);
        }else{
            infoVBox.setVisible(false);
            tipLabel.setVisible(true);
        }
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
