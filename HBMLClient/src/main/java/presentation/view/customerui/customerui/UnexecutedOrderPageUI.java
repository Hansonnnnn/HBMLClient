package presentation.view.customerui.customerui;

import java.io.IOException;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UnexecutedOrderPageUI extends VBox
{
		public UnexecutedOrderPageUI(Stage stage,int userID)
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customeruiFXML/UnexecutedOrderPage.fxml"));
			try
			{
				this.getChildren().add(fxmlLoader.load());
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
			UnexecutedOrderPageController controller = fxmlLoader.getController();
			controller.init(stage,userID);
		}
}
