package presentation.view.customerui.customerui;

import java.time.LocalDate;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.DateHelper;
import presentation.view.HotelManagerUI.RoomTypeInfoUIController.RoomInfo;
import vo.HotelVO;
import vo.RoomInfoVO;

public class MakeOrderPageController 
{
		@FXML private Label hotelNameLabel; 
		@FXML private Label hotelAddressLabel;
		@FXML private Label roomTypeLabel;
		@FXML private Label priceLabel;
		@FXML private Label checkoutTimeLabel;
		@FXML private Label executeDDLLabel;
		@FXML private Label promotionLabel;
		
		private Stage stage;
		private Scene preScene;
		private HotelVO hotelVO;
		private RoomInfoVO roomInfoVO;
		private Date checkinTime;
		
		public void init(Stage stage, Scene preScene, HotelVO hotelVO, RoomInfoVO roomInfoVO, Date checkinTime)
		{
			this.stage = stage;
			this.preScene = preScene;
			this.hotelVO = hotelVO;
			this.roomInfoVO = roomInfoVO;
			this.checkinTime = checkinTime;
		}
		
		@FXML
		private void back()
		{
			stage.setScene(preScene);
		}
		
		private void initWholePage()
		{
			hotelNameLabel.setText(hotelVO.getName());
			hotelAddressLabel.setText(hotelVO.getAddress());
			roomTypeLabel.setText(roomInfoVO.getRoomType());
			priceLabel.setText(roomInfoVO.getDefaultPrice()+"");
			executeDDLLabel.setText(DateHelper.dateToString(new Date(checkinTime.getTime()+18*60*60)));
			
		}
}
