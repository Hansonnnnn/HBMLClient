package presentation.view.WebManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/29.
 */
public class WebMarketerInfoUI extends VBox{
    public WebMarketerInfoUI(){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmanagerfxml/WebMarketerInfo.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        WebMarketerInfoUIController webMarketerUIController=fxmlLoader.getController();
        webMarketerUIController.init();
        this.getStylesheets().add(WebManagerUIController.class.getResource("webmanager.css").toExternalForm());
    }

}
