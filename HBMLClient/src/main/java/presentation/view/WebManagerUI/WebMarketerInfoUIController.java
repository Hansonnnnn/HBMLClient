package presentation.view.WebManagerUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;



/**
 * Created by LENOVO on 2016/11/29.
 */
public class WebMarketerInfoUIController {

    @FXML private TextField seekMarketerIdTextField;
    @FXML private Label tipLabel;
    @FXML private VBox infoVBox;
    @FXML private TextField marketerIdTextField;
    @FXML private TextField marketerAccountTextField;
    @FXML private TextField marketerPasswordTextField;
    @FXML private TextField marketerNameTextField;
    @FXML private TextField marketerPhoneTextField;

    public void init(){

    }

    /**
     * 点击编辑按钮,编辑网站营销人员信息
     */
    @FXML
    private void edit(){
        marketerIdTextField.setDisable(false);
        marketerAccountTextField.setDisable(false);
        marketerPasswordTextField.setDisable(false);
        marketerNameTextField.setDisable(false);
        marketerPhoneTextField.setDisable(false);
    }

    /**
     * 点击确认修改按钮,保存信息
     */
    @FXML
    private void confirm(){
        marketerIdTextField.setDisable(true);
        marketerAccountTextField.setDisable(true);
        marketerPasswordTextField.setDisable(true);
        marketerNameTextField.setDisable(true);
        marketerPhoneTextField.setDisable(true);
    }

    /**
     * 点击搜索按钮,显示网站营销人员信息
     */
    @FXML
    private void seekMarketerInfo(){
        if(seekMarketerIdTextField.getText().equals("11")){
            infoVBox.setVisible(true);
            tipLabel.setVisible(false);
        }else{
            infoVBox.setVisible(false);
            tipLabel.setVisible(true);
        }
    }
}
