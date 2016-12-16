package presentation.view.customerui.customerui;

import java.util.Date;
import java.util.Map;

import businesslogic.roomInfobl.RoomInfoCustomerServiceImpl;
import businesslogicservice.roominfoblservice.RoomInfoCustomerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import vo.HotelVO;
import vo.RoomInfoVO;

public class HotelInfoUIController 
{
		@FXML private TableView list;
		@FXML private Button backButton;
		@FXML private TableColumn typeColumn;
		@FXML private TableColumn priceColumn;
		@FXML private TableColumn buttonColumn;
		
		private Stage stage;
		private Scene preScene;
		
		private ObservableList<RoomInfoVO> roomdata;
		
		private RoomInfoCustomerService service = new RoomInfoCustomerServiceImpl();
		private Map<String, RoomInfoVO> roomlist;
		private HotelVO hotelVO;
		private Date checkinTime;
		
		public void init(Stage stage, Scene preScece,HotelVO hotelVO,Date checkinTime)
		{
			this.stage = stage;
			this.preScene = preScece;
			this.hotelVO = hotelVO;
			this.checkinTime = checkinTime;
			initTable();
		}
		
		@FXML 
		private void back()
		{
			stage.setScene(preScene);
		}
		
		private void initTable()
		{
			typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
			priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
			buttonColumn.setCellFactory(new Callback<TableColumn<RoomInfoVO, Boolean>, TableCell<RoomInfoVO, Boolean>>()
			{
				@Override
				public TableCell call(TableColumn param)
				{
					return new MakeOrderButtonCell(stage);
				}
			});
			roomdata = FXCollections.observableArrayList();
			roomlist = service.getRoomList(hotelVO.getId(), checkinTime);
			roomdata.addAll(roomlist.values());
			list.setItems(roomdata);
		}
		
		public class MakeOrderButtonCell extends TableCell<RoomInfoVO, Boolean>
		 {
			 private Button makeOrderButton = new Button("预订");
			 
			 public MakeOrderButtonCell(Stage stage)
			 {
				 DropShadow shadow = new DropShadow();
				 makeOrderButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
					makeOrderButton.setEffect(shadow); 
				 });
				 makeOrderButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
					 makeOrderButton.setEffect(null);
				 });
//				 makeOrderButton.setOnAction((ActionEvent e)->{
//					 stage.setScene(new HotelInfoUI(new Group(), stage, firstPage));
//				 });
			 }
			 
			 protected void updateItem(Boolean t, boolean empty) 
			 {
				super.updateItem(t, empty);
				if(empty)
				{
					setGraphic(null);
					setText(null);
				}else
				{
					setGraphic(makeOrderButton);
					setText(null);
				}
			 }
		 }
		
}
