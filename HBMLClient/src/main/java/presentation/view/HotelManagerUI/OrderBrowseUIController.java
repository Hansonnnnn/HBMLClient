package presentation.view.HotelManagerUI;

import businesslogic.hotelInfobl.HotelWebManagerImpl;
import businesslogic.orderbl.OrderStaffServiceImpl;
import businesslogic.roomInfobl.RoomInfoStaffServiceImpl;
import businesslogicservice.hotelinfoblservice.HotelWebManagerService;
import businesslogicservice.orderblservice.OrderStaffService;
import businesslogicservice.roominfoblservice.RoomInfoStaffService;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.Duration;
import message.OrderStateMessage;
import message.RoomStateMessage;
import vo.HotelVO;
import vo.OrderVO;
import vo.UserVO;


/**
 * Created by LENOVO on 2016/12/1.
 */
public class OrderBrowseUIController {

    /**
     * 酒店订单列表
     */
    @FXML private TableView unexecutedOrderTableView;
    @FXML private TableColumn unexecutedCustomerNameTableColumn;
    @FXML private TableColumn unexecutedOrderIdTableColumn;
    @FXML private TableColumn unexecutedPriceTableColumn;
    @FXML private TableColumn unexecutedOperationTableColumn;

    @FXML private Label orderBottomLabel;



    private ObservableList unexecutedData;
    private ObservableList executedData;
    private ObservableList abnormalData;
    private ObservableList cancelledData;
    private VBox infoVBox;
    private VBox thisVBox;
    private UserVO userVO;
    private HotelVO hotelVO;
    private HotelWebManagerService hotelWebManagerService;
    private OrderStaffService orderStaffService;
    private RoomInfoStaffService roomInfoStaffService;
    public void init(VBox infoVBox, VBox thisVBox, UserVO userVO){
        this.infoVBox=infoVBox;
        this.thisVBox=thisVBox;
        this.userVO=userVO;
        hotelWebManagerService=new HotelWebManagerImpl();
        hotelVO=hotelWebManagerService.getHotelInfo(userVO.getHotelid());
        orderStaffService=new OrderStaffServiceImpl();
        roomInfoStaffService=new RoomInfoStaffServiceImpl();
        initTableView();
    }


    /**
     * 点击未执行订单按钮，显示未执行订单列表
     */
    @FXML
    private void toUnexecutedOrder(){
        moveOrderButtonBottomBorder(orderBottomLabel,90);
        addUnexecutedOrder();
    }
    private void addUnexecutedOrder(){
        unexecutedOperationTableColumn.setCellFactory(new Callback<TableColumn<OrderVO,Boolean>, TableCell<OrderVO,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new HotelOrderOperationButtonCell(infoVBox,thisVBox,0);
            }
        });
        unexecutedData=FXCollections.observableArrayList();
        if(orderStaffService.getUnexecutedOrderList(hotelVO.getId())!=null){
            for(OrderVO orderVO:orderStaffService.getUnexecutedOrderList(hotelVO.getId()).values()){
                unexecutedData.add(orderVO);
            }
        }
        unexecutedOrderTableView.setItems(unexecutedData);
    }

    /**
     * 点击已执行订单按钮,显示已执行订单列表
     */
    @FXML
    private void toExecutedOrder(){
        moveOrderButtonBottomBorder(orderBottomLabel,210);
        addExceutedOrder();
    }

    private void addExceutedOrder(){
        unexecutedOperationTableColumn.setCellFactory(new Callback<TableColumn<OrderVO,Boolean>, TableCell<OrderVO,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new HotelOrderOperationButtonCell(infoVBox,thisVBox,1);
            }
        });
        executedData=FXCollections.observableArrayList();
        if(orderStaffService.getExecutedOrderList(hotelVO.getId())!=null){
            for(OrderVO orderVO:orderStaffService.getExecutedOrderList(hotelVO.getId()).values()){
                executedData.add(orderVO);
            }
        }
        unexecutedOrderTableView.setItems(executedData);
    }

    /**
     * 点击异常订单按钮,显示异常订单列表
     */
    @FXML
    private void toAbnormalOrder(){
        moveOrderButtonBottomBorder(orderBottomLabel,330);
        addAbnormalOrder();
    }
    private void addAbnormalOrder(){
        unexecutedOperationTableColumn.setCellFactory(new Callback<TableColumn<OrderVO,Boolean>, TableCell<OrderVO,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new HotelOrderOperationButtonCell(infoVBox,thisVBox,2);
            }
        });
        abnormalData=FXCollections.observableArrayList();
        if(orderStaffService.getAbnormalOrderList(hotelVO.getId())!=null){
            for(OrderVO orderVO:orderStaffService.getAbnormalOrderList(hotelVO.getId()).values()){
                abnormalData.add(orderVO);
            }
        }
        unexecutedOrderTableView.setItems(abnormalData);
    }

    /**
     * 点击已撤销订单按钮,显示已撤销订单列表
     */
    @FXML
    private void toCancelledOrder(){
        moveOrderButtonBottomBorder(orderBottomLabel,450);
        addCancelledOrder();
    }

    private void addCancelledOrder(){
        unexecutedOperationTableColumn.setCellFactory(new Callback<TableColumn<OrderVO,Boolean>, TableCell<OrderVO,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new HotelOrderOperationButtonCell(infoVBox,thisVBox,3);
            }
        });
        cancelledData=FXCollections.observableArrayList();
        if(orderStaffService.getCancelledOrderList(hotelVO.getId())!=null){
            for(OrderVO orderVO:orderStaffService.getCancelledOrderList(hotelVO.getId()).values()){
                cancelledData.add(orderVO);
            }
        }
        unexecutedOrderTableView.setItems(cancelledData);
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
        if(orderStaffService.getUnexecutedOrderList(hotelVO.getId())!=null){
            for(OrderVO orderVO:orderStaffService.getUnexecutedOrderList(hotelVO.getId()).values()){
                unexecutedData.add(orderVO);
            }
        }
        unexecutedOrderTableView.setItems(unexecutedData);
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
                int seletedIndex=getTableRow().getIndex();
                OrderVO orderVO=(OrderVO)unexecutedOrderTableView.getItems().get(seletedIndex);
                infoVBox.getChildren().add(new HotelOrderInfoUI(infoVBox,beforeVBox,orderVO));
            });
            executeButton.setOnAction((ActionEvent e)->{
                int seletedIndex=getTableRow().getIndex();
                OrderVO orderVO=(OrderVO)unexecutedOrderTableView.getItems().get(seletedIndex);
                orderStaffService.executeOrder(orderVO.getOrderID());
                addUnexecutedOrder();
                unexecutedOrderTableView.refresh();
            });
            checkOutButton.setOnAction((ActionEvent e)->{
                int seletedIndex=getTableRow().getIndex();
                OrderVO orderVO=(OrderVO)unexecutedOrderTableView.getItems().get(seletedIndex);
                roomInfoStaffService.modifyRoomState(orderVO.getRoomInfoID(), RoomStateMessage.Blank);
                checkOutButton.setVisible(false);
            });
            fillButton.setOnAction((ActionEvent e)->{
                int seletedIndex=getTableRow().getIndex();
                OrderVO orderVO=(OrderVO)unexecutedOrderTableView.getItems().get(seletedIndex);
                orderStaffService.executeOrder(orderVO.getOrderID());
                addAbnormalOrder();
                unexecutedOrderTableView.refresh();
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
