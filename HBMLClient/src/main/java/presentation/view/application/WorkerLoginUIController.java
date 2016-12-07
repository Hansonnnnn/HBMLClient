package presentation.view.application;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.view.HotelManagerUI.HotelStaffUI;
import presentation.view.WebManagerUI.WebManagerUI;
import presentation.view.WebMarketerUI.WebMarketerUI;

/**
 * Created by LENOVO on 2016/12/7.
 */
public class WorkerLoginUIController {

    @FXML private TextField workerAccountTextField;
    @FXML private TextField workerPasswordTextField;

    private Stage stage;
    private Scene thisScene;
    public void init(Stage stage,Scene thisScene){
        this.stage=stage;
        this.thisScene=thisScene;
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
        if(workerAccountTextField.getText().equals("11")
                &&workerPasswordTextField.getText().equals("admin")){
//				primaryStage.setScene(new WebMarker(new Group(),primaryStage,scene));
            stage.setScene(new WebMarketerUI(new Group(),stage,thisScene));
        }else if(workerAccountTextField.getText().equals("01")
                &&workerPasswordTextField.getText().equals("admin")){
           stage.setScene(new HotelStaffUI(new Group(),stage,thisScene));
        }else if(workerAccountTextField.getText().equals("10")
                &&workerPasswordTextField.getText().equals("admin")){
           stage.setScene(new WebManagerUI(new Group(),stage,thisScene));
        }
    }
}
