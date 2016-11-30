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
 * Created by LENOVO on 2016/11/27.
 */
public class NewPromotionUIController {

    @FXML private TextField promotionNameTextField;
    @FXML private TextField memberLevelTextField;
    @FXML private TextArea contentTextArea;
    @FXML private DatePicker startDatePicker;
    @FXML private ComboBox startHourComboBox;
    @FXML private ComboBox startMinuteComboBox;
    @FXML private DatePicker endDatePicker;
    @FXML private ComboBox endHourComboBox;
    @FXML private ComboBox endMinuteComboBox;

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
     * 点击确认按钮，保存策略信息
     */
    @FXML
    private void confirm(){

    }

    /**
     * 初始化ComboBox中的数据
     */
    private void initComboBox(){
        hourData= FXCollections.observableArrayList();
        minuteData=FXCollections.observableArrayList();
        for(int i=0;i<24;i++){
            if(i<10){
                hourData.add("0"+i);
            }else{
                hourData.add(i);
            }
        }
        startHourComboBox.setItems(hourData);
        endHourComboBox.setItems(hourData);
        for(int i=0;i<60;i++){
            if(i<10){
                minuteData.add("0"+i);
            }else{
                minuteData.add(i);
            }
        }
        startMinuteComboBox.setItems(minuteData);
        endMinuteComboBox.setItems(minuteData);
    }

    /**
     * 策略结束时间不能选择策略开始时间之前的日期
     */
    private void initDatePicker(){
        startDatePicker.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory =
                new Callback<DatePicker, DateCell>() {
                    @Override
                    public DateCell call(final DatePicker datePicker) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item.isBefore(

                                        startDatePicker.getValue().plusDays(1))
                                        ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0ca;");
                                }
                                long p = ChronoUnit.DAYS.between(
                                        startDatePicker.getValue(), item
                                );
                            }
                        };
                    }
                };
        endDatePicker.setDayCellFactory(dayCellFactory);
        endDatePicker.setValue(startDatePicker.getValue().plusDays(1));
    }
}
