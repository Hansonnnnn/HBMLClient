package presentation.view.WebMarketerUI;

import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/1.
 */
public class WebMarketerUI extends Scene {
    public WebMarketerUI(Parent root, Stage stage,Scene beforeScene) {
        super(root);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmarketerfxml/WebMarketer.fxml"));
        try{
            this.setRoot(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        WebMarketerUIController webMarketerUIController=fxmlLoader.getController();
        webMarketerUIController.init(stage,beforeScene);
        this.getStylesheets().add(WebMarketerUI.class.getResource("webmarketer.css").toExternalForm());
    }
}
