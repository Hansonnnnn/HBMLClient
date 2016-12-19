package presentation.view.HotelManagerUI;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import vo.UserVO;

/**
 * Created by LENOVO on 2016/12/1.
 */
public class HotelStaffUIController {

    @FXML private VBox infoVBox;
    @FXML private Label sliderLabel;
    @FXML private Label nameLabel;

    private Stage stage;
    private Scene loginScene;
    private UserVO userVO;
    public void init(Stage stage, Scene loginScene, UserVO userVO){
        this.stage=stage;
        this.loginScene=loginScene;
        this.userVO=userVO;
        nameLabel.setText(userVO.getName()+",欢迎你");
        infoVBox.getChildren().add(new OrderBrowseUI(infoVBox));
    }

    /**
     * 点击注销按钮，返回到登录界面
     */
    @FXML
    private void backToLogin(){
        stage.setScene(loginScene);
    }

    /**
     * 点击订单浏览/执行按钮,跳转至对应界面
     */
    @FXML
    private void toOrderBrowse(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new OrderBrowseUI(infoVBox));
        moveOperationButtonBackground(sliderLabel,180);
    }

    /**
     * 点击录入可用客房按钮,跳转至对应界面
     */
    @FXML
    private void toInputRoom(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new InputRoomUI(infoVBox,stage));
        moveOperationButtonBackground(sliderLabel,222);
    }

    /**
     * 点击录入酒店信息按钮，跳转至对应界面
     */
    @FXML
    private void toHotelInfo(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new HotelInfoUI(stage,infoVBox));
        moveOperationButtonBackground(sliderLabel,264);
    }

    /**
     * 点击制定促销策略按钮，跳转至对应界面
     */
    @FXML
    private void toHotelPromotion(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new HotelPromotionUI(infoVBox));
        moveOperationButtonBackground(sliderLabel,306);
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
