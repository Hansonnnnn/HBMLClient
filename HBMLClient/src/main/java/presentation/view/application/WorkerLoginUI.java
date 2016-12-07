package presentation.view.application;

import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/7.
 */
public class WorkerLoginUI extends Scene {
    public WorkerLoginUI(Parent root, Stage stage) {
        super(root);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("loginfxml/WorkerLogin.fxml"));
        try{
            this.setRoot(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        WorkerLoginUIController workerLoginUIController=fxmlLoader.getController();
        workerLoginUIController.init(stage,this);
    }
}
