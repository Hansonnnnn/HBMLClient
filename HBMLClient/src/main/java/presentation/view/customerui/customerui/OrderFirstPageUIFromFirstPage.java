package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OrderFirstPageUIFromFirstPage extends Scene
{
	public OrderFirstPageUIFromFirstPage(Parent root, Stage stage, Scene preScene,int userID)
	{
		super(root);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customeruiFXML/OrderFirstPageFromFirstPage.fxml"));
		try
		{
			this.setRoot(fxmlLoader.load());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		OrderFirstPageUIFromFirstPageController controller = fxmlLoader.getController();
		controller.init(stage, preScene,this,userID);
	}
}
