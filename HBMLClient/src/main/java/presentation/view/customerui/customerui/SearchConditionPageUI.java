package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SearchConditionPageUI extends Scene
{
	public SearchConditionPageUI(Parent root, Stage stage, Scene preScene)
	{
		super(root);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/SearchCondition.fxml"));
		try
		{
			this.setRoot(fxmlLoader.load());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		SearchPageController controller = fxmlLoader.getController();
		controller.init(stage, preScene);
	}
}
