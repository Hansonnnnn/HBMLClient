package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.stage.Stage;

public class LoginPageUI extends Dialog
{
	public LoginPageUI(Parent root, Stage stage, Scene preScene) 
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/LoginPage.fxml"));
		LoginPageUIController controller = fxmlLoader.getController();
		controller.init();
	}
}
