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
        roomInfoColumn.setCellFactory(new Callback<TableColumn<RoomInfoVO,Boolean>, TableCell<RoomInfoVO,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new RoomInfoButtonCell(infoVBox,beforeVBox);
            }
        });

        roomInfoData= FXCollections.observableArrayList();
        roomInfoData.add(new RoomInfoVO());
    }

    public class RoomInfoButtonCell extends TableCell<RoomInfoVO,Boolean>{
        private Button viewRoomInfoButton=new Button();
        public RoomInfoButtonCell(VBox infoVBox,VBox beforeVBox){
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
