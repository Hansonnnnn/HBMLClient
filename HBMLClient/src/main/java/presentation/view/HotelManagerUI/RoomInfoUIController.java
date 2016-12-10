package presentation.view.HotelManagerUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Created by LENOVO on 2016/12/10.
 */
public class RoomInfoUIController {

    @FXML private TextField roomIdTextField;
    @FXML private ComboBox roomStateComboBox;
    @FXML private TextField roomPriceTextField;
    @FXML private Button editButton;
    @FXML private Button confirmButton;

    private VBox infoVBox;
    private VBox beforeVBox;
    public void init(VBox infoVBox,VBox beforeVBox){
        this.infoVBox=infoVBox;
        this.beforeVBox=beforeVBox;
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

    }

    /**
     * 点击确认修改按钮，保存编辑后的房间信息
     */
    @FXML
    private void confirm(){

    }

}
