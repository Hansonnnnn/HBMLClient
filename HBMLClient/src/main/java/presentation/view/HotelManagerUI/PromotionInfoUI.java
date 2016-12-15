package presentation.view.HotelManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/27.
 */
public class PromotionInfoUI extends VBox{
    public PromotionInfoUI(VBox infoVBox,VBox beforeVBox) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/PromotionInfo1.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        PromotionInfoUIController promotionInfoUIController=fxmlLoader.getController();
        promotionInfoUIController.init(infoVBox,beforeVBox);
    }
}
