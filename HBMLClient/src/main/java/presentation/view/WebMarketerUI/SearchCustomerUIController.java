package presentation.view.WebMarketerUI;

import businesslogic.userbl.UserCustomerImpl;
import businesslogicservice.userblservice.UserCustomerService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import presentation.view.application.MyDialog;
import vo.UserVO;

/**
 * Created by LENOVO on 2016/12/3.
 */
public class SearchCustomerUIController {
    @FXML private TextField idTextField;

    private VBox infoVBox;
    private VBox thisVBox;
    private Stage stage;
    private UserCustomerService userCustomerService;
    public void init(VBox infoVBox,VBox thisVBox,Stage stage){
        this.stage=stage;
        this.infoVBox=infoVBox;
        this.thisVBox=thisVBox;
        userCustomerService=new UserCustomerImpl();
    }

    /**
     * 点击搜索按钮
     */
    @FXML
    private void toRechargeCreditValue(){
        try{
            if((!idTextField.getText().equals(""))&&(idTextField!=null)){
                UserVO userVO=userCustomerService.getUserData(Integer.parseInt(idTextField.getText()));
                if(userVO==null){
                    new MyDialog(stage,"未找到该客户",1);
                }else{
                    idTextField.setText("");
                    infoVBox.getChildren().remove(0);
                    infoVBox.getChildren().add(new RechargeCreditValueUI(infoVBox,stage,userVO));
                }
            }else{
                new MyDialog(stage,"请输入客户ID",0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
