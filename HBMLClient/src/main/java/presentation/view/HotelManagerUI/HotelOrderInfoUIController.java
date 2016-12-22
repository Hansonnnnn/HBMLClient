package presentation.view.HotelManagerUI;

import businesslogic.hotelInfobl.HotelStaffImpl;
import businesslogic.userbl.UserWebManagerImpl;
import businesslogicservice.hotelinfoblservice.HotelStaffService;
import businesslogicservice.userblservice.UserWebManagerService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import message.OrderStateMessage;
import model.DateHelper;
import vo.HotelVO;
import vo.OrderVO;
import vo.UserVO;

/**
 * Created by LENOVO on 2016/11/25.
 */
public class HotelOrderInfoUIController {

    @FXML private Label customerIdLabel;
    @FXML private Label customerNameLabel;
    @FXML private Label phoneLabel;

    @FXML private Label orderIDLabel;
    @FXML private Label orderStartLabel;
    @FXML private Label orderRevokeLabel;
    @FXML private Label orderStateLabel;
    @FXML private Label orderPriceLabel;
    @FXML private Label roomInLabel;
    @FXML private Label roomOutLabel;

    @FXML private Label hotelNameLabel;
    @FXML private Label checkInNumberLabel;
    @FXML private Label havaChildLabel;


    private VBox infoVBox;
    private VBox beforeVBox;
    private OrderVO orderVO;
    private HotelStaffService hotelStaffService;
    private UserWebManagerService userWebManagerService;
    private DateHelper dateHelper;
    public void getScene(VBox infoVBox, VBox beforeVBox, OrderVO orderVO){
        this.infoVBox=infoVBox;
        this.beforeVBox=beforeVBox;
        this.orderVO=orderVO;
        hotelStaffService=new HotelStaffImpl();
        userWebManagerService=new UserWebManagerImpl();
        dateHelper=new DateHelper();
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
        UserVO userVO = userWebManagerService.getUserData(orderVO.getUserID());
        HotelVO hotelVO = hotelStaffService.getHotelInfo(orderVO.getHotelID());
        customerIdLabel.setText(String.valueOf(orderVO.getUserID()));
        if(userVO!=null){
            customerNameLabel.setText(userVO.getName());
            phoneLabel.setText(userVO.getContact());
        }

        orderIDLabel.setText(String.valueOf(orderVO.getOrderID()));
        if(orderVO.getGenerateTime()!=null){
            orderStartLabel.setText(dateHelper.dateToString(orderVO.getGenerateTime()));
        }
        if(orderVO.getCancelTime()!=null){
            orderRevokeLabel.setText(dateHelper.dateToString(orderVO.getCancelTime()));
        }
        if(orderVO.getOrderState()== OrderStateMessage.Unexecuted){
            orderStateLabel.setText("未执行");
        }else if(orderVO.getOrderState()==OrderStateMessage.Executed){
            orderStateLabel.setText("已执行");
        }else if(orderVO.getOrderState()==OrderStateMessage.Abnormal){
            orderStateLabel.setText("异常");
        }else if(orderVO.getOrderState()==OrderStateMessage.Cancelled){
            orderStateLabel.setText("已撤销");
        }
        orderPriceLabel.setText(String.valueOf(orderVO.getPrice()));
        if(orderVO.getCheckinTime()!=null){
            roomInLabel.setText(dateHelper.dateToString(orderVO.getCheckinTime()));
        }
        if(orderVO.getCheckoutTime()!=null){
            roomOutLabel.setText(dateHelper.dateToString(orderVO.getCheckoutTime()));
        }

        hotelNameLabel.setText(hotelVO.getName());
        checkInNumberLabel.setText(String.valueOf(orderVO.getNumber()));
        if(orderVO.getHasChild()==1){
            havaChildLabel.setText("有");
        }else{
            havaChildLabel.setText("没有");
        }
    }

}
