package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vo.OrderVO;

public class OrderInfoPage extends Stage
{
	public OrderInfoPage(OrderVO orderVO) 
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customeruiFXML/OrderInfoPage.fxml"));
		Parent root = null;
		try {
			root = fxmlLoader.load();
			Scene scene = new Scene(root);
			this.setScene(scene);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		OrderInfoPageController controller = fxmlLoader.getController();
		controller.init(this, orderVO);
	}
}
