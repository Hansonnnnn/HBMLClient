package presentation.view.WebMarketerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/5.
 */
public class AddWebPromotionUI extends VBox{
    public AddWebPromotionUI(VBox infoVBox,VBox beforeVBox,Stage stage){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmarketerfxml/AddWebPromotion.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }
        AddWebPromotionUIController addWebPromotionUIController=fxmlLoader.getController();
        addWebPromotionUIController.init(infoVBox,beforeVBox,stage);
        this.getStylesheets().add(AddWebPromotionUI.class.getResource("webmarketer.css").toExternalForm());
    }
}
