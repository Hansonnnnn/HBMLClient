package presentation.view.customerui.customerui;

import java.io.IOException;
import java.util.Date;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vo.HotelVO;
import vo.RoomInfoVO;
import vo.UserVO;

public class MakeOrderPage extends Scene
{
		public MakeOrderPage(Parent root, Stage stage, Scene preScene, HotelVO hotelVO, RoomInfoVO roomInfoVO,UserVO userVO, Date checkinTime)
		{
			super(root);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customeruiFXML/MakeOrderPage.fxml"));
			try
			{
				this.setRoot(fxmlLoader.load());
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
			MakeOrderPageController controller = fxmlLoader.getController();
			controller.init(stage, preScene, hotelVO, roomInfoVO,userVO, checkinTime);
		}
}
