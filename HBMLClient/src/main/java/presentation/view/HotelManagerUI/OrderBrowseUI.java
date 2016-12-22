package presentation.view.HotelManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import vo.UserVO;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/1.
 */
public class OrderBrowseUI extends VBox{
    public OrderBrowseUI(VBox infoVBox, UserVO userVO) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/OrderBrowse1.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        OrderBrowseUIController orderBrowseUIController=fxmlLoader.getController();
        orderBrowseUIController.init(infoVBox,this,userVO);
    }
}
