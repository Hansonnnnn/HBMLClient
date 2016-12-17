package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LogoutPageUI extends Stage
{
	public LogoutPageUI(Stage mainStage, Scene mainScene, FirstPageUIController fcontroller) 
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/LogoutPage.fxml"));
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
		LogoutPageUIController controller = fxmlLoader.getController();
		controller.init(this, scene, fcontroller);
	}
}
