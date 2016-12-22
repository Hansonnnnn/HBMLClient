package presentation.view.HotelManagerUI;

import businesslogic.roomInfobl.RoomInfoStaffServiceImpl;
import businesslogicservice.roominfoblservice.RoomInfoStaffService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import message.RoomStateMessage;
import vo.RoomInfoVO;

import javax.xml.soap.Text;

/**
 * Created by LENOVO on 2016/12/10.
 */
public class RoomInfoUIController {

    @FXML private TextField roomIdTextField;
    @FXML private TextField roomTypeTextField;
    @FXML private ComboBox<String> roomStateComboBox;
    @FXML private TextField roomPriceTextField;

    private VBox infoVBox;
    private VBox beforeVBox;
    private RoomInfoVO roomInfoVO;
    private Stage stage;
    private ObservableList stateData;
    private RoomInfoStaffService roomInfoStaffService;
    public void init(VBox infoVBox, VBox beforeVBox, RoomInfoVO roomInfoVO, Stage stage){
        this.infoVBox=infoVBox;
        this.beforeVBox=beforeVBox;
        this.roomInfoVO=roomInfoVO;
        this.stage=stage;
        roomInfoStaffService=new RoomInfoStaffServiceImpl();
        initData();
    }

    /**
     * 初始化房间数据
     */
    private void initData(){
        roomIdTextField.setText(roomInfoVO.getRoomID());
        roomTypeTextField.setText(roomInfoVO.getRoomType());
        stateData= FXCollections.observableArrayList();
        stateData.add("不可用");
        stateData.add("可用");
        stateData.add("已预订");
        stateData.add("已入住");
        roomStateComboBox.setItems(stateData);
        if(roomInfoVO.getRoomState()== RoomStateMessage.Unavailable){
            roomStateComboBox.setValue("不可用");
        }else if(roomInfoVO.getRoomState()==RoomStateMessage.Blank){
            roomStateComboBox.setValue("可用");
        }else if(roomInfoVO.getRoomState()==RoomStateMessage.Booked){
            roomStateComboBox.setValue("已预订");
        }else if(roomInfoVO.getRoomState()==RoomStateMessage.Checkined){
            roomStateComboBox.setValue("已入住");
        }
        roomPriceTextField.setText(String.valueOf(roomInfoVO.getDefaultPrice()));
    }

    /**
     * 点击返回按钮，返回到上一个界面
     */
    @FXML
    private void back(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(beforeVBox);
    }

    /**
     * 点击编辑按钮，编辑房间信息
     */
    @FXML
    private void edit(){
        roomIdTextField.setDisable(false);
        roomTypeTextField.setDisable(false);
        roomStateComboBox.setDisable(false);
        roomPriceTextField.setDisable(false);
    }

    /**
     * 点击确认修改按钮，保存编辑后的房间信息
     */
    @FXML
    private void confirm(){
        roomIdTextField.setDisable(true);
        roomTypeTextField.setDisable(true);
        roomStateComboBox.setDisable(true);
        roomPriceTextField.setDisable(true);
        boolean idFull=(!roomIdTextField.getText().equals(""))&&(roomIdTextField.getText()!=null);
        boolean typeFull=(!roomTypeTextField.getText().equals(""))&&(roomTypeTextField.getText()!=null);
        boolean priceFull=(!roomPriceTextField.getText().equals(""))&&(roomPriceTextField.getText()!=null);
        if(idFull&&typeFull&&priceFull){
            RoomStateMessage message=RoomStateMessage.Blank;
            if(roomStateComboBox.getValue().equals("不可用")){
                message=RoomStateMessage.Unavailable;
            }else if(roomStateComboBox.getValue().equals("可用")){
                message=RoomStateMessage.Blank;
            }else if(roomStateComboBox.getValue().equals("已预订")){
                message=RoomStateMessage.Booked;
            }else if(roomStateComboBox.getValue().equals("已入住")){
                message=RoomStateMessage.Checkined;
            }
            roomInfoVO.setRoomID(roomIdTextField.getText());
            roomInfoVO.setRoomState(message);
            roomInfoVO.setDefaultPrice(Integer.parseInt(roomPriceTextField.getText()));
            RoomInfoVO newRoomInfoVO=new RoomInfoVO(roomInfoVO.getRoomInfoID(),roomInfoVO.getHotelID(),
                    roomIdTextField.getText(),roomTypeTextField.getText(),Integer.parseInt(roomPriceTextField.getText()),
                    message,roomInfoVO.getDetailedInfo1(),roomInfoVO.getDetailedInfo2());
            roomInfoStaffService.modifyRoom(newRoomInfoVO);
        }
    }

}
