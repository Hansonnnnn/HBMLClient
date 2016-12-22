package presentation.view.HotelManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vo.UserVO;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/11/25.
 */
public class InputRoomUI extends VBox{
    public InputRoomUI(VBox infoVBox, Stage stage, UserVO userVO) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/InputRoom2.fxml"));
        try{
            this.getChildren().add(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        InputRoomUIController inputRoomUIController=fxmlLoader.getController();
        inputRoomUIController.init(infoVBox,this,stage,userVO);
    }
}
