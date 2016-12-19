package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vo.UserVO;

public class PersonalCenterPage extends Scene
{
	public PersonalCenterPage(Parent root, Stage stage, Scene preScene, UserVO userVO)
	{
		super(root);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/PersonalCenter.fxml"));
		try
		{
			this.setRoot(fxmlLoader.load());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		PersonalCenterPageController controller = fxmlLoader.getController();
		controller.init(stage, preScene, this, userVO);
	}
}
