package presentation.view.customerui.customerui;

import java.io.IOException;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vo.UserVO;

public class HotelListPageUI extends Scene
{
//	public HotelListPageUI(Parent root, Stage stage, Scene preScene, String searchInfo,Date checkinTime, boolean state)
//	{
//		super(root);
//		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/HotelListPage.fxml"));
//		try{
//			this.setRoot(fxmlLoader.load());
//		}catch(IOException e)
//		{
//			e.printStackTrace();
//		}
//		
//		HotelListPageController controller = fxmlLoader.getController();
//		controller.init(stage, preScene,this, searchInfo,checkinTime, state);
//	}
	
	public HotelListPageUI(Parent root, Stage stage, Scene preScene,UserVO userVO, int region,String hotelName, Date checkinTime, int star,boolean state)
	{
		super(root);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customeruiFXML/HotelListPage.fxml"));
		try{
			this.setRoot(fxmlLoader.load());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		HotelListPageController controller = fxmlLoader.getController();
		controller.init(stage, preScene,this, userVO, region,hotelName, checkinTime, star,state);
	}
	
//	public HotelListPageUI(Parent root)
//	{
//		super(root);
//		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customeruiFXML/HotelListPage.fxml"));
//		try{
//			this.setRoot(fxmlLoader.load());
//		}catch(IOException e)
//		{
//			e.printStackTrace();
//		}
//		HotelListPageController controller = fxmlLoader.getController();
//		controller.refresh();
//	}
}
