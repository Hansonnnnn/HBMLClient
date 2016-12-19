package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vo.OrderVO;
import vo.UserVO;

public class AppealPageUI extends Scene
{
		public AppealPageUI(Parent root, Stage stage, Scene preScene,int userID, OrderVO orderVO)
		{
			super(root);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/Appeal.fxml"));
			try{
				this.setRoot(fxmlLoader.load());
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
			AppealPageUIController controller = fxmlLoader.getController();
			controller.init(stage, preScene,userID,orderVO);
		}
}
