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
public class HotelInfoUI extends Scene{
    public HotelInfoUI(Parent root, Stage stage, Scene beforeScene, Scene loginScene) {
        super(root);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/HotelInfo.fxml"));
        try{
            this.setRoot(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        HotelInfoUIController hotelInfoUIController=fxmlLoader.getController();
        hotelInfoUIController.init(stage,beforeScene,loginScene);
        this.getStylesheets().add(HotelInfoUI.class.getResource("manager.css").toExternalForm());
    }
}
