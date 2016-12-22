package presentation.view.HotelManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vo.UserVO;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/27.
 */
public class HotelPromotionUI extends VBox{
    public HotelPromotionUI(VBox infoVBox, Stage stage, UserVO userVO) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/HotelPromotion1.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        HotelPromotionUIController hotelPromotionUIController=fxmlLoader.getController();
        hotelPromotionUIController.init(infoVBox,this,stage,userVO);
    }
}
