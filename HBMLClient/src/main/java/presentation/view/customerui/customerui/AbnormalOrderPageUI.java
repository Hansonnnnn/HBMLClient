package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class AbnormalOrderPageUI extends VBox{
	public AbnormalOrderPageUI(int userID)
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/AbnormalOrderPage.fxml"));
		try{
			this.getChildren().add(fxmlLoader.load());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
//		OrderFirstPageUIFromFirstPageController controller = fxmlLoader.getController();
//		controller.initAbnormalOrderPart();
		AbnormalOrderVboxUIController controller = fxmlLoader.getController();
		controller.init(userID);
	}
}
