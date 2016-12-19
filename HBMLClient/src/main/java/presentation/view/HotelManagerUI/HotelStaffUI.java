package presentation.view.HotelManagerUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vo.UserVO;

import java.io.IOException;

/**
 * Created by LENOVO on 2016/12/1.
 */
public class HotelStaffUI extends Scene{

    public HotelStaffUI(Parent root, Stage stage, Scene beforeScene, UserVO userVO) {
        super(root);
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ManagerFxml/HotelStaff1.fxml"));
        try{
            this.setRoot(fxmlLoader.load());
        }catch (IOException e) {
            e.printStackTrace();
        }

        HotelStaffUIController hotelStaffUIController=fxmlLoader.getController();
        hotelStaffUIController.init(stage,beforeScene,userVO);
    }
}
