package presentation.view.HotelManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/25.
 */
public class InputRoomUI extends Scene{
    public InputRoomUI(Parent root, Stage stage, Scene beforeScene, Scene loginScene) {
        super(root);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/InputRoom.fxml"));
        try{
            this.setRoot(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        InputRoomUIController inputRoomUIController=fxmlLoader.getController();
        inputRoomUIController.init(stage,beforeScene,loginScene);

        this.getStylesheets().add(InputRoomUI.class.getResource("manager.css").toExternalForm());
    }
}
