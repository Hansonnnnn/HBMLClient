package presentation.view.HotelManagerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import  javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.view.application.MyDialog;

/**
 * Created by LENOVO on 2016/11/25.
 */
public class InputRoomUIController {
    @FXML private TableView roomTypeTableView;
    @FXML private TextField roomTypeTextField;
    @FXML private TextField roomIdTextField;
    @FXML private TextField roomPriceTextField;
    @FXML private TableColumn roomTypeColumn;
    @FXML private TableColumn roomNumberColumn;
    @FXML private TableColumn viewInfoColumn;
    @FXML private Button inputButton;

    private VBox infoVBox;
    private VBox thisVBox;
    private Stage stage;
    private ObservableList data;
    public void init(VBox infoVBox,VBox thisVBox,Stage stage){
        this.infoVBox=infoVBox;
        this.thisVBox=thisVBox;
        this.stage=stage;
        addTableView();
    }

    private void addTableView(){
        roomTypeColumn.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        viewInfoColumn.setCellFactory(new Callback<TableColumn<RoomTypeInfo,Boolean>, TableCell<RoomTypeInfo,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new RoomTypeInfoButtonCell(infoVBox,thisVBox);
            }
        });
        data= FXCollections.observableArrayList();
        data.add(new RoomTypeInfo("陋室",10));
        data.add(new RoomTypeInfo("标准单人间",100));
        data.add(new RoomTypeInfo("标准双人间",100));
        data.add(new RoomTypeInfo("总统套房",10));

        roomTypeTableView.setItems(data);

    }



    /**
     * 点击录入按钮时，录入添加的房间类型
     */
    @FXML
    private void addRoomType(){
        if((roomTypeTextField.getText()!=null)&&(roomIdTextField.getText()!=null)&&(roomPriceTextField.getText()!=null)
                &&(!roomTypeTextField.getText().equals(""))&&(!roomIdTextField.getText().equals(""))&&(!roomPriceTextField.getText().equals(""))){
            data.add(new RoomTypeInfo(roomTypeTextField.getText(),Integer.parseInt(roomIdTextField.getText())));
            roomTypeTextField.setText("");
            roomIdTextField.setText("");
            roomPriceTextField.setText("");
            roomTypeTableView.refresh();
        }else{
            new MyDialog(stage,"请将录入的客房信息填写完整",0);
        }
    }


    public class RoomTypeInfo{
        private String roomType;
        private int roomNumber;

        public RoomTypeInfo(String roomType, int roomNumber){
            this.roomType=roomType;
            this.roomNumber=roomNumber;
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

    public class RoomTypeInfoButtonCell extends TableCell<RoomTypeInfo,Boolean>{
        private Button viewButton=new Button();
        private ImageView viewImageView=new ImageView(new Image(getClass().getResourceAsStream("ManagerImages/view1.png")));
        public RoomTypeInfoButtonCell(VBox infoVBox,VBox beforeVBox){
            viewButton.setStyle("-fx-background-color: transparent");
            viewButton.setGraphic(viewImageView);
            viewButton.setOnAction((ActionEvent e)->{
                infoVBox.getChildren().remove(0);
                infoVBox.getChildren().add(new RoomTypeInfoUI(infoVBox,beforeVBox));
            });
        }

        @Override
        protected void updateItem(Boolean t,boolean empty){
            super.updateItem(t,empty);
            if(empty){
                setGraphic(null);
                setText(null);
            }else{
                setGraphic(viewButton);
                setText(null);
            }
        }
    }

}
