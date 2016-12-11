package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class CommentedHotelListPage extends VBox
{
		public CommentedHotelListPage()
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/CommentedHotelList.fxml"));
			try
			{
				this.getChildren().add(fxmlLoader.load());
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
			CommentedHotelListPageController controller = fxmlLoader.getController();
			controller.init();
		}
}
