package presentation.view.WebMarketerUI;

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
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

import javax.swing.*;

/**
 * Created by LENOVO on 2016/12/2.
 */
public class ExceptionOrderUIController {

    @FXML private TableView unexecutedTableView;
    @FXML private TableView exceptionOrderTableView;
    @FXML private TableColumn idColumn;
    @FXML private TableColumn nameColumn;
    @FXML private TableColumn startColumn;
    @FXML private TableColumn endColumn;
    @FXML private TableColumn priceColumn;
    @FXML private TableColumn idColumn1;
    @FXML private TableColumn nameColumn1;
    @FXML private TableColumn startColumn1;
    @FXML private TableColumn endColumn1;
    @FXML private TableColumn priceColumn1;
    @FXML private TableColumn revokeColumn;
    @FXML private Label sliderLabel;

    private Stage stage;
    private ObservableList<ExceptionOrder> unexecutedOrderData;
    private ObservableList<ExceptionOrder> exceptionOrderData;
    public void init(Stage stage){
        this.stage=stage;
        initTableView();
    }

    /**
     * 点击未执行订单列表,浏览未执行订单
     */
    @FXML
    private void toUnexecutedOrder(){
        unexecutedTableView.setVisible(true);
        exceptionOrderTableView.setVisible(false);
        moveOrderButtonBottomBorder(sliderLabel,20);
    }

    /**
     * 点击异常订单列表，浏览异常订单
     */
    @FXML
    private void toExceptionOrder(){
        exceptionOrderTableView.setVisible(true);
        unexecutedTableView.setVisible(false);
        moveOrderButtonBottomBorder(sliderLabel,165);
    }

    /**
     * 设置按钮底部滑动效果
     */
    private void moveOrderButtonBottomBorder(Label label, double x){
        Timeline timeline=new Timeline();
        timeline.setAutoReverse(false);
        KeyValue newX=new KeyValue(label.layoutXProperty(),x);
        KeyFrame kf=new KeyFrame(Duration.millis(300),newX);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }


    /**
     *初始化列表数据
     */
    private void initTableView(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        startColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        unexecutedOrderData= FXCollections.observableArrayList();
        unexecutedOrderData.add(new ExceptionOrder("201611220001","李四","2016.11.22 8:00","2016.11.22 20:00",200));
        unexecutedOrderData.add(new ExceptionOrder("201611220002","王五","2016.11.22 9:00","2016.11.22 22:00",300));
        unexecutedTableView.setItems(unexecutedOrderData);

        idColumn1.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        nameColumn1.setCellValueFactory(new PropertyValueFactory<>("userName"));
        startColumn1.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endColumn1.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        priceColumn1.setCellValueFactory(new PropertyValueFactory<>("price"));
        revokeColumn.setCellFactory(new Callback<TableColumn<ExceptionOrder,Boolean>, TableCell<ExceptionOrder,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new ExceptionOrderListButtonCell();
            }
        });
        exceptionOrderData= FXCollections.observableArrayList();
        exceptionOrderData.add(new ExceptionOrder("111","李四","2016.11.22 8:00","2016.11.22 20:00",200));
        exceptionOrderData.add(new ExceptionOrder("222","王五","2016.11.22 9:00","2016.11.22 22:00",300));
        exceptionOrderTableView.setItems(exceptionOrderData);
    }

    public  class ExceptionOrder{
        private String orderID;
        private String userName;
        private String startTime;
        private String endTime;
        private int price;
        public ExceptionOrder(String orderID,String userName,String startTime,String endTime,int price) {
            this.orderID=orderID;
            this.userName=userName;
            this.startTime=startTime;
            this.endTime=endTime;
            this.price=price;
        }

        public String getOrderID() {
            return orderID;
        }
        public void setOrderID(String orderID) {
            this.orderID = orderID;
        }
        public String getUserName() {
            return userName;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }
        public String getStartTime() {
            return startTime;
        }
        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }
        public String getEndTime() {
            return endTime;
        }
        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }
        public int getPrice() {
            return price;
        }
        public void setPrice(int price) {
            this.price = price;
        }
    }

    public class ExceptionOrderListButtonCell extends TableCell<ExceptionOrder,Boolean>{
        private Button revokeButton=new Button();
        private ImageView revokeImageView=new ImageView(new Image(getClass().getResourceAsStream("webmarketerimages/delete.png")));
        public ExceptionOrderListButtonCell(){
            revokeButton.setStyle("-fx-background-color: transparent");
            revokeImageView.setFitHeight(35);
            revokeImageView.setFitWidth(35);
            revokeButton.setGraphic(revokeImageView);
            revokeButton.setOnAction((ActionEvent e)->{
                new ValueJudgeUI(stage);
            });
        }

        @Override
        protected  void updateItem(Boolean t,boolean empty){
            super.updateItem(t,empty);
            if(empty){
                setGraphic(null);
                setText(null);
            }else{
                setGraphic(revokeButton);
                setText(null);
            }
        }
    }
}
