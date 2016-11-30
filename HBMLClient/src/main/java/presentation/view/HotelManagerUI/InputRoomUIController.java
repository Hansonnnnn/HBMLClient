package presentation.view.HotelManagerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import  javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Created by LENOVO on 2016/11/25.
 */
public class InputRoomUIController {
    @FXML private TableView roomTableView;
    @FXML private TextField changePriceTextField;
    @FXML private TextField roomTypeTextField;
    @FXML private TextField roomNumberTextField;
    @FXML private TextField roomPriceTextField;
    @FXML private TableColumn roomTypeColumn;
    @FXML private TableColumn roomNumberColumn;
    @FXML private TableColumn roomPriceColumn;


    private Stage stage;
    private Scene beforeScene;
    private Scene loginScene;
    private ObservableList data;

    public void init(Stage stage,Scene beforeScene,Scene loginScene){
        this.stage=stage;
        this.beforeScene=beforeScene;
        this.loginScene=loginScene;
        addTableView();
    }

    private void addTableView(){

        roomTypeColumn.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        roomPriceColumn.setCellValueFactory(new PropertyValueFactory<>("roomPrice"));

        data= FXCollections.observableArrayList();
        data.add(new RoomInfo("陋室",10,128));
        data.add(new RoomInfo("标准单人间",100,328));
        data.add(new RoomInfo("标准双人间",100,648));
        data.add(new RoomInfo("总统套房",10,998));

        if(roomTableView.getSelectionModel().getSelectedItems()!=null){
            roomTableView.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue)->{
                    changePriceTextField.setText(String.valueOf(((RoomInfo)roomTableView.getSelectionModel().getSelectedItem()).getRoomPrice()));
            });
        }else{
            changePriceTextField.setText("");
        }


        roomTableView.setItems(data);

    }

    /**
     * 点击返回按钮，返回到上一个界面
     */
    @FXML
    private void back(){
        stage.setScene(beforeScene);
    }

    /**
     * 点击注销按钮，返回到登录界面
     */
    @FXML
    private void backToLogin(){
        stage.setScene(loginScene);
    }

    /**
     * 点击删除房型按钮，删除房型
     */
    @FXML
    private void deleteRoomType(){
        if(roomTableView.getSelectionModel().getSelectedItem()!=null){
            roomTableView.getSelectionModel().getSelectedItems()
                    .forEach(roomTableView.getItems()::remove);
            roomTableView.refresh();
        }
    }

    /**
     * 点击减按钮，减少可用客房数量
     */
    @FXML
    private void reduceRoomNumber(){
        if(roomTableView.getSelectionModel().getSelectedItem()!=null){
            int beforeNumber=((RoomInfo)roomTableView.getSelectionModel().getSelectedItem()).getRoomNumber();
            ((RoomInfo) roomTableView.getSelectionModel().getSelectedItem()).setRoomNumber(beforeNumber-1);
            roomTableView.refresh();
        }
    }

    /**
     * 点击加按钮，增加可用客房数量
     */
    @FXML
    private void addRoomNumber(){
        if(roomTableView.getSelectionModel().getSelectedItem()!=null){
            int beforeNumber=((RoomInfo)roomTableView.getSelectionModel().getSelectedItem()).getRoomNumber();
            ((RoomInfo) roomTableView.getSelectionModel().getSelectedItem()).setRoomNumber(beforeNumber+1);
            roomTableView.refresh();
        }
    }

    /**
     * 点击录入按钮时，录入添加的房间类型
     */
    @FXML
    private void addRoomType(){
        if((roomTypeTextField!=null)&&(roomNumberTextField!=null)&&(roomPriceTextField!=null)){
            data.add(new RoomInfo(roomTypeTextField.getText(),Integer.parseInt(roomNumberTextField.getText()),Integer.parseInt(roomPriceTextField.getText())));
            roomTypeTextField.setText("");
            roomNumberTextField.setText("");
            roomPriceTextField.setText("");
            roomTableView.refresh();
        }
    }

    /**
     * 修改文本框中的数字，就修改选中房间价格
     */
    @FXML
    private void changePrice(){
        if(changePriceTextField.getText()!=null&&!changePriceTextField.getText().equals("")){
            ((RoomInfo)roomTableView.getSelectionModel().getSelectedItem()).setRoomPrice(Integer.parseInt(changePriceTextField.getText()));
            roomTableView.refresh();
        }
    }


    public class RoomInfo{
        private String roomType;
        private int roomNumber;
        private int roomPrice;
        public RoomInfo(String roomType, int roomNumber, int roomPrice){
            this.roomType=roomType;
            this.roomNumber=roomNumber;

            this.roomPrice=roomPrice;
        }

        public int getRoomPrice() {
            return roomPrice;
        }

        public void setRoomPrice(int roomPrice) {
            this.roomPrice = roomPrice;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

    }

}
