package driver;

import java.awt.Image;
import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;

import businesslogic.hotelInfobl.HotelCustomerImpl;
import businesslogicservice.hotelinfoblservice.HotelCustomerService;
import dao.OrderDao;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import message.OrderStateMessage;
import presentation.view.customerui.customerui.FirstPageUI;
import rmi.ClientRunner;
import vo.HotelVO;
/**
 * 驱动的总测试入口
 * @author wangfan
 *
 */
public class Client extends Application{
	public void start(Stage stage)
	{
		stage.setScene(new FirstPageUI(new Group(), stage));
		stage.show();
	}
	public static void main(String[] args)
	{
		
		ClientRunner cr = new ClientRunner();
		
		HotelCustomerService hotelCustomerService = new HotelCustomerImpl();
		Set<Integer> set = hotelCustomerService.hotelRecord(1,OrderStateMessage.Executed);
		for (Integer integer : set) {
			System.out.println(integer);
		}
	
	//	launch(args);
	}
}