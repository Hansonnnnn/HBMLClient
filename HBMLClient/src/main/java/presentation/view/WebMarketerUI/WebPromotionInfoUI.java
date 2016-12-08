package presentation.view.WebMarketerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/8.
 */
public class WebPromotionInfoUI extends VBox{
    public WebPromotionInfoUI(VBox infoVBox,VBox beforeVBox){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmarketerfxml/WebPromotionInfo.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        WebPromotionInfoUIController webPromotionInfoUIController=fxmlLoader.getController();
        webPromotionInfoUIController.init(infoVBox,beforeVBox);
    }
}
