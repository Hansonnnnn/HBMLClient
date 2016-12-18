package presentation.view.WebMarketerUI;

import businesslogic.creditbl.CreditWebMarketerImpl;
import businesslogicservice.creditblservice.CreditWebMarketerService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import presentation.view.WebManagerUI.UserInfoUI;
import presentation.view.application.MyDialog;
import vo.UserVO;

/**
 * Created by LENOVO on 2016/12/3.
 */
public class RechargeCreditValueUIController {
    @FXML private TextField rechargeTextField;
    @FXML private Label creditLabel;
    @FXML private Label nameLabel;
    @FXML private Label phoneLabel;

    private VBox infoVBox;
    private Stage stage;
    private UserVO userVO;
    private CreditWebMarketerService creditWebMarketerService;
    public void init(VBox infoVBox, Stage stage, UserVO userVO){
        this.stage=stage;
        this.userVO=userVO;
        this.infoVBox=infoVBox;
        System.out.println(userVO.getAccountName()+"    "+userVO.getContact()+"    "+userVO.getName());
        nameLabel.setText(userVO.getAccountName());
        phoneLabel.setText(userVO.getContact());
        creditLabel.setText(String.valueOf(userVO.getCreditValue()));
        creditWebMarketerService=new CreditWebMarketerImpl();
    }

    /**
     * 点击返回按钮，返回用户ID搜索界面
     */
    @FXML
    private void back(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new SearchCustomerUI(infoVBox,stage));
    }

    /**
     * 点击确认充值按钮，修改用户信用值
     */
    @FXML
    private void confirm(){
        try{
            if((!rechargeTextField.getText().equals(""))&&(rechargeTextField.getText()!=null)){
                creditWebMarketerService.addCreditValue(userVO.getUserID(),Integer.parseInt(rechargeTextField.getText()));
                creditLabel.setText(String.valueOf(Integer.parseInt(creditLabel.getText())+Integer.parseInt(rechargeTextField.getText())));
                rechargeTextField.setText("");
                new MyDialog(stage,"充值成功!",2);
            }else{
                new MyDialog(stage,"请输入充值金额",0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
