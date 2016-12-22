package presentation.view.WebMarketerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/2.
 */
public class WebPromotionUI extends VBox{
    public WebPromotionUI(VBox infoVBox,Stage stage) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmarketerfxml/WebPromotion.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }
        WebPromotionUIController webPromotionUIController=fxmlLoader.getController();
        try{
            webPromotionUIController.init(infoVBox,this,stage);
        }catch(Exception e){

        }
    }
}
