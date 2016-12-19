package presentation.view.WebManagerUI;

import businesslogic.userbl.UserWebManagerImpl;
import businesslogicservice.userblservice.UserWebManagerService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MemberType;
import model.UserType;
import presentation.view.application.MyDialog;
import vo.UserVO;

/**
 * Created by LENOVO on 2016/11/29.
 */
public class AddWebMarketerUIController {
    @FXML private TextField accountTextField;
    @FXML private TextField passwordTextField;
    @FXML private TextField nameTextField;
    @FXML private TextField idTextField;
    @FXML private TextField phoneTextField;

    private Stage stage;
    private UserWebManagerService userWebManagerService;
    public void init(Stage stage){
        userWebManagerService=new UserWebManagerImpl();
        this.stage=stage;
    }

    /**
     * 点击确认按钮，保存
     */
    @FXML
    private void confirm(){
        try{
            if((!accountTextField.getText().equals(""))&&(accountTextField!=null)&&
                    (!passwordTextField.getText().equals(""))&&(passwordTextField!=null)&&
                    (!nameTextField.getText().equals(""))&&(nameTextField!=null)&&
                    (!phoneTextField.getText().equals(""))&&(phoneTextField!=null)){
                UserVO userVO=new UserVO(0, UserType.WebMarketer,accountTextField.getText(),
                        passwordTextField.getText(),nameTextField.getText(),phoneTextField.getText(),null,0, MemberType.Tourist,null,
                        0,null,0);
                userWebManagerService.addUser(userVO);
                accountTextField.setText("");
                passwordTextField.setText("");
                nameTextField.setText("");
                idTextField.setText("");
                phoneTextField.setText("");
                new MyDialog(stage,"添加成功",2);
            }else{
                new MyDialog(stage,"请将网站营销人员基本信息填写完整",0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
