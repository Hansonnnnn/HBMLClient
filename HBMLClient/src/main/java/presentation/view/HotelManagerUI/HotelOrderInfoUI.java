package presentation.view.HotelManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/25.
 */
public class HotelOrderInfoUI extends Scene{

    public HotelOrderInfoUI(Parent root,Stage stage,Scene beforeScene,Scene loginScene) {
        super(root);
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/HotelOrderInfo.fxml"));
            try{
                this.setRoot(fxmlLoader.load());
            }catch (IOException e){
                e.printStackTrace();
        }

        HotelOrderInfoUIController hotelOrderInfoUIController = fxmlLoader.getController();
        hotelOrderInfoUIController.getScene(stage,beforeScene,loginScene);
        this.getStylesheets().add(HotelOrderInfoUI.class.getResource("manager.css").toExternalForm());
    }
}
