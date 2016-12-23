package presentation.view.WebManagerUI;

import businesslogic.userbl.UserCustomerImpl;
import businesslogic.userbl.UserWebManagerImpl;
import businesslogicservice.userblservice.UserCustomerService;
import businesslogicservice.userblservice.UserWebManagerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.MemberType;
import model.MemberTypeHelper;
import vo.UserVO;

import javax.xml.soap.Text;

/**
 * Created by LENOVO on 2016/11/29.
 */
public class UserInfoUIContrller {

    @FXML private TextField seekIdTextField;
    @FXML private VBox infoVBox;
    @FXML private Label tipLabel;
    @FXML private TextField userIdTextField;
    @FXML private TextField userNameTextField;
    @FXML private TextField userAccountTextField;
    @FXML private TextField userPasswordTextField;
    @FXML private TextField userCreditValueTextField;
    @FXML private TextField userPhoneTextField;
    @FXML private ComboBox memberTypeComboBox;
    @FXML private TextField memberLevelTextField;
    @FXML private TextField memberInfoTextField;
    @FXML private ImageView userImageView;


    private ObservableList memberType;
    private UserCustomerService userCustomerService;
    private MemberTypeHelper memberTypeHelper;
    private UserWebManagerService userWebManagerService;
    private UserVO userVO;
    public void init(){
        userCustomerService=new UserCustomerImpl();
        userWebManagerService=new UserWebManagerImpl();
        memberTypeHelper=new MemberTypeHelper();
        initComboBox();
    }

    /**
     * 点击编辑按钮，编辑客户信息
     */
    @FXML
    private void edit(){
//        userIdTextField.setDisable(false);
        userNameTextField.setDisable(false);
        userAccountTextField.setDisable(false);
        userPhoneTextField.setDisable(false);
        memberTypeComboBox.setDisable(false);
//        memberLevelTextField.setDisable(false);
        memberInfoTextField.setDisable(false);
    }

    /**
     * 初始化memberTypeComboBox
     */
    private void initComboBox(){
        memberType=FXCollections.observableArrayList();
        memberType.add("非会员");
        memberType.add("普通会员");
        memberType.add("企业会员");
        memberTypeComboBox.setItems(memberType);
    }

    /**
     * 点击搜索按钮,显示用户信息
     */
    @FXML
    private void seekUserInfo(){
        try{
            if((!seekIdTextField.getText().equals(""))&&(seekIdTextField.getText()!=null)){
                UserVO userVO=userCustomerService.getUserData(seekIdTextField.getText());
                this.userVO=userVO;
                if(userVO!=null){
                	if(userVO.getPortrait()!=null){
                		 Image  headImage=new Image("file:///"+userVO.getPortrait().getAbsolutePath().replace('\\', '/').replaceAll("HBMLClient/HBMLClient", "Final_HBMSServer/HBMSServer"));
                		 userImageView.setImage(headImage);
                	}
                		
                    userIdTextField.setText(String.valueOf(userVO.getUserID()));
                    userNameTextField.setText(userVO.getName());
                    userAccountTextField.setText(userVO.getAccountName());
                    userPasswordTextField.setText(userVO.getPassword());
                    userCreditValueTextField.setText(String.valueOf(userVO.getCreditValue()));
                    userPhoneTextField.setText(userVO.getContact());
                    if(userVO.getMemberType()== MemberType.Tourist){
                        memberTypeComboBox.setValue("非会员");
                    }else if(userVO.getMemberType()==MemberType.Person){
                        memberTypeComboBox.setValue("普通会员");
                    }else if(userVO.getMemberType()==MemberType.Enterprise){
                        memberTypeComboBox.setValue("企业会员");
                    }
                    memberLevelTextField.setText(String.valueOf(userVO.getRank()));
                    memberInfoTextField.setText(userVO.getMemberInfo());
                    infoVBox.setVisible(true);
                    tipLabel.setVisible(false);
                }else{
                    tipLabel.setVisible(true);
                    infoVBox.setVisible(false);
                }
            }else{
                tipLabel.setVisible(true);
                infoVBox.setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 点击确认修改按钮，保存信息
     */
    @FXML
    private void confirm(){
//        userIdTextField.setDisable(true);
        userNameTextField.setDisable(true);
        userAccountTextField.setDisable(true);
        userPhoneTextField.setDisable(true);
        memberTypeComboBox.setDisable(true);
//        memberLevelTextField.setDisable(true);
        memberInfoTextField.setDisable(true);
        try{
            int memberType=0;
            if(memberTypeComboBox.getValue().equals("非会员")){
                memberType=0;
            }else if(memberTypeComboBox.getValue().equals("普通会员")){
                memberType=1;
            }else{
                memberType=2;
            }
            UserVO newUserVO=new UserVO(userVO.getUserID(),userVO.getUserType(),userAccountTextField.getText(),userPasswordTextField.getText(),
            userNameTextField.getText(),userPhoneTextField.getText(),userVO.getPortrait(),userVO.getCreditValue(),memberTypeHelper.getMemberType(memberType),
                    memberInfoTextField.getText(),userVO.getRank(),userVO.getWorkid(),userVO.getHotelid());
            userWebManagerService.modifyUser(newUserVO);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
