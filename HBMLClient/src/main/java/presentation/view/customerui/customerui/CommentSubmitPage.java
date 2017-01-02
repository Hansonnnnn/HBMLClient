package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vo.OrderVO;

public class CommentSubmitPage extends Scene
{
		public CommentSubmitPage(Parent root,Stage stage, Scene preScene, OrderVO orderVO)
		{
			super(root);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customeruiFXML/CommentPage.fxml"));
			try
			{
				this.setRoot(fxmlLoader.load());
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
			CommentSubmitPageController controller = fxmlLoader.getController();
			controller.init(stage, preScene, orderVO);
		}
}
