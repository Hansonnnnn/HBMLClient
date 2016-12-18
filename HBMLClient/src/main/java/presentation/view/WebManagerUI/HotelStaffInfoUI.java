package presentation.view.WebManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import presentation.view.HotelManagerUI.HotelStaffUI;
import vo.UserVO;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/9.
 */
public class HotelStaffInfoUI extends VBox{
    public HotelStaffInfoUI(VBox infoVBox, VBox beforeVBox, Stage stage, UserVO userVO){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmanagerfxml/HotelStaffinfo.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        HotelStaffInfoUIController hotelStaffinfoUIController=fxmlLoader.getController();
        hotelStaffinfoUIController.init(infoVBox,beforeVBox,stage,userVO);
    }
}
