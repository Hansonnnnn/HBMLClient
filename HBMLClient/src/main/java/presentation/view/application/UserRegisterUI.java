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
public class UserRegisterUI extends Scene{
    public UserRegisterUI(Parent root, Stage stage) {
        super(root);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("loginfxml/UserRegister.fxml"));
        try{
            this.setRoot(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        UserRegisterUIController userRegisterUIController=fxmlLoader.getController();
        userRegisterUIController.init(stage);
    }
}
