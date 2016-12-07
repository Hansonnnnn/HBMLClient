package presentation.view.customerui.customerui;

import java.io.IOException;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class UnexecutedOrderPageUI extends VBox
{
		public UnexecutedOrderPageUI()
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/UnexecutedOrderPage.fxml"));
			try
			{
				this.getChildren().add(fxmlLoader.load());
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
//			OrderFirstPageUIFromFirstPageController controller = fxmlLoader.getController();
//			controller.initUnexecutedOrderPart();
			UnexecutedOrderPageController controller = fxmlLoader.getController();
			controller.init();
		}
}
