package presentation.view.WebManagerUI;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 * Created by LENOVO on 2016/11/29.
 */
public class WebManagerUIController {
    @FXML private Button addHotelButton;
    @FXML private Button addMarketerButton;
    @FXML private Button userInfoButton;
    @FXML private Button staffInfoButton;
    @FXML private Button marketerInfoButton;
    @FXML private VBox infoVBox;

    private Stage stage;
    private Scene beforeScene;
    public void init(Stage stage,Scene beforeScene){
        this.stage=stage;
        this.beforeScene=beforeScene;
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new AddHotelUI());
        addHotelButton.setStyle("-fx-background-color: #0080FF");
    }

    /**
     * 点击注销按钮，返回登录界面
     */
    @FXML
    private void backToLogin(){
        stage.setScene(beforeScene);
    }

    /**
     * 点击添加酒店按钮，跳转至酒店添加界面
     */
    @FXML
    private void toAddHotel(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new AddHotelUI());
        addHotelButton.setStyle("-fx-background-color:#0080FF");
        addMarketerButton.setStyle("-fx-background-color:transparent");
        userInfoButton.setStyle("-fx-background-color:transparent");
        staffInfoButton.setStyle("-fx-background-color:transparent");
        marketerInfoButton.setStyle("-fx-background-color:transparent");
//        buttonBackground(addMarketerButton);
//        buttonBackground(userInfoButton);
//        buttonBackground(staffInfoButton);
//        buttonBackground(marketerInfoButton);
    }

    /**
     * 点击用户信息管理界面，跳转至用户信息管理界面
     */
    @FXML
    private void toUserInfo(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new UserInfoUI());
        addHotelButton.setStyle("-fx-background-color:transparent");
        addMarketerButton.setStyle("-fx-background-color:transparent");
        staffInfoButton.setStyle("-fx-background-color:transparent");
        marketerInfoButton.setStyle("-fx-background-color:transparent");
//        buttonBackground(addHotelButton);
//        buttonBackground(addMarketerButton);
//        buttonBackground(staffInfoButton);
//        buttonBackground(marketerInfoButton);
        userInfoButton.setStyle("-fx-background-color:#0080FF");
    }

    /**
     * 点击网站营销人员信息管理按钮，跳转至对应界面
     */
    @FXML
    private void toWebMarketerInfo(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new WebMarketerInfoUI());
        addHotelButton.setStyle("-fx-background-color:transparent");
        addMarketerButton.setStyle("-fx-background-color:transparent");
        userInfoButton.setStyle("-fx-background-color:transparent");
        staffInfoButton.setStyle("-fx-background-color:transparent");
//        buttonBackground(addHotelButton);
//        buttonBackground(addMarketerButton);
//        buttonBackground(userInfoButton);
//        buttonBackground(staffInfoButton);
        marketerInfoButton.setStyle("-fx-background-color:#0080FF");
    }

    /**
     * 点击酒店工作人员信息管理按钮，跳转至对应界面
     */
    @FXML
    private void toHotelStuffInfo(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new SearchHotelStaffUI(infoVBox));
        addHotelButton.setStyle("-fx-background-color:transparent");
        addMarketerButton.setStyle("-fx-background-color:transparent");
        userInfoButton.setStyle("-fx-background-color:transparent");
        marketerInfoButton.setStyle("-fx-background-color:transparent");
//        buttonBackground(addHotelButton);
//        buttonBackground(addMarketerButton);
//        buttonBackground(userInfoButton);
//        buttonBackground(marketerInfoButton);
        staffInfoButton.setStyle("-fx-background-color:#0080FF");
    }

    /**
     * 点击添加网站营销人员按钮，跳转至对应界面
     */
    @FXML
    private void toAddWebMarketer(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new AddWebMarketerUI());
        addHotelButton.setStyle("-fx-background-color:transparent");
        userInfoButton.setStyle("-fx-background-color:transparent");
        staffInfoButton.setStyle("-fx-background-color:transparent");
        marketerInfoButton.setStyle("-fx-background-color:transparent");
//        buttonBackground(addHotelButton);
//        buttonBackground(userInfoButton);
//        buttonBackground(staffInfoButton);
//        buttonBackground(marketerInfoButton);
        addMarketerButton.setStyle("-fx-background-color:#0080FF");
    }

    /**
     * 当鼠标移到按钮上时，背景变为蓝色
     */
    private void buttonBackground(Button button){
        button.setOnMouseEntered((MouseEvent e)->{
            button.setStyle("-fx-background-color: #0080FF");
        });
//        button.setOnMouseExited((MouseEvent e)->{
//            button.setStyle("-fx-background-color: #BEBEBE");
//        });
    }

}
