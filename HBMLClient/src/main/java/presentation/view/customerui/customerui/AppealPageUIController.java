package presentation.view.customerui.customerui;

import java.util.Date;

import businesslogic.orderbl.OrderCustomerServiceImpl;
import businesslogicservice.orderblservice.OrderCustomerService;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import message.AppealStateMessage;
import presentation.view.application.MyDialog;
import vo.AppealVO;
import vo.OrderVO;

public class AppealPageUIController 
{
		@FXML private TextArea appealArea;
		@FXML private Button submitButton;
		@FXML private Button backButton;
		private Stage stage;
		private Scene preScene;
		private int userID;
		private OrderVO orderVO;
		private OrderCustomerService customerService;
		
		
		public void init(Stage stage, Scene preScene, int userID, OrderVO orderVO)
		{
			this.stage = stage;
			this.preScene = preScene;
			this.userID = userID;
			this.orderVO = orderVO;
			customerService = new OrderCustomerServiceImpl();
		}
		
		@FXML
		private void back()
		{
			stage.setScene(preScene);
		}
		
		@FXML
		private void submit()
		{
			String content = "";
			if(appealArea.getText()!=null&&!appealArea.getText().isEmpty())
			{
				content = appealArea.getText();
				AppealVO appealVO = new AppealVO(0, orderVO.getOrderID(), userID, 0, new Date(), content, AppealStateMessage.Undealt);
				customerService.addAppealOrder(appealVO);
				new MyDialog(stage, "申诉成功，等待处理", 2);
				stage.setScene(preScene);
			}
		}
}
