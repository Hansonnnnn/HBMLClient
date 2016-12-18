package presentation.view.WebManagerUI;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;


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
    @FXML private Label sliderLabel;

    private Stage stage;
    private Scene beforeScene;
    public void init(Stage stage,Scene beforeScene){
        this.stage=stage;
        this.beforeScene=beforeScene;
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new AddHotelUI(stage));
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
        infoVBox.getChildren().add(new AddHotelUI(stage));
        moveOperationButtonBackground(sliderLabel,160);
    }

    /**
     * 点击用户信息管理界面，跳转至用户信息管理界面
     */
    @FXML
    private void toUserInfo(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new UserInfoUI());
        moveOperationButtonBackground(sliderLabel,202);
    }

    /**
     * 点击添加网站营销人员按钮，跳转至对应界面
     */
    @FXML
    private void toAddWebMarketer(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new AddWebMarketerUI(stage));
        moveOperationButtonBackground(sliderLabel,244);
    }

    /**
     * 点击网站营销人员信息管理按钮，跳转至对应界面
     */
    @FXML
    private void toWebMarketerInfo(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new WebMarketerInfoUI());
        moveOperationButtonBackground(sliderLabel,286);
    }

    /**
     * 点击酒店工作人员信息管理按钮，跳转至对应界面
     */
    @FXML
    private void toHotelStuffInfo(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new SearchHotelStaffUI(infoVBox,stage));
        moveOperationButtonBackground(sliderLabel,328);
    }



    /**
     * 设置按钮背景色滑动效果
     */
    private void moveOperationButtonBackground(Label label, double y){
        Timeline timeline=new Timeline();
        timeline.setAutoReverse(false);
        KeyValue newY=new KeyValue(label.layoutYProperty(),y);
        KeyFrame kf=new KeyFrame(Duration.millis(300),newY);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }



}
