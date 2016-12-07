package presentation.view.WebMarketerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

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
    @FXML private TableColumn revokeColumn;


    private ObservableList<ExceptionOrder> unexecutedOrderData;
    public void init(){
        initTableView();
    }

    /**
     * 点击未执行订单列表,浏览未执行订单
     */
    @FXML
    private void toUnexecutedOrder(){
        unexecutedTableView.setVisible(true);
        exceptionOrderTableView.setVisible(false);
    }

    /**
     * 点击异常订单列表，浏览异常订单
     */
    @FXML
    private void toExceptionOrder(){
        exceptionOrderTableView.setVisible(true);
        unexecutedTableView.setVisible(false);
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
        revokeColumn.setCellFactory(new Callback<TableColumn<ExceptionOrder,Boolean>, TableCell<ExceptionOrder,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new ExceptionOrderListButtonCell();
            }
        });
        unexecutedOrderData= FXCollections.observableArrayList();
        unexecutedOrderData.add(new ExceptionOrder("201611220001","李四","2016.11.22 8:00","2016.11.22 20:00",200));
        unexecutedOrderData.add(new ExceptionOrder("201611220002","王五","2016.11.22 9:00","2016.11.22 22:00",300));
        unexecutedTableView.setItems(unexecutedOrderData);
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
        private Button revokeButton=new Button("撤销订单");
        private Stage stage;
//        public ExceptionOrderListButtonCell(Stage stage){
//            this.stage=stage;
//        }

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
