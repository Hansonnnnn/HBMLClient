package presentation.view.customerui.customerui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.DateHelper;
import vo.OrderVO;

public class OrderInfoPageController 
{
		@FXML private Label orderID;
		@FXML private Label hotelName;
		@FXML private Label generateTime;
		@FXML private Label cancelTime;
		@FXML private Label checkinTime;
		@FXML private Label checkoutTime;
		@FXML private Label orderState;
		@FXML private Label hasChild;
		@FXML private Label price;
		
		private Stage stage;
		private OrderVO orderVO;
		
		public void init(Stage stage, OrderVO orderVO)
		{
			this.stage = stage;
			this.orderVO = orderVO;
			initPageContent();
		}
		private DateHelper helper;
		private void initPageContent()
		{
			orderID.setText(orderVO.getOrderID()+"");
			hotelName.setText(orderVO.getHotelID()+"");
			generateTime.setText(helper.dateToString(orderVO.getGenerateTime()));
			cancelTime.setText(helper.dateToString(orderVO.getCancelTime()));
			checkinTime.setText(helper.dateToString(orderVO.getCheckinTime()));
			checkoutTime.setText(helper.dateToString(orderVO.getCheckoutTime()));
			orderState.setText(orderVO.getOrderState().toString());
			hasChild.setText(orderVO.getHasChild()+"");
			price.setText(orderVO.getPrice()+"");
		}
		
}
