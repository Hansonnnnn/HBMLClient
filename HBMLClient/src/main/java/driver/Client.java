package driver;

import java.util.Map;

import businesslogic.orderbl.OrderCustomerServiceImpl;
import businesslogic.roomInfobl.RoomInfoStaffServiceImpl;
import businesslogicservice.orderblservice.OrderCustomerService;
import businesslogicservice.roominfoblservice.RoomInfoStaffService;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import presentation.view.application.UserLoginUI;
import presentation.view.customerui.customerui.FirstPageUI;
import rmi.ClientRunner;
import vo.OrderVO;
import vo.RoomInfoVO;
/**
 * 驱动的总测试入口
 * @author wangfan
 *
 */
public class Client extends Application{
	public void start(Stage stage)
	{
//		stage.setScene(new FirstPageUI(new Group(), stage));
//		stage.show();
		//wujun's part
		stage.setScene(new UserLoginUI(new Group(),stage));
		stage.show();
	}
	public static void main(String[] args)
	{
		
		ClientRunner cr = new ClientRunner();
		
//		OrderCustomerService orderCustomerService = new OrderCustomerServiceImpl();
//		Map<Integer, OrderVO> map = orderCustomerService.getUnexecutedOrderList(1);
//		for (OrderVO orderVO : map.values()) {
//			System.out.println(orderVO);
//			orderCustomerService.addOrder(orderVO);
//		}
	
		launch(args);
	}
}