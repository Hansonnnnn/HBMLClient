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
 * Created by LENOVO on 2016/11/26.
 */
public class UpdateRoomUIController {

    @FXML private TableView updateRoomTableView;
    @FXML private TableColumn roomIdColumn;
    @FXML private TableColumn roomStateColumn;
    @FXML private TableColumn roomInfoColumn;

    private Stage stage;
    private Scene beforeScene;
    private Scene loginScene;
    private Scene thisScene;
    private ObservableList data;

    public void init(Stage stage,Scene beforeScene,Scene thisScene,Scene loginScene){
        this.stage=stage;
        this.beforeScene=beforeScene;
        this.loginScene=loginScene;
        this.thisScene=thisScene;
        addTableView();
    }

    private void addTableView(){
        roomIdColumn.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        roomStateColumn.setCellValueFactory(new PropertyValueFactory<>("roomState"));
        roomInfoColumn.setCellValueFactory(new PropertyValueFactory<>("roomInfo"));

        data= FXCollections.observableArrayList();
        data.add(new UpdateRoom("3B348","已入住","总统套房-998RMB"));
        data.add(new UpdateRoom("3B330","已预订","标准双人间-648RMB"));
        data.add(new UpdateRoom("3B331","空房","标准双人间-648RMB"));
        data.add(new UpdateRoom("3B332","退房缓冲","标准双人间-328RMB"));

        updateRoomTableView.setItems(data);
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
     * 点击更新入住信息按钮，进入入住信息界面
     */
    @FXML
    private void toCheckInfoUI(){
        stage.setScene(new CheckInfoUI(new Group(),stage,thisScene,loginScene));
    }

    /**
     * 点击更新退房信息按钮，进入退房信息界面
     */
    @FXML
    private void toOutInfoUI(){
        stage.setScene(new OutInfoUI(new Group(),stage,thisScene,loginScene));
    }

    public class  UpdateRoom{
        private String roomId;
        private String roomState;
        private String roomInfo;
        public UpdateRoom(String roomId, String roomState, String roomInfo){
            this.roomId=roomId;
            this.roomState=roomState;
            this.roomInfo=roomInfo;

        }
        public String getRoomState() {
            return roomState;
        }

        public void setRoomState(String roomState) {
            this.roomState = roomState;
        }

        public String getRoomInfo() {
            return roomInfo;
        }

        public void setRoomInfo(String roomInfo) {
            this.roomInfo = roomInfo;
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }
    }
}
