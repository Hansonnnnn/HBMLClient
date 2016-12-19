package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EnrollUserPageNew extends Scene
{
	public EnrollUserPageNew(Parent root, Stage stage, Scene preScene)
	{
		super(root);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/EnrollUserPageNew.fxml"));
		try
		{
			this.setRoot(fxmlLoader.load());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		EnrollUserPageNewController controller = fxmlLoader.getController();
		controller.init(stage, preScene);
	}
}
