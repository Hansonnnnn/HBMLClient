package presentation.view.HotelManagerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Created by LENOVO on 2016/12/1.
 */
public class OrderBrowseUIController {

    @FXML private TableView hotelOrderTableView;
    @FXML private TableColumn nameColumn;
    @FXML private TableColumn idColumn;
    @FXML private TableColumn stateColumn;

    private Stage stage;
    private Scene beforeScene;
    private Scene thisScene;
    private Scene loginScene;
    private ObservableList data;
    public void init(Stage stage,Scene beforeScene,Scene thisScene,Scene loginScene){
        this.stage=stage;
        this.beforeScene=beforeScene;
        this.thisScene=thisScene;
        this.loginScene=loginScene;
        initTableView();
    }

    /**
     * 点击注销按钮，返回到登录界面
     */
    @FXML
    private void backToLogin(){
        stage.setScene(loginScene);
    }

    /**
     * 点击返回按钮，返回到上一个界面
     */
    @FXML
    private void back(){
        stage.setScene(beforeScene);
    }

    /**
     * 点击浏览订单详情按钮,跳转至对应界面
     */
    @FXML
    private void toOrderInfo(){
        stage.setScene(new HotelOrderInfoUI(new Group(),stage,thisScene,loginScene));
    }

    /**
     * 初始化hotelOrderTableView
     */
    private void initTableView(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        stateColumn.setCellValueFactory(new PropertyValueFactory<>("orderState"));

        data= FXCollections.observableArrayList();
        data.add(new HotelOrder("李四","201611260001","未执行"));
        data.add(new HotelOrder("王五","201611260002","异常"));
        hotelOrderTableView.setItems(data);
    }

    public class HotelOrder{
        private String userName;
        private String orderID;
        private String orderState;
        public HotelOrder(String userName,String orderID,String orderState){
            this.userName=userName;
            this.orderID=orderID;
            this.orderState=orderState;
        }
        public String getUserName() {
            return userName;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }
        public String getOrderID() {
            return orderID;
        }
        public void setOrderID(String orderID) {
            this.orderID = orderID;
        }
        public String getOrderState() {
            return orderState;
        }
        public void setOrderState(String orderState) {
            this.orderState = orderState;
        }
    }
}
