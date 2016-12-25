package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HistoryOrderPage extends Stage
{
		public HistoryOrderPage(int hotelID, int userID) 
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/HistoryOrderPage.fxml"));
			Parent root = null;
			try
			{
				root = fxmlLoader.load();
				Scene scene = new Scene(root);
				this.setScene(scene);
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
			HistoryOrderPageController controller = fxmlLoader.getController();
			controller.init(hotelID, userID);
		}
}
