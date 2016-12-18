package presentation.view.WebManagerUI;

import businesslogic.userbl.UserWebManagerImpl;
import businesslogic.userbl.UserWebMarketerImpl;
import businesslogicservice.userblservice.UserWebManagerService;
import businesslogicservice.userblservice.UserWebMarketerService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.UserType;
import vo.UserVO;


/**
 * Created by LENOVO on 2016/11/29.
 */
public class WebMarketerInfoUIController {

    @FXML private TextField seekMarketerIdTextField;
    @FXML private Label tipLabel;
    @FXML private VBox infoVBox;
    @FXML private TextField marketerIdTextField;
    @FXML private TextField marketerAccountTextField;
    @FXML private TextField marketerPasswordTextField;
    @FXML private TextField marketerNameTextField;
    @FXML private TextField marketerPhoneTextField;

    private UserWebMarketerService webMarketerService;
    private UserWebManagerService userWebManagerService;
    private UserVO userVO;
    public void init(){
        webMarketerService=new UserWebMarketerImpl();
        userWebManagerService=new  UserWebManagerImpl();
        infoVBox.setVisible(false);
    }

    /**
     * 点击编辑按钮,编辑网站营销人员信息
     */
    @FXML
    private void edit(){
//        marketerIdTextField.setDisable(false);
        marketerAccountTextField.setDisable(false);
        marketerPasswordTextField.setDisable(false);
        marketerNameTextField.setDisable(false);
        marketerPhoneTextField.setDisable(false);

    }

    /**
     * 点击确认修改按钮,保存信息
     */
    @FXML
    private void confirm(){
//        marketerIdTextField.setDisable(true);
        marketerAccountTextField.setDisable(true);
        marketerPasswordTextField.setDisable(true);
        marketerNameTextField.setDisable(true);
        marketerPhoneTextField.setDisable(true);
        try{
            //保存信息
            UserVO newUserVO=new UserVO(userVO.getUserID(), UserType.WebMarketer,marketerAccountTextField.getText(),
                    marketerPasswordTextField.getText(),marketerNameTextField.getText(),marketerPhoneTextField.getText(),
                    userVO.getPortrait(),userVO.getCreditValue(),userVO.getMemberType(),userVO.getMemberInfo(),userVO.getRank(),
                    userVO.getWorkid(),userVO.getHotelid());
            userWebManagerService.modifyUser(newUserVO);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 点击搜索按钮,显示网站营销人员信息
     */
    @FXML
    private void seekMarketerInfo(){
        try{
            if((!seekMarketerIdTextField.getText().equals(""))&&(seekMarketerIdTextField.getText()!=null)){
                UserVO userVO=webMarketerService.getUserData(Integer.parseInt(seekMarketerIdTextField.getText()));
                this.userVO=userVO;
                //将网站营销人员的信息显示出来
                if(userVO!=null){
                    marketerIdTextField.setText(String.valueOf(userVO.getUserID()));
                    marketerAccountTextField.setText(userVO.getAccountName());
                    marketerPasswordTextField.setText(userVO.getPassword());
                    marketerNameTextField.setText(userVO.getName());
                    marketerPhoneTextField.setText(userVO.getContact());
                    infoVBox.setVisible(true);
                    tipLabel.setVisible(false);
                }else{
                    infoVBox.setVisible(false);
                    tipLabel.setVisible(true);
                }
            }else{
                infoVBox.setVisible(false);
                tipLabel.setVisible(true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
