package presentation.view.WebMarketerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/7.
 */
public class RegionPromotionUI extends VBox{
    public RegionPromotionUI(Stage stage){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmarketerfxml/RegionPromotion3.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        RegionPromotionUIController regionPromotionUIController=fxmlLoader.getController();
        regionPromotionUIController.init(stage);
    }
}
