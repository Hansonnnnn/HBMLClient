package presentation.view.HotelManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vo.OrderVO;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/25.
 */
public class HotelOrderInfoUI extends VBox{

    public HotelOrderInfoUI(VBox infoVBox, VBox beforeVBox, OrderVO orderVO) {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/HotelOrderInfo.fxml"));
            try{
                this.getChildren().add(fxmlLoader.load());
            }catch (IOException e){
                e.printStackTrace();
        }

        HotelOrderInfoUIController hotelOrderInfoUIController = fxmlLoader.getController();
        hotelOrderInfoUIController.getScene(infoVBox,beforeVBox,orderVO);
    }
}
