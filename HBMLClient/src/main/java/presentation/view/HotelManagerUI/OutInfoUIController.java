package presentation.view.HotelManagerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Created by LENOVO on 2016/11/26.
 */
public class OutInfoUIController {

    @FXML private Label roomIdLabel;
    @FXML private Label roomTypeLabel;
    @FXML private Label roomPriceLabel;
    @FXML private Label customerNameLabel;
    @FXML private Label customerIdLabel;
    @FXML private Label customerPhoneLabel;

    @FXML private ComboBox actualOutHoursComboBox;
    @FXML private ComboBox actualOutMinuteComboBox;

    private Stage stage;
    private Scene beforeScene;
    private Scene loginScene;
    private ObservableList hourData;
    private ObservableList minuteData;

    public void init(Stage stage,Scene beforeScene,Scene loginScene){
        this.stage=stage;
        this.beforeScene=beforeScene;
        this.loginScene=loginScene;

        initComboBox();
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
     * 设置时分选择框内的值
     */
    private void initComboBox(){
        hourData= FXCollections.observableArrayList();
        for(int i=0;i<24;i++){
            if(i<10){
                hourData.add("0"+i);
            }
            else{
                hourData.add(i);
            }
        }
        minuteData=FXCollections.observableArrayList();
        for(int i=0;i<60;i++){
            if(i<10){
                minuteData.add("0"+i);
            }
            else{
                minuteData.add(i);
            }
        }
        actualOutHoursComboBox.setItems(hourData);
        actualOutMinuteComboBox.setItems(minuteData);
    }
}
