package presentation.view.WebMarketerUI;

import businesslogic.promotionbl.PromotionWebMarketerImpl;
import businesslogicservice.promotionblservice.PromotionWebMarketerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DateHelper;
import model.DiscountType;
import presentation.view.application.MyDialog;
import vo.PromotionVO;

/**
 * Created by LENOVO on 2016/12/5.
 */
public class AddWebPromotionUIController {
    @FXML private TextField nameTextField;
    @FXML private ComboBox<Integer> discountComboBox;
    @FXML private ComboBox<Integer> gradeComboBox;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;
    @FXML private TextArea contentTextArea;

    private VBox infoVBox;
    private VBox beforeVBox;
    private Stage stage;
    private DateHelper dateHelper;
    private ObservableList discountData;
    private ObservableList gradeData;
    private PromotionWebMarketerService promotionWebMarketerService;
    public void init(VBox infoVBox,VBox beforeVBox,Stage stage){
        this.infoVBox=infoVBox;
        this.beforeVBox=beforeVBox;
        this.stage=stage;
        dateHelper = new DateHelper();
        promotionWebMarketerService = new PromotionWebMarketerImpl();
        discountData = FXCollections.observableArrayList();
        gradeData = FXCollections.observableArrayList();
        for(int i = 1;i < 100;i++){
            discountData.add(i);
            if(i < 8){
                gradeData.add(i);
            }
        }
        discountComboBox.setItems(discountData);
        gradeComboBox.setItems(gradeData);
    }

    /**
     * 点击返回按钮，跳转至上个界面
     */
    @FXML
    private void back(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().addAll(new WebPromotionUI(infoVBox,stage));
    }

    /**
     * 点击确认添加按钮，保存促销策略信息
     */
    @FXML
    private void add(){
        boolean nameFull=(!nameTextField.getText().equals(""))&&(nameTextField.getText()!=null);
        boolean discountFull=(!discountComboBox.getValue().equals(""))&&(discountComboBox.getValue()!=null);
        boolean gradeFull=(!gradeComboBox.getValue().equals(""))&&(gradeComboBox.getValue()!=null);
        boolean startFull=(!startDatePicker.getValue().equals(""))&&(startDatePicker.getValue()!=null);
        boolean endFull=(!endDatePicker.getValue().equals(""))&&(startDatePicker.getValue()!=null);
        if(nameFull&&discountFull&&gradeFull&&startFull&&endFull){
            PromotionVO promotionVO=new PromotionVO(nameTextField.getText(),contentTextArea.getText(),
                    dateHelper.localDateToDate(startDatePicker.getValue()),dateHelper.localDateToDate(endDatePicker.getValue()),
                    gradeComboBox.getValue(), DiscountType.DaZhe,0,discountComboBox.getValue());
            promotionWebMarketerService.addWebPromotion(promotionVO);
            infoVBox.getChildren().remove(0);
            infoVBox.getChildren().add(new WebPromotionUI(infoVBox,stage));
            new MyDialog(stage,"促销策略添加成功",2);
        }else{
            new MyDialog(stage,"请将促销策略信息填写完整",0);
        }
    }
}
