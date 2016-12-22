package presentation.view.HotelManagerUI;

import businesslogic.promotionbl.PromotionStaffImpl;
import businesslogicservice.promotionblservice.PromotionStaffService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.DateHelper;
import model.DiscountType;
import presentation.view.application.MyDialog;
import vo.PromotionVO;
import vo.UserVO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by LENOVO on 2016/11/27.
 */
public class NewPromotionUIController {

    @FXML private TextField promotionNameTextField;
    @FXML private ComboBox<Integer> memberLevelComboBox;
    @FXML private ComboBox<Integer> discountBox;
    @FXML private TextArea contentTextArea;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;

    private VBox infoVBox;
    private VBox beforeVBox;
    private UserVO userVO;
    private Stage stage;
    private ObservableList discountData;
    private ObservableList gradeData;
    private DateHelper dateHelper;
    private PromotionStaffService promotionStaffService;
    public void init(VBox infoVBox, VBox beforeVBox, UserVO userVO,Stage stage){
        this.infoVBox=infoVBox;
        this.beforeVBox=beforeVBox;
        this.userVO=userVO;
        this.stage=stage;
        dateHelper=new DateHelper();
        promotionStaffService=new PromotionStaffImpl();
        discountData=FXCollections.observableArrayList();
        gradeData=FXCollections.observableArrayList();
        for(int i=1;i<100;i++){
            discountData.add(i);
            if(i<=7){
                gradeData.add(i);
            }
        }
        discountBox.setItems(discountData);
        memberLevelComboBox.setItems(gradeData);
        initDatePicker();

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
     * 点击确认按钮，保存策略信息
     */
    @FXML
    private void confirm(){
        boolean nameFull=(!promotionNameTextField.equals(""))&&(promotionNameTextField!=null);
        if(nameFull){
            PromotionVO promotionVO=new PromotionVO(userVO.getHotelid(),promotionNameTextField.getText(),contentTextArea.getText(),
                    dateHelper.localDateToDate(startDatePicker.getValue()),dateHelper.localDateToDate(endDatePicker.getValue()),
                    memberLevelComboBox.getValue(), DiscountType.DaZhe,0,discountBox.getValue());
            promotionStaffService.addHotelPromotion(promotionVO);
            infoVBox.getChildren().remove(0);
            infoVBox.getChildren().add(new HotelPromotionUI(infoVBox,stage,userVO));
            new MyDialog(stage,"促销策略添加成功",2);
        }else{
            new MyDialog(stage,"请将促销信息填写完整",0);
        }

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
