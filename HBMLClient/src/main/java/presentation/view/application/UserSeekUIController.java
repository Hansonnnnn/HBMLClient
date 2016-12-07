package presentation.view.application;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by LENOVO on 2016/12/7.
 */
public class UserSeekUIController {

    private Stage stage;
    public void init(Stage stage){
        this.stage=stage;
    }

    /**
     * 点击返回按钮，返回至用户登录界面
     */
    @FXML
    private void back(){
        stage.setScene(new UserLoginUI(new Group(),stage));
    }
}
