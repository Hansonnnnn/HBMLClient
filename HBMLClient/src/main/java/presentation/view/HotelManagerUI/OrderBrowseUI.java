package presentation.view.HotelManagerUI;

import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/1.
 */
public class OrderBrowseUI extends Scene{
    public OrderBrowseUI(Parent root,Stage stage,Scene beforeScene,Scene loginScene) {
        super(root);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/OrderBrowse.fxml"));
        try{
            this.setRoot(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        OrderBrowseUIController orderBrowseUIController=fxmlLoader.getController();
        orderBrowseUIController.init(stage,beforeScene,this,loginScene);
        this.getStylesheets().add(OrderBrowseUI.class.getResource("manager.css").toExternalForm());
    }
}
