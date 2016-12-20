package presentation.view.customerui.customerui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommentPageUIFromFirstPage extends Scene
{
		public CommentPageUIFromFirstPage(Parent root, Stage stage, Scene preScene,int userID)
		{
			super(root);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/CommentPageUIFromFirstPage.fxml"));
			try
			{
				this.setRoot(fxmlLoader.load());
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			//只要一执行该界面的构造函数，就是要生成该界面的时候，
			//就调用controller的初始化方法，将该界面对应的前一个界面设置好
			//并不是要通过init()这个方法来将这个界面new出来
			CommentPageUIController controller = fxmlLoader.getController();
			controller.init(stage, preScene,this, userID);
		}
		
		
}
