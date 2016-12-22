package presentation.view.HotelManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vo.RoomInfoVO;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/10.
 */
public class RoomInfoUI extends VBox{
    public RoomInfoUI(VBox infoVBox, VBox beforeVBox, RoomInfoVO roomInfoVO, Stage stage){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/RoomInfo.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        RoomInfoUIController roomInfoUIController=fxmlLoader.getController();
        roomInfoUIController.init(infoVBox,beforeVBox,roomInfoVO,stage);
    }
}
