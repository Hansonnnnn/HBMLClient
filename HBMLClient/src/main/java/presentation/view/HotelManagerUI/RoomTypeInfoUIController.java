package presentation.view.HotelManagerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import vo.RoomInfoVO;

import javax.swing.*;

/**
 * Created by LENOVO on 2016/12/10.
 */
public class RoomTypeInfoUIController {

    @FXML private TableView roomTableView;
    @FXML private TableColumn roomIdColumn;
    @FXML private TableColumn roomStateColumn;
    @FXML private TableColumn roomPriceColumn;
    @FXML private TableColumn roomInfoColumn;


    private VBox infoVBox;
    private VBox thisVBox;
    private VBox beforeVBox;
    private ObservableList roomInfoData;
    public void init(VBox infoVBox,VBox thisVBox,VBox beforeVBox){
        this.infoVBox=infoVBox;
        this.thisVBox=thisVBox;
        this.beforeVBox=beforeVBox;
        initTableView();
    }

    /**
     * 点击返回按钮，返回到上一界面
     */
    @FXML
    private void back(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(beforeVBox);
    }

    /**
     * 初始化roomTableView
     */
    private void initTableView(){
        roomIdColumn.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        roomStateColumn.setCellValueFactory(new PropertyValueFactory<>("roomState"));
        roomPriceColumn.setCellValueFactory(new PropertyValueFactory<>("defaultPrice"));
        roomInfoColumn.setCellFactory(new Callback<TableColumn<RoomInfo,Boolean>, TableCell<RoomInfo,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new RoomInfoButtonCell(infoVBox,thisVBox);
            }
        });

        roomInfoData= FXCollections.observableArrayList();
        roomInfoData.add(new RoomInfo("3B666","空闲",128));
        roomInfoData.add(new RoomInfo("3B888","已预订",333));
        roomTableView.setItems(roomInfoData);
    }

    public class RoomInfo{
        private String roomID;
        private String roomState;
        private int defaultPrice;
        public RoomInfo(String roomID,String roomState,int defaultPrice){
            this.roomID=roomID;
            this.roomState=roomState;
            this.defaultPrice=defaultPrice;
        }

        public String getRoomID() {
            return roomID;
        }

        public void setRoomID(String roomID) {
            this.roomID = roomID;
        }

        public String getRoomState() {
            return roomState;
        }

        public void setRoomState(String roomState) {
            this.roomState = roomState;
        }

        public int getDefaultPrice() {
            return defaultPrice;
        }

        public void setDefaultPrice(int defaultPrice) {
            this.defaultPrice = defaultPrice;
        }
    }

    public class RoomInfoButtonCell extends TableCell<RoomInfo,Boolean>{
        private Button viewRoomInfoButton=new Button();
        private ImageView viewImageView=new ImageView(new Image(getClass().getResourceAsStream("ManagerImages/view1.png")));
        public RoomInfoButtonCell(VBox infoVBox,VBox beforeVBox){
            viewRoomInfoButton.setGraphic(viewImageView);
            viewRoomInfoButton.setStyle("-fx-background-color: transparent");
            viewRoomInfoButton.setOnAction((ActionEvent e)->{
                infoVBox.getChildren().remove(0);
                infoVBox.getChildren().add(new RoomInfoUI(infoVBox,beforeVBox));
            });
        }

        @Override
        protected void updateItem(Boolean t,boolean empty){
            super.updateItem(t,empty);
            if(empty){
                setGraphic(null);
                setText(null);
            }else{
                setGraphic(viewRoomInfoButton);
                setText(null);
            }
        }
    }


}
