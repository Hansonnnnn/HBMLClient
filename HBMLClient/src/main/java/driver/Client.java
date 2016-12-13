package driver;

import java.util.Map;
import businesslogic.roomInfobl.RoomInfoStaffServiceImpl;
import businesslogicservice.roominfoblservice.RoomInfoStaffService;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import presentation.view.customerui.customerui.FirstPageUI;
import rmi.ClientRunner;
import vo.RoomInfoVO;
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
		
		RoomInfoStaffService roomInfoStaffService = new RoomInfoStaffServiceImpl();
		Map<String, RoomInfoVO> map = roomInfoStaffService.getRoomList(119);
		for (String string : map.keySet()) {
			System.out.println(map.get(string));
		}
	
	//	launch(args);
	}
}