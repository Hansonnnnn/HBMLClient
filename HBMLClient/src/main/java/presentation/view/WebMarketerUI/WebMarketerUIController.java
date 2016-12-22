package presentation.view.WebMarketerUI;

import businesslogic.userbl.UserLogImpl;
import businesslogicservice.userblservice.UserLogService;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import presentation.view.application.UserLoginUI;
import vo.UserVO;

/**
 * Created by LENOVO on 2016/12/1.
 */
public class WebMarketerUIController {


    @FXML private Button exceptionOrderButton;
    @FXML private Button webPromotionButton;
    @FXML private Button regionPromotionButton;
    @FXML private Button memberGradeButton;
    @FXML private Button creditValueButton;
    @FXML private VBox infoVBox;
    @FXML private Label sliderLabel;
    @FXML private Label nameLabel;

    private Stage stage;
    private Scene loginScene;
    private UserVO userVO;
    private UserLogService userLogService;
    public void init(Stage stage, Scene loginScene,UserVO userVO){
        this.stage=stage;
        this.loginScene=loginScene;
        this.userVO=userVO;
        userLogService=new UserLogImpl();
        nameLabel.setText(userVO.getName()+",欢迎你");
        infoVBox.getChildren().add(new ExceptionOrderUI(stage,userVO));
    }

    /**
     * 点击注销按钮，返回到登录界面
     */
    @FXML
    private void backToLogin(){
        stage.setScene(new UserLoginUI(new Group(),stage));
        userLogService.logout(userVO.getAccountName());
    }


    /**
     * 点击异常订单处理按钮,跳转至对应界面
     */
    @FXML
    private void toExceptionOrder(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new ExceptionOrderUI(stage,userVO));
        moveOperationButtonBackground(sliderLabel,160);
    }

    /**
     * 点击网站促销活动指定按钮，跳转至对应界面
     */
    @FXML
    private void toWebPromotion(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new WebPromotionUI(infoVBox,stage));
        moveOperationButtonBackground(sliderLabel,202);
    }

    /**
     * 点击特定商圈折扣制定按钮，跳转至对应界面
     */
    @FXML
    private void toRegionPromotion(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new RegionPromotionUI(stage));
        moveOperationButtonBackground(sliderLabel,244);
    }

    /**
     * 点击会员等级制定，跳转至对应界面
     */
    @FXML
    private void toMemberGrade(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new MemberGradeUI());
        moveOperationButtonBackground(sliderLabel,286);
    }

    /**
     * 点击信用值充值界面,跳转至对应界面
     */
    @FXML
    private void toCreditValue(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new SearchCustomerUI(infoVBox,stage));
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
