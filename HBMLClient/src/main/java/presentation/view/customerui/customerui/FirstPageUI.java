package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vo.UserVO;

public class FirstPageUI extends Scene
{
	
	public FirstPageUI(Parent root, Stage stage, UserVO userVO, boolean logined)
	{
		super(root);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/FirstPage.fxml"));
		try
		{
			this.setRoot(fxmlLoader.load());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		FirstPageUIController controller = fxmlLoader.getController();
		controller.init(stage, this, userVO, logined);
	}
}
