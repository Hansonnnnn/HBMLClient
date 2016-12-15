package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class FindPasswordPageUI extends Scene
{
		public FindPasswordPageUI(Parent root)
		{
			super(root);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/FindPasswordPage.fxml"));
			try
			{
				this.setRoot(fxmlLoader.load());
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
}
