package presentation.view.HotelManagerUI;

import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/26.
 */
public class HotelInfoUI extends VBox{
    public HotelInfoUI(Stage stage,VBox infoVBox) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/HotelInfo.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        HotelInfoUIController hotelInfoUIController=fxmlLoader.getController();
        hotelInfoUIController.init(stage,infoVBox);
    }
}
