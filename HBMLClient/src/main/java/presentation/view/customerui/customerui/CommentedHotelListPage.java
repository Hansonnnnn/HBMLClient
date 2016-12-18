package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CommentedHotelListPage extends VBox
{
		public CommentedHotelListPage(Stage stage,Scene commentFirstPageScene)
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
			controller.init(stage,commentFirstPageScene);
		}
}
