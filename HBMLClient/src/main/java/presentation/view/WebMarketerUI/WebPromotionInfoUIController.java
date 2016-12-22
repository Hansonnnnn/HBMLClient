package presentation.view.WebMarketerUI;

import businesslogic.promotionbl.PromotionWebMarketerImpl;
import businesslogicservice.promotionblservice.PromotionWebMarketerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DateHelper;
import presentation.view.HotelManagerUI.HotelPromotionUIController;
import presentation.view.HotelManagerUI.PromotionInfoUI;
import presentation.view.WebManagerUI.WebMarketerInfoUI;
import vo.PromotionVO;

import java.util.Date;

/**
 * Created by LENOVO on 2016/12/15.
 */
public class WebPromotionInfoUIController {
    @FXML private TextField nameTextField;
    @FXML private ComboBox<Integer> discountComboBox;
    @FXML private ComboBox<Integer> gradeComboBox;
    @FXML private ComboBox provinceComboBox;
    @FXML private ComboBox cityComboBox;
    @FXML private ComboBox regionComboBox;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;
    @FXML private TextArea contentTextArea;

    private VBox infoVBox;
    private PromotionVO promotionVO;
    private DateHelper dateHelper;
    private ObservableList discountData;
    private ObservableList gradeData;
    private Stage stage;
    private PromotionWebMarketerService promotionWebMarketerService;
    public void init(VBox infoVBox, PromotionVO promotionVO,Stage stage){
        this.promotionVO=promotionVO;
        this.infoVBox=infoVBox;
        this.stage=stage;
        dateHelper=new DateHelper();
        promotionWebMarketerService=new PromotionWebMarketerImpl();
        discountData= FXCollections.observableArrayList();
        gradeData=FXCollections.observableArrayList();
        for(int i=1;i<=99;i++){
            discountData.add(i);
            if(i<=7){
                gradeData.add(i);
            }
        }
        discountComboBox.setItems(discountData);
        gradeComboBox.setItems(gradeData);
        initData();
    }

    /**
     * 点击返回按钮，返回上一个界面
     */
    @FXML
    private void back(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new WebPromotionUI(infoVBox,stage));
    }

    /**
     * 初始化promotion数据
     */
    private void initData(){
        nameTextField.setText(promotionVO.getName());
        discountComboBox.setValue(promotionVO.getDiscount());
        gradeComboBox.setValue(promotionVO.getMinRankAvailable());
        startDatePicker.setValue(dateHelper.dateToLocalDate(promotionVO.getStartDate()));
        endDatePicker.setValue(dateHelper.dateToLocalDate(promotionVO.getEndDate()));
        contentTextArea.setText(promotionVO.getContent());
    }

//    /**
//     * 编辑promotion信息
//     */
//    @FXML
//    private void edit(){
//        nameTextField.setDisable(false);
//        nameTextField.setDisable(false);
//        discountComboBox.setDisable(false);
//        gradeComboBox.setDisable(false);
//        startDatePicker.setDisable(false);
//        endDatePicker.setDisable(false);
//        contentTextArea.setDisable(false);
//    }
//    /**
//     * 确认修改，保存promotion信息
//     */
//    @FXML
//    private void confirm(){
//        nameTextField.setDisable(true);
//        nameTextField.setDisable(true);
//        discountComboBox.setDisable(true);
//        gradeComboBox.setDisable(true);
//        provinceComboBox.setDisable(true);
//        cityComboBox.setDisable(true);
//        regionComboBox.setDisable(true);
//        startDatePicker.setDisable(true);
//        endDatePicker.setDisable(true);
//        contentTextArea.setDisable(true);
//        boolean nameFull = (!nameTextField.getText().equals(""))&&(nameTextField.getText()!=null);
//        if(nameFull){
//            PromotionVO newPromotionVO=new PromotionVO(nameTextField.getText(),contentTextArea.getText(),dateHelper.localDateToDate(startDatePicker.getValue()),
//                    dateHelper.localDateToDate(endDatePicker.getValue()), gradeComboBox.getValue(),promotionVO.getType(),0,discountComboBox.getValue());
//            promotionWebMarketerService.modifyWebPromotion(newPromotionVO);
//        }
//    }
}
