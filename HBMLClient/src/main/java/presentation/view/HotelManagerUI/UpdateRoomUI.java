package presentation.view.HotelManagerUI;

import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/26.
 */
public class UpdateRoomUI extends Scene{

    public UpdateRoomUI(Parent root, Stage stage, Scene beforeScene, Scene loginScene) {
        super(root);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/UpdateRoom.fxml"));
        try{
            this.setRoot(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        UpdateRoomUIController updateRoomUIController=fxmlLoader.getController();
        updateRoomUIController.init(stage,beforeScene,this,loginScene);
        this.getStylesheets().add(UpdateRoomUI.class.getResource("manager.css").toExternalForm());
    }
}
