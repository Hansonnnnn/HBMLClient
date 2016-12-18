package presentation.view.WebManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/29.
 */
public class SearchHotelStaffUI extends VBox{
    public SearchHotelStaffUI(VBox infoVBox,Stage stage){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmanagerfxml/SearchHotelStaff.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }
        SearchHotelStaffUIController searchHotelStaffUIController=fxmlLoader.getController();
        searchHotelStaffUIController.init(infoVBox,this,stage);
        this.getStylesheets().add(SearchHotelStaffUI.class.getResource("webmanager.css").toExternalForm());
    }
}
