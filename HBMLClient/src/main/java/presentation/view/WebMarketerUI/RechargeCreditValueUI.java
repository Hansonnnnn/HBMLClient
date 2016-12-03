package presentation.view.WebMarketerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/3.
 */
public class RechargeCreditValueUI extends VBox{
    public RechargeCreditValueUI(VBox infoVBox){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmarketerfxml/RechargeCreditValue.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        RechargeCreditValueUIController rechargeCreditValueUIController=fxmlLoader.getController();
        rechargeCreditValueUIController.init(infoVBox);
    }
}
