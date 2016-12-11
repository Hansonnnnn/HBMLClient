package presentation.view.HotelManagerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by LENOVO on 2016/11/27.
 */
public class PromotionInfoUIController {

    @FXML private TextField promotionNameTextField;
//    @FXML private TextField memberLevelComboBox;
    @FXML private TextArea contentTextArea;
    @FXML private DatePicker startDatePicker;
    @FXML private ComboBox startHourComboBox;
    @FXML private ComboBox startMinuteComboBox;
    @FXML private DatePicker endDatePicker;
    @FXML private ComboBox endHourComboBox;
    @FXML private ComboBox endMinuteComboBox;


    private VBox infoVBox;
    private VBox beforeVBox;
    private ObservableList hourData;
    private ObservableList minuteData;
    public void init(VBox infoVBox,VBox beforeVBox){
        this.infoVBox=infoVBox;
        this.beforeVBox=beforeVBox;
        initDatePicker();
        initComboBox();
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
     * 点击编辑按钮，修改策略信息
     */
    @FXML
    private void edit(){
        promotionNameTextField.setDisable(false);
        startDatePicker.setDisable(false);
        startHourComboBox.setDisable(false);
        startMinuteComboBox.setDisable(false);
        endDatePicker.setDisable(false);
        endHourComboBox.setDisable(false);
        endMinuteComboBox.setDisable(false);
        contentTextArea.setDisable(false);
    }

    /**
     * 点击确认修改按钮，保存修改后的信息
     */
    @FXML
    private void confirm(){
        promotionNameTextField.setDisable(true);

        startDatePicker.setDisable(true);
        startHourComboBox.setDisable(true);
        startMinuteComboBox.setDisable(true);
        endDatePicker.setDisable(true);
        endHourComboBox.setDisable(true);
        endMinuteComboBox.setDisable(true);
        contentTextArea.setDisable(true);
    }

    /**
     * 点击删除按钮，删除策略
     */
    @FXML
    private void delete(){

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

        for(int i=0;i<60;i++){
            if(i<10){
                minuteData.add("0"+i);
            }else{
                minuteData.add(i);
            }
        }
        startHourComboBox.setItems(hourData);
        endHourComboBox.setItems(hourData);
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
                                    setStyle("-fx-background-color: #ffc0cc;");
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


