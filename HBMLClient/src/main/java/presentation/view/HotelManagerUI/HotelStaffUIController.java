package presentation.view.HotelManagerUI;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Created by LENOVO on 2016/12/1.
 */
public class HotelStaffUIController {

    @FXML private Button orderBrowseButton;
    @FXML private Button inputRoomButton;
    @FXML private Button updateRoomButton;
    @FXML private Button hotelInfoButton;
    @FXML private Button hotelPromotionButton;

    private Stage stage;
    private Scene thisScene;
    private Scene loginScene;
    public void init(Stage stage,Scene thisScene,Scene loginScene){
        this.stage=stage;
        this.thisScene=thisScene;
        this.loginScene=loginScene;
        initButton();
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
        stage.setScene(new OrderBrowseUI(new Group(),stage,thisScene,loginScene));
    }

    /**
     * 点击录入可用客房按钮,跳转至对应界面
     */
    @FXML
    private void toInputRoom(){
        stage.setScene(new InputRoomUI(new Group(),stage,thisScene,loginScene));
    }

    /**
     * 点击更新入住/退房信息,跳转至对应界面
     */
    @FXML
    private void toUpdateRoom(){
        stage.setScene(new UpdateRoomUI(new Group(),stage,thisScene,loginScene));
    }

    /**
     * 点击录入酒店信息按钮，跳转至对应界面
     */
    @FXML
    private void toHotelInfo(){
        stage.setScene(new HotelInfoUI(new Group(),stage,thisScene,loginScene));
    }

    /**
     * 点击制定促销策略按钮，跳转至对应界面
     */
    @FXML
    private void toHotelPromotion(){
        stage.setScene(new HotelPromotionUI(new Group(),stage,thisScene,loginScene));
    }

    /**
     * 鼠标移动到组件上时，组件变大
     */
    private void toLarger(Node node){
        node.setOnMouseEntered((MouseEvent e)->{
            node.setScaleX(1.2);
            node.setScaleY(1.2);
        });
        node.setOnMouseExited((MouseEvent e)->{
            node.setScaleX(1.0);
            node.setScaleY(1.0);
        });
    }

    /**
     * 初始化操作按钮
     */
    private void initButton(){
        toLarger(orderBrowseButton);
        toLarger(inputRoomButton);
        toLarger(updateRoomButton);
        toLarger(hotelInfoButton);
        toLarger(hotelPromotionButton);
    }

}
