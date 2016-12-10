package presentation.view.WebManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import presentation.view.HotelManagerUI.HotelStaffUI;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/9.
 */
public class HotelStaffinfoUI extends VBox{
    public HotelStaffinfoUI(VBox infoVBox,VBox beforeVBox){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmanagerfxml/HotelStaffinfo.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        HotelStaffinfoUIController hotelStaffinfoUIController=fxmlLoader.getController();
        hotelStaffinfoUIController.init(infoVBox,beforeVBox);
    }
}
