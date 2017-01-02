package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UnCommentedHotelListPage extends VBox
{
		public UnCommentedHotelListPage(Stage stage, Scene commentFirstPageScene,int userID)
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customeruiFXML/UnCommentedHotelList.fxml"));
			try
			{
				this.getChildren().add(fxmlLoader.load());
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
			UnCommentedHotelListPageController controller = fxmlLoader.getController();
			controller.init(stage, commentFirstPageScene,userID);
		}
}
