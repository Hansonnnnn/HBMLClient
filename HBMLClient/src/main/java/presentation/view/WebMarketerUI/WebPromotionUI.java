package presentation.view.WebMarketerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/2.
 */
public class WebPromotionUI extends VBox{
    public WebPromotionUI(){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmarketerfxml/WebPromotion.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }
        WebPromotionUIController webPromotionUIController=fxmlLoader.getController();
        webPromotionUIController.init();
    }
}
