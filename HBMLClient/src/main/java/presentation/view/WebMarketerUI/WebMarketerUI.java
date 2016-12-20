package presentation.view.WebMarketerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vo.UserVO;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/1.
 */
public class WebMarketerUI extends Scene {
    public WebMarketerUI(Parent root, Stage stage, Scene beforeScene,UserVO userVO) {
        super(root);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmarketerfxml/WebMarketer1.fxml"));
        try{
            this.setRoot(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        WebMarketerUIController webMarketerUIController=fxmlLoader.getController();
        webMarketerUIController.init(stage,beforeScene,userVO);
    }
}
