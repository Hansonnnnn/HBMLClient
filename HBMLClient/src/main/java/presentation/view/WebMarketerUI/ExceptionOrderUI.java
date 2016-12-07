package presentation.view.WebMarketerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/1.
 */
public class ExceptionOrderUI extends VBox{
    public ExceptionOrderUI(){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmarketerfxml/ExceptionOrder.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        ExceptionOrderUIController exceptionOrderUIController=fxmlLoader.getController();
        exceptionOrderUIController.init();
        this.getStylesheets().add(ExceptionOrderUI.class.getResource("webmarketer.css").toExternalForm());
    }
}
