package presentation.view.WebManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/29.
 */
public class UserInfoUI extends VBox{
    public UserInfoUI(){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmanagerfxml/UserInfo1.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        UserInfoUIContrller userInfoUIContrller=fxmlLoader.getController();
        userInfoUIContrller.init();
        this.getStylesheets().add(UserInfoUI.class.getResource("webmanager.css").toExternalForm());
    }
}
