package presentation.view.customerui.customerui;

import java.io.IOException;

import businesslogicservice.creditblservice.CreditCustomerService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vo.UserVO;

public class CreditRecordPageUI extends Scene 
{
		public CreditRecordPageUI(Parent root,Stage stage, Scene preScene, UserVO userVO)
		{
			super(root);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customeruiFXML/CreditRecordPage.fxml"));
			try
			{
				this.setRoot(fxmlLoader.load());
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
			CreditRecordPageUIController controller = fxmlLoader.getController();
			controller.init(stage, preScene, userVO);
		}
}
