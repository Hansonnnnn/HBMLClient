package driver;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import presentation.view.customerui.customerui.WelcomePageUI;
import rmi.ClientRunner;
/**
 * 驱动的总测试入口
 * @author wangfan
 *
 */
public class Client extends Application{
	public void start(Stage stage)
	{
//		stage.setScene(new FirstPageUI(new Group(), stage));
		stage.setScene(new WelcomePageUI(new Group(), stage));
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