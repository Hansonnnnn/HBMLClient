package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HotelListPageUI extends Scene
{
	public HotelListPageUI(Parent root, Stage stage, Scene preScene, String searchInfo)
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
		controller.init(stage, preScene);
	}
}
