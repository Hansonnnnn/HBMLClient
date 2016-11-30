package presentation.view.HotelManagerUI;

import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/27.
 */
public class HotelPromotionUI extends Scene{
    public HotelPromotionUI(Parent root,Stage stage,Scene beforeScene,Scene loginScene) {
        super(root);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/HotelPromotion.fxml"));
        try{
            this.setRoot(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        HotelPromotionUIController hotelPromotionUIController=fxmlLoader.getController();
        hotelPromotionUIController.init(stage,beforeScene,this,loginScene);
        this.getStylesheets().add(HotelPromotionUI.class.getResource("manager.css").toExternalForm());
    }
}
