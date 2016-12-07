package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PersonInfoPageFromFirstPage extends Scene
{
		public PersonInfoPageFromFirstPage(Parent root, Stage stage, Scene preScene)
		{
			super(root);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/PersonalInfoManagePage.fxml"));
			try{
				this.setRoot(fxmlLoader.load());
			}catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("PersonalInfoPageFromFirstPage Error");
			}
			
			PersonInfoPageFirstController controller = fxmlLoader.getController();
			controller.init(stage, preScene, this);
		}
}
