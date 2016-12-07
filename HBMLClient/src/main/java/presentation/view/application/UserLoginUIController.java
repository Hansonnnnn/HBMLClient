package presentation.view.application;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.stage.Stage;

/**
 * Created by LENOVO on 2016/12/7.
 */
public class UserLoginUIController {


    private Stage stage;
    public void init(Stage stage){
        this.stage=stage;
    }

    /**
     * 点击找回密码按钮，跳转至对应界面
     */
    @FXML
    private void toUserSeek(){
        stage.setScene(new UserSeekUI(new Group(),stage));
    }

    /**
     * 点击马上注册按钮，跳转至对应界面
     */
    @FXML
    private void toUserRegister(){
        stage.setScene(new UserRegisterUI(new Group(),stage));
    }

    /**
     * 点击工作人员登录按钮，跳转至对应界面
     */
    @FXML
    private void toWorkerLogin(){
        stage.setScene(new WorkerLoginUI(new Group(),stage));
    }
}
