package presentation.view.WebManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vo.UserVO;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/29.
 */
public class WebManagerUI extends Scene{
    public WebManagerUI(Parent root, Stage stage, Scene beforeScene, UserVO userVO) {
        super(root);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmanagerfxml/WebManager.fxml"));
        try{
            this.setRoot(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        WebManagerUIController userInfoUIController=fxmlLoader.getController();
        userInfoUIController.init(stage,beforeScene,userVO);
        this.getStylesheets().add(WebManagerUI.class.getResource("webmanager.css").toExternalForm());
    }
}


