package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PromotionPageUI extends Stage
{
		public PromotionPageUI(String type)
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/PromotionPage.fxml"));
			Parent root = null;
			Scene scene = null;
			try {
				root = fxmlLoader.load();
				scene = new Scene(root);
				this.setScene(scene);
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			PromotionPageUIController controller = fxmlLoader.getController();
			controller.initTable(type);
		}
}
