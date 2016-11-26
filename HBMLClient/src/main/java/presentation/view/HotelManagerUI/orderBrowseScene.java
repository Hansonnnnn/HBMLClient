package presentation.view.HotelManagerUI;



import java.util.ArrayList;


import javafx.event.ActionEvent;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class orderBrowseScene extends Scene{
	/*
	 * 酒店管理订单浏览界面纵向布局
	 */
    private VBox vBox=new VBox();

	/*
	 * 存放头标题标签
	 */
    private ArrayList<Node> nodes;

	/*
	 * 酒店管理系统标签
	 */
    private Label managerLabel;

	/*
	 * 订单浏览/执行标签
	 */
    private Label orderBrowseLabel;



	/*
	 * 订单列表数据
	 */
    private ObservableList<HotelOrder> data;

	/*
	 * 酒店订单列表
	 */
    private TableView<HotelOrder> hotelOrderTableView;

    /*
     *订单编号标签
     */
    private Label orderIDLabel;

    /**
     * 订单编号文本框
     */
    private TextField orderIDTextField;

    /**
     * 订单详细信息按钮
     */
    private Button orderInfoButton;

    private Image arrowImage=new Image(getClass().getResourceAsStream("arrow.png"));

    public orderBrowseScene(Group root,Stage stage,Scene beforeScene,
                            HotelManagerScene hotelManager,Scene loginScene) {
        super(root);
        vBox.setSpacing(10);
        vBox.setPrefWidth(700);
        //添加界面上方用户栏
        nodes=new ArrayList<>();
        managerLabel=new Label("HBMS酒店管理系统");
        ImageView arrowImageView=new ImageView(arrowImage);
        orderBrowseLabel=new Label("订单浏览/执行");
        managerLabel.getStyleClass().add("labelSize");
        orderBrowseLabel.getStyleClass().add("labelSize");
        nodes.add(managerLabel);
        nodes.add(arrowImageView);
        nodes.add(orderBrowseLabel);
        vBox.getChildren().add(hotelManager.addHeadTitle("张三", beforeScene, loginScene, nodes, true, stage));

        hotelOrderTableView=new TableView<>();
        hotelOrderTableView.setEditable(false);
        hotelOrderTableView.setMaxWidth(402);
        data=FXCollections.observableArrayList();
        data.add(new HotelOrder("李四", "201611260001", "未执行"));
        data.add(new HotelOrder("王五", "201611260002", "异常"));
        hotelOrderTableView=addTableView(hotelOrderTableView, data);

        VBox tableVBox=new VBox();
        tableVBox.setAlignment(Pos.CENTER);
        tableVBox.getChildren().add(hotelOrderTableView);
        vBox.getChildren().add(tableVBox);

        HBox hBox=new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        orderIDLabel=new Label("酒店订单编号");
        orderIDTextField=new TextField();
        orderIDTextField.setEditable(false);
        orderInfoButton=new Button("详细信息");
        orderInfoButton.getStyleClass().add("confirmButton");
        orderInfoButton.setOnAction((ActionEvent e)->{
            stage.setScene(new HotelOrderInfoUI(new Group(),stage,this,loginScene));
        });
        hotelOrderTableView.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue)->{
            orderIDTextField.setText(((HotelOrder)hotelOrderTableView.getSelectionModel().getSelectedItem()).getOrderID());
        });
        hBox.getChildren().addAll(orderIDLabel,orderIDTextField,orderInfoButton);

        vBox.getChildren().add(hBox);
        vBox.getChildren().add(hotelManager.addBelowAcross());
        this.getStylesheets().add(orderBrowseScene.class.getResource("manager.css").toExternalForm());

        root.getChildren().add(vBox);

    }



    public static TableView<HotelOrder> addTableView(TableView<HotelOrder> hotelOrderTableView,
                                                     ObservableList<HotelOrder> data){
        TableColumn<HotelOrder,String> nameColumn=new TableColumn<>("客户姓名");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));

        TableColumn<HotelOrder,String> idColumn=new TableColumn<>("订单ID");
        idColumn.setMinWidth(150);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));

        TableColumn<HotelOrder,String> stateColumn=new TableColumn<>("订单状态");
        stateColumn.setMinWidth(150);
        stateColumn.setCellValueFactory(new PropertyValueFactory<>("orderState"));
        hotelOrderTableView.setItems(data);
        hotelOrderTableView.getColumns().addAll(nameColumn,idColumn,stateColumn);

        return hotelOrderTableView;
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