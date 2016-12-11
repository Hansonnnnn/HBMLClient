package presentation.view.HotelManagerUI;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by LENOVO on 2016/12/1.
 */
public class HotelStaffUIController {

    @FXML private VBox infoVBox;

    private Stage stage;
    private Scene loginScene;
    public void init(Stage stage,Scene loginScene){
        this.stage=stage;
        this.loginScene=loginScene;
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
    }

    /**
     * 点击录入可用客房按钮,跳转至对应界面
     */
    @FXML
    private void toInputRoom(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new InputRoomUI(infoVBox));
    }

    /**
     * 点击录入酒店信息按钮，跳转至对应界面
     */
    @FXML
    private void toHotelInfo(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new HotelInfoUI(stage,infoVBox));
    }

    /**
     * 点击制定促销策略按钮，跳转至对应界面
     */
    @FXML
    private void toHotelPromotion(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new HotelPromotionUI(infoVBox));
    }

}
