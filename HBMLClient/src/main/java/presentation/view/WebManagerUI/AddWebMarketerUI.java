package presentation.view.WebManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/29.
 */
public class AddWebMarketerUI extends VBox{
    public AddWebMarketerUI(){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmanagerfxml/AddWebMarketer.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        AddWebMarketerUIController addWebMarketerUIController=fxmlLoader.getController();
        addWebMarketerUIController.init();
        this.getStylesheets().add(AddWebMarketerUI.class.getResource("webmanager.css").toExternalForm());
    }
}
