package driver;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import presentation.view.application.UserLoginUI;
import rmi.ClientRunner;
/**
 * 驱动的总测试入口
 * @author wangfan
 *
 */
public class Client2 extends Application{
	public void start(Stage stage)
	{
//		stage.setScene(new FirstPageUI(new Group(), stage));
		stage.setScene(new UserLoginUI(new Group(), stage));
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