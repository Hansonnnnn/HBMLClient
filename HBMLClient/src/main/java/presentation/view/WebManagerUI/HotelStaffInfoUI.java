package presentation.view.WebManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/29.
 */
public class HotelStaffInfoUI extends VBox{
    public HotelStaffInfoUI(){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmanagerfxml/HotelStaffInfo.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }
        HotelStaffInfoUIController hotelStaffInfoUIController=fxmlLoader.getController();
        hotelStaffInfoUIController.init();
        this.getStylesheets().add(HotelStaffInfoUI.class.getResource("webmanager.css").toExternalForm());
    }
}
