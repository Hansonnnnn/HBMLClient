package presentation.view.HotelManagerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by LENOVO on 2016/11/26.
 */
public class CheckInfoUIController {

    @FXML private Label roomIdLabel;
    @FXML private Label roomTypeLabel;
    @FXML private Label roomPriceLabel;
    @FXML private Label customerNameLabel;
    @FXML private Label customerIdLabel;
    @FXML private Label customerPhoneLabel;

    @FXML private DatePicker checkDatePicker;
    @FXML private DatePicker outDatePicker;
    @FXML private ComboBox checkHoursComboBox;
    @FXML private ComboBox checkMinuteComboBox;
    @FXML private ComboBox outHoursComboBox;
    @FXML private ComboBox outMinuteComboBox;

    private Stage stage;
    private Scene beforeScene;
    private Scene loginScene;
    private ObservableList hourData;
    private ObservableList minuteData;

    public void init(Stage stage,Scene beforeScene,Scene loginScene){
        this.stage=stage;
        this.beforeScene=beforeScene;
        this.loginScene=loginScene;
        initDatePicker();
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
     * 实现退房时间不能选中当天以前的日期
     */
    private void initDatePicker(){
        checkDatePicker.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory =
                new Callback<DatePicker, DateCell>() {
                    @Override
                    public DateCell call(final DatePicker datePicker) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item.isBefore(
                                        checkDatePicker.getValue().plusDays(1))
                                        ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                }
                                long p = ChronoUnit.DAYS.between(
                                        checkDatePicker.getValue(), item
                                );
                            }
                        };
                    }
                };
        outDatePicker.setDayCellFactory(dayCellFactory);
        outDatePicker.setValue(checkDatePicker.getValue().plusDays(1));
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
        checkHoursComboBox.setItems(hourData);
        outHoursComboBox.setItems(hourData);
        checkMinuteComboBox.setItems(minuteData);
        outMinuteComboBox.setItems(minuteData);
    }
}
