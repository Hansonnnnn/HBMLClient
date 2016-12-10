package presentation.view.HotelManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/10.
 */
public class RoomTypeInfoUI extends VBox{
    public RoomTypeInfoUI(VBox infoVBox,VBox beforeVBox){
               FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/RoomTypeInfo.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        RoomTypeInfoUIController roomTypeInfoUIController=fxmlLoader.getController();
        roomTypeInfoUIController.init(infoVBox,this,beforeVBox);
    }
}
