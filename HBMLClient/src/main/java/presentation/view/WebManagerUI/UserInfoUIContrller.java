package presentation.view.WebManagerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import javax.xml.soap.Text;

/**
 * Created by LENOVO on 2016/11/29.
 */
public class UserInfoUIContrller {

    @FXML private TextField seekIdTextField;
    @FXML private VBox infoVBox;
    @FXML private Label tipLabel;
    @FXML private TextField userIdTextField;
    @FXML private TextField userNameTextField;
    @FXML private TextField userAccountTextField;
    @FXML private TextField userPasswordTextField;
    @FXML private TextField userCreditValueTextField;
    @FXML private TextField userPhoneTextField;
    @FXML private ComboBox memberTypeComboBox;
    @FXML private TextField memberLevelTextField;
    @FXML private TextField memberInfoTextField;


    private ObservableList memberType;
    public void init(){
        initComboBox();
    }

    /**
     * 点击编辑按钮，编辑客户信息
     */
    @FXML
    private void edit(){
        userIdTextField.setDisable(false);
        userNameTextField.setDisable(false);
        userAccountTextField.setDisable(false);
        userPasswordTextField.setDisable(false);
        userPhoneTextField.setDisable(false);
        memberTypeComboBox.setDisable(false);
        memberLevelTextField.setDisable(false);
        memberInfoTextField.setDisable(false);
    }

    /**
     * 初始化memberTypeComboBox
     */
    private void initComboBox(){
        memberType=FXCollections.observableArrayList();
        memberType.add("非会员");
        memberType.add("普通会员");
        memberType.add("企业会员");
        memberTypeComboBox.setItems(memberType);
    }

    /**
     * 点击搜索按钮,显示用户信息
     */
    @FXML
    private void seekUserInfo(){
        if(seekIdTextField.getText().equals("00")){
            infoVBox.setVisible(true);
            tipLabel.setVisible(false);
        }else{
            tipLabel.setVisible(true);
            infoVBox.setVisible(false);
        }
    }

    /**
     * 点击确认修改按钮，保存信息
     */
    @FXML
    private void confirm(){
        userIdTextField.setDisable(true);
        userNameTextField.setDisable(true);
        userAccountTextField.setDisable(true);
        userPasswordTextField.setDisable(true);
        userPhoneTextField.setDisable(true);
        memberTypeComboBox.setDisable(true);
        memberLevelTextField.setDisable(true);
        memberInfoTextField.setDisable(true);
    }
}
