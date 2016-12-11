package presentation.view.HotelManagerUI;

import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/1.
 */
public class OrderBrowseUI extends VBox{
    public OrderBrowseUI(VBox infoVBox) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/OrderBrowse.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        OrderBrowseUIController orderBrowseUIController=fxmlLoader.getController();
        orderBrowseUIController.init(infoVBox,this);
    }
}
