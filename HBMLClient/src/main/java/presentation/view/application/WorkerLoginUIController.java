package presentation.view.application;

import businesslogic.userbl.UserLogImpl;
import businesslogic.userbl.UserStaffImpl;
import businesslogic.userbl.UserWebManagerImpl;
import businesslogic.userbl.UserWebMarketerImpl;
import businesslogicservice.userblservice.UserLogService;
import businesslogicservice.userblservice.UserStaffService;
import businesslogicservice.userblservice.UserWebManagerService;
import businesslogicservice.userblservice.UserWebMarketerService;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import message.ResultMessage;
import model.UserType;
import presentation.view.HotelManagerUI.HotelStaffUI;
import presentation.view.WebManagerUI.WebManagerUI;
import presentation.view.WebMarketerUI.WebMarketerUI;
import vo.UserVO;

/**
 * Created by LENOVO on 2016/12/7.
 */
public class WorkerLoginUIController {

    @FXML private TextField workerAccountTextField;
    @FXML private TextField workerPasswordTextField;

    private Stage stage;
    private Scene thisScene;
//    private UserStaffService userStaffService;
//    private UserWebManagerService userWebManagerService;
//    private UserWebMarketerService webMarketerService;
    private UserLogService userLogService;
    public void init(Stage stage,Scene thisScene){
        this.stage=stage;
        this.thisScene=thisScene;
//        userStaffService=new UserStaffImpl();
//        userWebManagerService=new UserWebManagerImpl();
//        webMarketerService=new UserWebMarketerImpl();
        userLogService=new UserLogImpl();
        workerAccountTextField.setText("01");
        workerPasswordTextField.setText("admin");
    }

    /**
     * 点击返回按钮，返回至用户登录界面
     */
    @FXML
    private void back(){
        stage.setScene(new UserLoginUI(new Group(),stage));
    }

    /**
     * 点击安全登录按钮，进入相应的工作界面
     */
    @FXML
    private void workerLogin(){
        try{
////            ResultMessage message=webMarketerService.login(workerAccountTextField.getText(),workerPasswordTextField.getText());
//            ResultMessage message=userWebManagerService.login(workerAccountTextField.getText(),workerPasswordTextField.getText());
            ResultMessage message=userLogService.login(workerAccountTextField.getText(),workerPasswordTextField.getText());
            System.out.println(message);
            if(message.equals(ResultMessage.wrongPassword)){
                new MyDialog(stage,"密码错误，请重新输入",0);
            }else if(message.equals(ResultMessage.notexist)){
                new MyDialog(stage,"该用户不存在",0);
            }else if(message.equals(ResultMessage.success)){
                UserVO userVO=userLogService.getUserData(workerAccountTextField.getText());
                System.out.println("  aa  "+userVO.getUserType());
                if(userVO==null){
                    System.out.println("userVO为空");
                }
                if(userVO.getUserType().equals(UserType.Staff)){
                    stage.setScene(new HotelStaffUI(new Group(),stage,thisScene,userVO));
                }else if(userVO.getUserType().equals(UserType.WebManager)){
                    stage.setScene(new WebManagerUI(new Group(),stage,thisScene,userVO));
                }else if(userVO.getUserType().equals(UserType.WebMarketer)){
                    stage.setScene(new WebMarketerUI(new Group(),stage,thisScene,userVO));
                }
            }
//            stage.setScene(new WebMarketerUI(new Group(),stage,thisScene));
//            stage.setScene(new HotelStaffUI(new Group(),stage,thisScene));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 设置stage位于屏幕中间
     * @param newStage
     */
    private void centerStage(Stage newStage){
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        newStage.setX((primScreenBounds.getWidth() - newStage.getWidth()) / 2);
        newStage.setY((primScreenBounds.getHeight() - newStage.getHeight()) / 2);
    }
}
