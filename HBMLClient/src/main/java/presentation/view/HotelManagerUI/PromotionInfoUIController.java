package presentation.view.HotelManagerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.DateHelper;
import vo.PromotionVO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by LENOVO on 2016/11/27.
 */
public class PromotionInfoUIController {

    @FXML private TextField promotionNameTextField;
    @FXML private ComboBox memberLevelComboBox;
    @FXML private TextArea contentTextArea;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;
    @FXML private ComboBox discountBox;


    private VBox infoVBox;
    private VBox beforeVBox;
    private ObservableList hourData;
    private ObservableList minuteData;
    private PromotionVO promotionVO;
    private ObservableList discountData;
    private ObservableList gradeData;
    private DateHelper dateHelper;
    public void init(VBox infoVBox, VBox beforeVBox, PromotionVO promotionVO){
        this.infoVBox=infoVBox;
        this.beforeVBox=beforeVBox;
        this.promotionVO=promotionVO;
        dateHelper=new DateHelper();
        discountData=FXCollections.observableArrayList();
        gradeData=FXCollections.observableArrayList();
        for(int i=1;i<100;i++){
            discountData.add(i);
            if(i<=7){
                gradeData.add(i);
            }
        }
        memberLevelComboBox.setItems(gradeData);
        discountBox.setItems(discountData);
        initInfo();
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
     * 初始化数据
     */
    private void initInfo(){
        promotionNameTextField.setText(promotionVO.getName());
        contentTextArea.setText(promotionVO.getContent());
        memberLevelComboBox.setValue(promotionVO.getMinRankAvailable());
        discountBox.setValue(promotionVO.getDiscount());
        startDatePicker.setValue(dateHelper.dateToLocalDate(promotionVO.getStartDate()));
        endDatePicker.setValue(dateHelper.dateToLocalDate(promotionVO.getEndDate()));
    }
}


