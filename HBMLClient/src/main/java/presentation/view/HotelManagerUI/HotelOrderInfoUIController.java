package presentation.view.HotelManagerUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import vo.OrderVO;

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
    private OrderVO orderVO;
    public void getScene(VBox infoVBox, VBox beforeVBox, OrderVO orderVO){
        this.infoVBox=infoVBox;
        this.beforeVBox=beforeVBox;
        this.orderVO=orderVO;
        init();
    }

    /**
     * 点击返回按钮,返回到上一个界面
     */
    @FXML
    private void back(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(beforeVBox);
    }

    /**
     * 将订单信息写入
     */
    private void init(){
        userIdLabel.setText(String.valueOf(orderVO.getUserID()));
//        phoneLabel.setText(orderVO.get);
        orderIDLabel.setText(String.valueOf(orderVO.getOrderID()));


        roomIDLabel.setText(String.valueOf(orderVO.getRoomInfoID()));
//        roomTypeLabel.setText(String.valueOf(orderVO.get));
        checkInNumberLabel.setText(String.valueOf(orderVO.getNumber()));
    }

}
