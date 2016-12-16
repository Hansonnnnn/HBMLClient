package presentation.view.customerui.customerui;

import java.io.IOException;
import java.util.Date;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vo.HotelVO;

public class HotelInfoUI extends Scene
{
	public HotelInfoUI(Parent root, Stage stage, Scene preScene,HotelVO hotelVO, Date checkinTime)
	{
		super(root);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/HotelInfo.fxml"));
		try
		{
			this.setRoot(fxmlLoader.load());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		HotelInfoUIController controller = fxmlLoader.getController();
		controller.init(stage, preScene,hotelVO,checkinTime);
	}
}
