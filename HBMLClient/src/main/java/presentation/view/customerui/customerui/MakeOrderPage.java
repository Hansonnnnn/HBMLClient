package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MakeOrderPage extends Scene
{
		public MakeOrderPage(Parent root, Stage stage, Scene preScene)
		{
			super(root);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/MakeOrderPage.fxml"));
			try
			{
				this.setRoot(fxmlLoader.load());
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
			MakeOrderPageController controller = fxmlLoader.getController();
			controller.init(stage, preScene);
		}
}
