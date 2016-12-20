package presentation.view.WebMarketerUI;

import businesslogic.creditbl.CreditWebMarketerImpl;
import businesslogicservice.creditblservice.CreditWebMarketerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import vo.RankVO;

import java.util.Map;

/**
 * Created by LENOVO on 2016/12/12.
 */
public class MemberGradeUIController {

    @FXML private TextField creditTextField1;
    @FXML private TextField creditTextField2;
    @FXML private TextField creditTextField3;
    @FXML private TextField creditTextField4;
    @FXML private TextField creditTextField5;
    @FXML private TextField creditTextField6;
    @FXML private TextField creditTextField7;
    @FXML private ComboBox discountComboBox1;
    @FXML private ComboBox discountComboBox6;
    @FXML private ComboBox discountComboBox2;
    @FXML private ComboBox discountComboBox3;
    @FXML private ComboBox discountComboBox4;
    @FXML private ComboBox discountComboBox5;
    @FXML private ComboBox discountComboBox7;

    private CreditWebMarketerService creditWebMarketerService;
    private ObservableList discountData;
    private Map<Integer, RankVO> creditData;
    public void init(){
        creditWebMarketerService=new CreditWebMarketerImpl();
        discountData= FXCollections.observableArrayList();
        for(int i=1;i<100;i++){
            discountData.add(i);
        }
        discountComboBox1.setItems(discountData);
        discountComboBox2.setItems(discountData);
        discountComboBox3.setItems(discountData);
        discountComboBox4.setItems(discountData);
        discountComboBox5.setItems(discountData);
        discountComboBox6.setItems(discountData);
        discountComboBox7.setItems(discountData);
        initData();
    }

    private void initData(){
        if(creditWebMarketerService.getRankList()!=null){
            creditData=creditWebMarketerService.getRankList();
            creditTextField1.setText(String.valueOf(creditData.get(1).getValue()));
            creditTextField2.setText(String.valueOf(creditData.get(2).getValue()));
            creditTextField3.setText(String.valueOf(creditData.get(3).getValue()));
            creditTextField4.setText(String.valueOf(creditData.get(4).getValue()));
            creditTextField5.setText(String.valueOf(creditData.get(5).getValue()));
            creditTextField6.setText(String.valueOf(creditData.get(6).getValue()));
            creditTextField7.setText(String.valueOf(creditData.get(7).getValue()));
            discountComboBox1.setValue(creditData.get(1).getDiscount());
            discountComboBox2.setValue(creditData.get(2).getDiscount());
            discountComboBox3.setValue(creditData.get(3).getDiscount());
            discountComboBox4.setValue(creditData.get(4).getDiscount());
            discountComboBox5.setValue(creditData.get(5).getDiscount());
            discountComboBox6.setValue(creditData.get(6).getDiscount());
            discountComboBox7.setValue(creditData.get(7).getDiscount());
        }else{
            System.out.println("没数据");
        }
    }

    /**
     * 点击编辑按钮，编辑会员等级信息
     */
    @FXML
    private void edit(){
        creditTextField1.setDisable(false);
        creditTextField2.setDisable(false);
        creditTextField3.setDisable(false);
        creditTextField4.setDisable(false);
        creditTextField5.setDisable(false);
        creditTextField6.setDisable(false);
        creditTextField7.setDisable(false);
        discountComboBox1.setDisable(false);
        discountComboBox6.setDisable(false);
        discountComboBox2.setDisable(false);
        discountComboBox3.setDisable(false);
        discountComboBox4.setDisable(false);
        discountComboBox5.setDisable(false);
        discountComboBox7.setDisable(false);
    }

    /**
     * 点击确认修改按钮，保存会员等级信息
     */
    @FXML
    private void confirm(){
        creditTextField1.setDisable(true);
        creditTextField2.setDisable(true);
        creditTextField3.setDisable(true);
        creditTextField4.setDisable(true);
        creditTextField5.setDisable(true);
        creditTextField6.setDisable(true);
        creditTextField7.setDisable(true);
        discountComboBox1.setDisable(true);
        discountComboBox6.setDisable(true);
        discountComboBox2.setDisable(true);
        discountComboBox3.setDisable(true);
        discountComboBox4.setDisable(true);
        discountComboBox5.setDisable(true);
        discountComboBox7.setDisable(true);

    }

}
