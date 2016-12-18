package presentation.view.WebManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/29.
 */
public class AddHotelUI extends VBox{
    public AddHotelUI(Stage stage){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmanagerfxml/AddHotel.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        AddHotelUIController addHotelUIController=fxmlLoader.getController();
        addHotelUIController.init(stage);
        this.getStylesheets().add(AddHotelUI.class.getResource("webmanager.css").toExternalForm());
    }

}
