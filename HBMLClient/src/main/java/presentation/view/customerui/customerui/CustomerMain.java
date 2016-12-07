package presentation.view.customerui.customerui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;

public class CustomerMain extends Application 
{
	public void start(Stage stage)
	{
		stage.setScene(new FirstPageUI(new Group(), stage));
		stage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
