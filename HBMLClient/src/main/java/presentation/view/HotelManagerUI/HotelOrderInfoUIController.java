package presentation.view.HotelManagerUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Created by LENOVO on 2016/11/25.
 */
public class HotelOrderInfoUIController {

    @FXML private Label customerLabel;
    @FXML private VBox customerVBox;
    @FXML private Label nameLabel;
    @FXML private Label userIdLabel;
    @FXML private Label phoneLabel;

    @FXML private Label orderIDLabel;
    @FXML private Label orderStartLabel;
    @FXML private Label orderRevokeLabel;
    @FXML private Label orderStateLabel;
    @FXML private Label orderPriceLabel;
    @FXML private Label roomInLabel;
    @FXML private Label roomOutLabel;

    @FXML private Label roomIDLabel;
    @FXML private Label roomTypeLabel;
    @FXML private Label checkInNumberLabel;
    @FXML private Label havaChildLabel;




    private VBox infoVBox;
    private VBox beforeVBox;
    public void getScene(VBox infoVBox,VBox beforeVBox){
        this.infoVBox=infoVBox;
        this.beforeVBox=beforeVBox;
    }

    /**
     * 点击返回按钮,返回到上一个界面
     */
    @FXML
    private void back(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(beforeVBox);
    }

}
