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
public class PromotionInfoUI  extends Scene{
    public PromotionInfoUI(Parent root, Stage stage,Scene beforeScene,Scene loginScene) {
        super(root);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/PromotionInfo.fxml"));
        try{
            this.setRoot(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        PromotionInfoUIController promotionInfoUIController=fxmlLoader.getController();
        promotionInfoUIController.init(stage,beforeScene,loginScene);
        this.getStylesheets().add(PromotionInfoUI.class.getResource("manager.css").toExternalForm());
    }
}
