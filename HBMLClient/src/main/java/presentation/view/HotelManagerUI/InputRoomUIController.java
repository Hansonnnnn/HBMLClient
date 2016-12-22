package presentation.view.HotelManagerUI;

import businesslogic.roomInfobl.RoomInfoStaffServiceImpl;
import businesslogicservice.roominfoblservice.RoomInfoStaffService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import  javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import message.RoomStateMessage;
import presentation.view.application.MyDialog;
import vo.RoomInfoVO;
import vo.UserVO;

/**
 * Created by LENOVO on 2016/11/25.
 */
public class InputRoomUIController {
    @FXML private TableView roomTypeTableView;
    @FXML private TextField roomTypeTextField;
    @FXML private TextField roomIdTextField;
    @FXML private TextField roomPriceTextField;
    @FXML private TableColumn roomIdColumn;
    @FXML private TableColumn roomTypeColumn;
    @FXML private TableColumn roomPriceColumn;
    @FXML private TableColumn viewInfoColumn;
    @FXML private Button inputButton;

    private VBox infoVBox;
    private VBox thisVBox;
    private Stage stage;
    private ObservableList data;
    private UserVO userVO;
    private RoomInfoStaffService roomInfoStaffService;
    public void init(VBox infoVBox, VBox thisVBox, Stage stage, UserVO userVO){
        this.infoVBox=infoVBox;
        this.thisVBox=thisVBox;
        this.userVO=userVO;
        this.stage=stage;
        roomInfoStaffService=new RoomInfoStaffServiceImpl();
        addTableView();
    }

    private void addTableView(){
        roomIdColumn.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        roomTypeColumn.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        roomPriceColumn.setCellValueFactory(new PropertyValueFactory<>("defaultPrice"));
        viewInfoColumn.setCellFactory(new Callback<TableColumn<RoomInfoVO,Boolean>, TableCell<RoomInfoVO,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new RoomTypeInfoButtonCell(infoVBox,thisVBox);
            }
        });
        data= FXCollections.observableArrayList();
        if(roomInfoStaffService.getRoomList(userVO.getHotelid())!=null){
            for(RoomInfoVO roomInfoVO:roomInfoStaffService.getRoomList(userVO.getHotelid()).values()){
                data.add(roomInfoVO);
            }
        }
        roomTypeTableView.setItems(data);
    }



    /**
     * 点击录入按钮时，录入添加的房间类型
     */
    @FXML
    private void addRoomType(){
        if((roomTypeTextField.getText()!=null)&&(roomIdTextField.getText()!=null)&&(roomPriceTextField.getText()!=null)
                &&(!roomTypeTextField.getText().equals(""))&&(!roomIdTextField.getText().equals(""))&&(!roomPriceTextField.getText().equals(""))){
            RoomInfoVO newRoomInfoVO=new RoomInfoVO(0,userVO.getHotelid(),roomIdTextField.getText(),roomTypeTextField.getText(),
                    Integer.parseInt(roomPriceTextField.getText()), RoomStateMessage.Blank,null,null);
            roomInfoStaffService.addRoom(newRoomInfoVO);
            addTableView();
            roomTypeTextField.setText("");
            roomIdTextField.setText("");
            roomPriceTextField.setText("");
            roomTypeTableView.refresh();
        }else{
            new MyDialog(stage,"请将录入的客房信息填写完整",0);
        }
    }


    public class RoomTypeInfoButtonCell extends TableCell<RoomInfoVO,Boolean>{
        private HBox hBox=new HBox();
        private Button viewButton=new Button();
        private Button deleteButton=new Button();
        private ImageView viewImageView=new ImageView(new Image(getClass().getResourceAsStream("ManagerImages/view1.png")));
        private ImageView deleteImageView=new ImageView(new Image(getClass().getResourceAsStream("ManagerImages/delete.png")));
        public RoomTypeInfoButtonCell(VBox infoVBox,VBox beforeVBox){
            hBox.getChildren().addAll(viewButton,deleteButton);
            viewButton.setStyle("-fx-background-color: transparent");
            viewButton.setGraphic(viewImageView);
            deleteButton.setStyle("-fx-background-color: transparent");
            deleteButton.setGraphic(deleteImageView);
            viewButton.setOnAction((ActionEvent e)->{
                int seletedIndex=getTableRow().getIndex();
                RoomInfoVO roomInfoVO=(RoomInfoVO)roomTypeTableView.getItems().get(seletedIndex);
                infoVBox.getChildren().remove(0);
                infoVBox.getChildren().add(new RoomInfoUI(infoVBox,thisVBox,roomInfoVO,stage));
            });
            deleteButton.setOnAction((ActionEvent e)->{
                int seletedIndex=getTableRow().getIndex();
                RoomInfoVO roomInfoVO=(RoomInfoVO)roomTypeTableView.getItems().get(seletedIndex);
                roomInfoStaffService.deleteRoom(roomInfoVO.getRoomInfoID());
                addTableView();
                roomTypeTableView.refresh();
            });
        }

        @Override
        protected void updateItem(Boolean t,boolean empty){
            super.updateItem(t,empty);
            if(empty){
                setGraphic(null);
                setText(null);
            }else{
                setGraphic(hBox);
                setText(null);
            }
        }
    }

}
