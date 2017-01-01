package presentation.view.customerui.customerui;

import java.io.File;
import java.util.Date;

import businesslogic.roomInfobl.RoomInfoCustomerServiceImpl;
import businesslogicservice.roominfoblservice.RoomInfoCustomerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.ImageHelper;
import presentation.view.application.MyDialog;
import vo.HotelVO;
import vo.RoomInfoVO;
import vo.UserVO;

public class HotelInfoUIController 
{
		@FXML private TableView<RoomInfoVO> list;
		@FXML private Button backButton;
		@FXML private TableColumn<RoomInfoVO, Boolean> typeColumn;
		@FXML private TableColumn<RoomInfoVO, Boolean> priceColumn;
		@FXML private TableColumn<RoomInfoVO, Boolean> buttonColumn;
		@FXML private Button historyOrderButton; 
		
		@FXML private ImageView hotelImageView;
		@FXML private Label addressLabel;
		@FXML private Label introduceLabel;
		@FXML private Label facilityLabel;
		
		private Stage stage;
		private Scene preScene;
		private Scene hotelInfoPageScene;
		
		private ObservableList<RoomInfoVO> roomdata;
		
		private RoomInfoCustomerService service = new RoomInfoCustomerServiceImpl();
		private HotelVO hotelVO;
		private RoomInfoVO selectedRoom;
		private UserVO userVO;
		private Date checkinTime;
		private boolean logined;
		
		public void init(Stage stage, Scene preScece, Scene hotelInfoPageScene, HotelVO hotelVO,UserVO userVO,Date checkinTime,boolean logined)
		{
			this.stage = stage;
			this.preScene = preScece;
			this.hotelInfoPageScene = hotelInfoPageScene;
			this.hotelVO = hotelVO;
			this.userVO = userVO;
			this.checkinTime = checkinTime;
			this.logined = logined;
			initLabel();
			initTable();
			if(hotelVO.getEnvironment().size()>0){
		           Image image=new Image("file:///"+hotelVO.getEnvironment().get(0).getAbsolutePath().replace('\\', '/').replaceAll("HBMLClient/HBMLClient", "Final_HBMSServer/HBMSServer"));
		            hotelImageView.setImage(image); 
		        }
		}
		
		@FXML 
		private void back()
		{
			stage.setScene(preScene);
		}
		
		//初始化该界面的标签项
		private void initLabel()
		{
			Image defaultImage = null;
			for (File hotelImageFile : hotelVO.getEnvironment())
			{
				Image hotelImage = ImageHelper.fileToImage(hotelImageFile);
				if(hotelImage!=null){defaultImage = hotelImage;}
			}
			hotelImageView.setImage(defaultImage);
			addressLabel.setText(hotelVO.getAddress());
			addressLabel.setWrapText(true);
			introduceLabel.setText(hotelVO.getIntroduction());
			introduceLabel.setWrapText(true);
			facilityLabel.setText(hotelVO.getFacility());
			facilityLabel.setWrapText(true);
		}
		
		//初始化房间列表内容表格，并调用BL层的方法来获得数据
		private void initTable()
		{
			typeColumn.setCellValueFactory(new PropertyValueFactory<>("roomType"));
			priceColumn.setCellValueFactory(new PropertyValueFactory<>("defaultPrice"));
			buttonColumn.setCellFactory(new Callback<TableColumn<RoomInfoVO, Boolean>, TableCell<RoomInfoVO, Boolean>>()
			{
				@Override
				public TableCell<RoomInfoVO, Boolean> call(TableColumn<RoomInfoVO, Boolean> param)
				{
					return new MakeOrderButtonCell(stage);
				}
			});
			roomdata = FXCollections.observableArrayList();
			if(service.getRoomList(hotelVO.getId(), checkinTime) != null)
			{
				for(RoomInfoVO roomInfoVO:service.getRoomList(hotelVO.getId(), checkinTime).values())
				{
					if(roomInfoVO.getRoomInfoID() == 0)
					{
						roomInfoVO.setRoomType(roomInfoVO.getRoomType() + ("(无房)"));
					}
					roomdata.add(roomInfoVO);
				}
			}else
			{
				System.out.println("service.getRoomList(hotelVO.getId(), checkinTime) = null");
			}
			list.setItems(roomdata);
		}
		
		//为表格最后的列添加按钮
		public class MakeOrderButtonCell extends TableCell<RoomInfoVO, Boolean>
		 {
			 private Button makeOrderButton = new Button("预订");
			 
			 public MakeOrderButtonCell(Stage stage)
			 {
				 makeOrderButton.setStyle("-fx-background-color:transparent;");
				 ImageView imageView = new ImageView();
				 imageView.setFitHeight(30);
				 imageView.setFitWidth(30);
				 Image image = new Image(getClass().getResourceAsStream("../CustomerImage/GouWuChe.png"));
				 imageView.setImage(image);
				 makeOrderButton.setGraphic(imageView);
				 makeOrderButton.setOnAction((ActionEvent e)->{
					 if(logined)
					 {
						 int selectedIndex = getTableRow().getIndex();
						 selectedRoom = (RoomInfoVO)list.getItems().get(selectedIndex);
						 if(selectedRoom.getRoomInfoID() == 0)
						 {
							 new MyDialog(stage, "抱歉，该房型无房间", 1);
						 }else
						 {
							 stage.setScene(new MakeOrderPage(new Group(), stage, hotelInfoPageScene, hotelVO, selectedRoom,userVO, checkinTime));
						 }
						 
					 }else
					 {
						 new MyDialog(stage, "请先登录", 0);
					 }
				});
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
		
		//历史订单事件响应
		@FXML 
		private void historyOrder()
		{
			new HistoryOrderPage(hotelVO.getId(), userVO.getUserID()).showAndWait();
		}
}
