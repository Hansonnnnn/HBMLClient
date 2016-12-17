package presentation.view.WebMarketerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/3.
 */
public class SearchCustomerUI extends VBox{
    public SearchCustomerUI(VBox infoVBox,Stage stage){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("webmarketerfxml/SearchCustomer.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        SearchCustomerUIController searchCustomerUIController=fxmlLoader.getController();
        searchCustomerUIController.init(infoVBox,this,stage);
        this.getStylesheets().add(SearchCustomerUI.class.getResource("webmarketer.css").toExternalForm());
    }
}
