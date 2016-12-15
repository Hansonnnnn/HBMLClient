package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HotelListPageUI extends Scene
{
	public HotelListPageUI(Parent root, Stage stage, Scene preScene, String searchInfo, boolean state)
	{
		super(root);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/HotelListPage.fxml"));
		try{
			this.setRoot(fxmlLoader.load());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		HotelListPageController controller = fxmlLoader.getController();
		controller.init(stage, preScene, searchInfo, state);
	}
	
	public HotelListPageUI(Parent root, Stage stage, Scene preScene, String address, String region, String checkinTime, String checkoutTime, int star,boolean state)
	{
		super(root);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/HotelListPage.fxml"));
		try{
			this.setRoot(fxmlLoader.load());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		HotelListPageController controller = fxmlLoader.getController();
		controller.init(stage, preScene, address, region, checkinTime, checkoutTime, star,state);
	}
}
