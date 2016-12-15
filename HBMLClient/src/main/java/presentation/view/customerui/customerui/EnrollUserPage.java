package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EnrollUserPage extends Scene
{
		public EnrollUserPage(Parent root, Stage stage, Scene preScene, FirstPageUIController fcontroller)
		{
			super(root);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/EnrollUserPage.fxml"));
			try
			{
				this.setRoot(fxmlLoader.load());
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
			EnrollUserPageController controller = fxmlLoader.getController();
			controller.init(stage, preScene, fcontroller);
		}
}
