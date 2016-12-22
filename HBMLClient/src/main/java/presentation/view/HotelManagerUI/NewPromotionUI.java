package presentation.view.HotelManagerUI;

import javafx.beans.NamedArg;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vo.UserVO;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/27.
 */
public class NewPromotionUI extends VBox {
    public NewPromotionUI(VBox infoVBox, VBox beforeVBox, UserVO userVO,Stage stage) {

        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/NewPromotion.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        NewPromotionUIController newPromotionUIController=fxmlLoader.getController();
        newPromotionUIController.init(infoVBox,beforeVBox,userVO,stage);
    }
}
