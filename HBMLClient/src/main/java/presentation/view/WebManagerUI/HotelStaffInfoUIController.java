package presentation.view.WebManagerUI;

import businesslogic.hotelInfobl.HotelWebManagerImpl;
import businesslogic.userbl.UserWebManagerImpl;
import businesslogicservice.hotelinfoblservice.HotelWebManagerService;
import businesslogicservice.userblservice.UserWebManagerService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.UserType;
import presentation.view.application.MyDialog;
import vo.UserVO;

/**
 * Created by LENOVO on 2016/12/9.
 */
public class HotelStaffInfoUIController {

    @FXML private TextField staffIdTextField;
    @FXML private TextField staffAccountTextField;
    @FXML private TextField staffPasswordTextField;
    @FXML private TextField staffNameTextField;
    @FXML private TextField staffHotelNameTextField;
    @FXML private TextField staffPhoneTextField;

    private VBox infoVBox;
    private VBox beforeVBox;
    private Stage stage;
    private UserVO userVO;
    private UserWebManagerService userWebManagerService;
    public void init(VBox infoVBox, VBox beforeVBox, Stage stage, UserVO userVO){
        this.infoVBox=infoVBox;
        this.beforeVBox=beforeVBox;
        this.stage=stage;
        this.userVO=userVO;
        userWebManagerService=new UserWebManagerImpl();
        staffAccountTextField.setText(userVO.getAccountName());
        staffPasswordTextField.setText(userVO.getPassword());
        staffNameTextField.setText(userVO.getName());
        staffPhoneTextField.setText(userVO.getContact());
    }

    /**
     * 点击返回按钮
     */
    @FXML
    private void back(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(beforeVBox);
    }

    /**
     * 点击编辑按钮，编辑酒店工作人员信息
     */
    @FXML
    private void edit(){
        staffIdTextField.setDisable(false);
//        staffAccountTextField.setDisable(false);
        staffPasswordTextField.setDisable(false);
        staffNameTextField.setDisable(false);
        staffHotelNameTextField.setDisable(false);
        staffPhoneTextField.setDisable(false);
    }

    /**
     * 点击确认修改按钮，保存信息
     */
    @FXML
    private void confirm(){
        staffIdTextField.setDisable(true);
//        staffAccountTextField.setDisable(true);
        staffPasswordTextField.setDisable(true);
        staffNameTextField.setDisable(true);
        staffHotelNameTextField.setDisable(true);
        staffPhoneTextField.setDisable(true);
        try{
            if((!staffPasswordTextField.getText().equals(""))&&(staffPasswordTextField.getText()!=null)&&
                    (!staffNameTextField.getText().equals(""))&&(staffNameTextField.getText()!=null)&&
                    (!staffPhoneTextField.getText().equals(""))&&(staffPhoneTextField!=null)){
                UserVO newUserVO=new UserVO(userVO.getUserID(), UserType.Staff,userVO.getAccountName(),staffPasswordTextField.getText(),
                        staffNameTextField.getText(),staffPhoneTextField.getText(),userVO.getPortrait(),userVO.getCreditValue(),
                        userVO.getMemberType(),userVO.getMemberInfo(),userVO.getRank(),userVO.getWorkid(),userVO.getHotelid());
                userWebManagerService.modifyUser(newUserVO);
            }else{
                new MyDialog(stage,"请将酒店工作人员信息填写完整!",0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
