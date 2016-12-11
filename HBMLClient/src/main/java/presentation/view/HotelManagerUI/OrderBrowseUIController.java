package presentation.view.HotelManagerUI;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.Duration;
import message.OrderStateMessage;
import presentation.view.customerui.customerui.OrderVO;
import vo.HotelVO;


/**
 * Created by LENOVO on 2016/12/1.
 */
public class OrderBrowseUIController {

    /**
     * 未执行订单列表
     */
    @FXML private TableView unexecutedOrderTableView;
    @FXML private TableColumn unexecutedCustomerNameTableColumn;
    @FXML private TableColumn unexecutedOrderIdTableColumn;
    @FXML private TableColumn unexecutedPriceTableColumn;
    @FXML private TableColumn unexecutedOperationTableColumn;

    /**
     * 已执行订单列表
     */
    @FXML private TableView executedOrderTableView;
    @FXML private TableColumn executedCustomerNameTableColumn;
    @FXML private TableColumn executedOrderIdTableColumn;
    @FXML private TableColumn executedPriceTableColumn;
    @FXML private TableColumn executedOperationTableColumn;

    /**
     * 异常订单列表
     */
    @FXML private TableView abnormalOrderTableView;
    @FXML private TableColumn abnormalCustomerNameTableColumn;
    @FXML private TableColumn abnormalOrderIdTableColumn;
    @FXML private TableColumn abnormalPriceTableColumn;
    @FXML private TableColumn abnormalOperationTableColumn;

    /**
     * 已撤销订单
     */
    @FXML private TableView cancelledOrderTableView;
    @FXML private TableColumn cancelledCustomerNameTableColumn;
    @FXML private TableColumn cancelledOrderIdTableColumn;
    @FXML private TableColumn cancelledPriceTableColumn;
    @FXML private TableColumn cancelledOperationTableColumn;

    @FXML private Label orderBottomLabel;



    private ObservableList unexecutedData;
    private ObservableList executedData;
    private ObservableList abnormalData;
    private ObservableList cancelledData;
    private VBox infoVBox;
    private VBox thisVBox;
    public void init(VBox infoVBox,VBox thisVBox){
        this.infoVBox=infoVBox;
        this.thisVBox=thisVBox;
        initTableView();
    }


    /**
     * 点击未执行订单按钮，显示未执行订单列表
     */
    @FXML
    private void toUnexecutedOrder(){
        unexecutedOrderTableView.setVisible(true);
        executedOrderTableView.setVisible(false);
        abnormalOrderTableView.setVisible(false);
        cancelledOrderTableView.setVisible(false);
        moveOrderButtonBottomBorder(orderBottomLabel,100);
    }

    /**
     * 点击已执行订单按钮,显示已执行订单列表
     */
    @FXML
    private void toExecutedOrder(){
        unexecutedOrderTableView.setVisible(false);
        executedOrderTableView.setVisible(true);
        abnormalOrderTableView.setVisible(false);
        cancelledOrderTableView.setVisible(false);
        moveOrderButtonBottomBorder(orderBottomLabel,220);
    }

    /**
     * 点击异常订单按钮,显示异常订单列表
     */
    @FXML
    private void toAbnormalOrder(){
        unexecutedOrderTableView.setVisible(false);
        executedOrderTableView.setVisible(false);
        abnormalOrderTableView.setVisible(true);
        cancelledOrderTableView.setVisible(false);
        moveOrderButtonBottomBorder(orderBottomLabel,340);
    }

    /**
     * 点击已撤销订单按钮,显示已撤销订单列表
     */
    @FXML
    private void toCancelledOrder(){
        unexecutedOrderTableView.setVisible(false);
        executedOrderTableView.setVisible(false);
        abnormalOrderTableView.setVisible(false);
        cancelledOrderTableView.setVisible(true);
        moveOrderButtonBottomBorder(orderBottomLabel,460);

    }

    /**
     * 设置按钮下边界滑动效果
     */
    private void moveOrderButtonBottomBorder(Label label,double x){
        Timeline timeline=new Timeline();
        timeline.setAutoReverse(false);
        KeyValue newX=new KeyValue(label.layoutXProperty(),x);
        KeyFrame kf=new KeyFrame(Duration.millis(300),newX);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    /**
     * 初始化hotelOrderTableView
     */
    private void initTableView(){
        unexecutedCustomerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("userID"));
        unexecutedOrderIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        unexecutedPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        unexecutedOperationTableColumn.setCellFactory(new Callback<TableColumn<OrderVO,Boolean>, TableCell<OrderVO,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new HotelOrderOperationButtonCell(infoVBox,thisVBox,0);
            }
        });
        unexecutedData=FXCollections.observableArrayList();
        unexecutedData.add(new OrderVO(000001,00,0,null,0, OrderStateMessage.Unexecuted
        ,null,null,null,null,null,0,0,100));
        unexecutedData.add(new OrderVO(000002,00,0,null,0, OrderStateMessage.Unexecuted
                ,null,null,null,null,null,0,0,100));
        unexecutedOrderTableView.setItems(unexecutedData);

        executedCustomerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("userID"));
        executedOrderIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        executedPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        executedOperationTableColumn.setCellFactory(new Callback<TableColumn<OrderVO,Boolean>, TableCell<OrderVO,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new HotelOrderOperationButtonCell(infoVBox,thisVBox,1);
            }
        });
        executedData=FXCollections.observableArrayList();
        executedData.add(new OrderVO(000003,01,0,null,0, OrderStateMessage.Executed
                ,null,null,null,null,null,0,0,200));
        executedData.add(new OrderVO(000004,01,0,null,0, OrderStateMessage.Executed
                ,null,null,null,null,null,0,0,200));
        executedOrderTableView.setItems(executedData);

        abnormalCustomerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("userID"));
        abnormalOrderIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        abnormalPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        abnormalOperationTableColumn.setCellFactory(new Callback<TableColumn<OrderVO,Boolean>, TableCell<OrderVO,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new HotelOrderOperationButtonCell(infoVBox,thisVBox,2);
            }
        });
        abnormalData=FXCollections.observableArrayList();
        abnormalData.add(new OrderVO(000005,10,0,null,0, OrderStateMessage.Abnormal
                ,null,null,null,null,null,0,0,298));
        abnormalData.add(new OrderVO(000006,10,0,null,0, OrderStateMessage.Abnormal
                ,null,null,null,null,null,0,0,298));
        abnormalOrderTableView.setItems(abnormalData);

        cancelledCustomerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("userID"));
        cancelledOrderIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        cancelledPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        cancelledOperationTableColumn.setCellFactory(new Callback<TableColumn<OrderVO,Boolean>, TableCell<OrderVO,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new HotelOrderOperationButtonCell(infoVBox,thisVBox,3);
            }
        });
        cancelledData=FXCollections.observableArrayList();
        cancelledData.add(new OrderVO(000007,11,0,null,0, OrderStateMessage.Cancelled
                ,null,null,null,null,null,0,0,398));
        cancelledData.add(new OrderVO(0000007,11,0,null,0, OrderStateMessage.Cancelled
                ,null,null,null,null,null,0,0,398));
        cancelledOrderTableView.setItems(cancelledData);
    }


    public class HotelOrderOperationButtonCell extends TableCell<OrderVO,Boolean>{
        private HBox operationHBox=new HBox();
        //查看订单详细信息按钮
        private Button viewButton=new Button();
        //确认入住按钮
        private Button executeButton=new Button();
        //退房按钮
        private Button checkOutButton=new Button();
        //补登记按钮
        private Button fillButton=new Button();
        private ImageView viewImageView=new ImageView(new Image(getClass().getResourceAsStream("ManagerImages/view1.png")));
        private ImageView checkInImageView=new ImageView(new Image(getClass().getResourceAsStream("ManagerImages/checkIn.png")));
        private ImageView checkOutImageView=new ImageView(new Image(getClass().getResourceAsStream("ManagerImages/checkOut.png")));
        private ImageView fillImageView=new ImageView(new Image(getClass().getResourceAsStream("ManagerImages/fill.png")));
        private VBox infoVBox;
        private VBox beforeVBox;
        public HotelOrderOperationButtonCell(VBox infoVBox,VBox beforeVBox,int orderType){
            this.infoVBox=infoVBox;
            this.beforeVBox=beforeVBox;
            viewButton.setStyle("-fx-background-color: transparent");
            viewButton.setGraphic(viewImageView);
            executeButton.setStyle("-fx-background-color: transparent");
            executeButton.setGraphic(checkInImageView);
            checkOutButton.setStyle("-fx-background-color: transparent");
            checkOutButton.setGraphic(checkOutImageView);
            fillButton.setStyle("-fx-background-color:transparent");
            fillButton.setGraphic(fillImageView);

            operationHBox.getChildren().add(viewButton);
            if(orderType==0){
                operationHBox.getChildren().add(executeButton);
            }else if(orderType==1){
                operationHBox.getChildren().add(checkOutButton);
            }else if(orderType==2){
                operationHBox.getChildren().add(fillButton);
            }

            ButtonEvent();
        }

        /**
         * 添加按钮的监听事件
         */
        private void ButtonEvent(){
            viewButton.setOnAction((ActionEvent e)->{
                infoVBox.getChildren().remove(0);
                infoVBox.getChildren().add(new HotelOrderInfoUI(infoVBox,beforeVBox));
            });
            executeButton.setOnAction((ActionEvent e)->{

            });
            checkOutButton.setOnAction((ActionEvent e)->{

            });
            fillButton.setOnAction((ActionEvent e)->{

            });
        }

        @Override
        protected  void updateItem(Boolean t,boolean empty){
            super.updateItem(t,empty);
            if(empty){
                setGraphic(null);
                setText(null);
            }else{
                setGraphic(operationHBox);
                setText(null);
            }
        }
    }
}
