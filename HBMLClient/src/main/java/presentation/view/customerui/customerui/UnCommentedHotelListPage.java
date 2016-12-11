package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class UnCommentedHotelListPage extends VBox
{
		public UnCommentedHotelListPage()
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/UnCommentedHotelList.fxml"));
			try
			{
				this.getChildren().add(fxmlLoader.load());
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
			UnCommentedHotelListPageController controller = fxmlLoader.getController();
			controller.init();
		}
}
