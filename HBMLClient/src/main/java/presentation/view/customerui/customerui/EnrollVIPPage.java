package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EnrollVIPPage extends Scene
{
		public EnrollVIPPage(Parent root, Stage stage, Scene preScene)
		{
			super(root);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/CommonVIPenroll.fxml"));
			try
			{
				this.setRoot(fxmlLoader.load());
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
			EnrollVIPPageController controller = fxmlLoader.getController();
			controller.init(stage, preScene);
		}
}
