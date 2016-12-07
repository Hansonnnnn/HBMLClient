package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class EditingOrderUI extends VBox
{
	public EditingOrderUI()
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/EditingOrderPage.fxml"));
		try
		{
			this.getChildren().add(fxmlLoader.load());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
//		OrderFirstPageUIFromFirstPageController controller = fxmlLoader.getController();
//		controller.initEditingPart();
		EditingOrderUIController controller = fxmlLoader.getController();
		controller.init();
	}
}
