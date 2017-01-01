package presentation.view.customerui.customerui;

import businesslogic.orderbl.OrderCustomerServiceImpl;
import businesslogicservice.orderblservice.OrderCustomerService;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;
import vo.OrderVO;

public class AbnormalOrderVboxUIController {
	@FXML private TableView<OrderVO> list;
	@FXML private TableColumn<OrderVO, Boolean> idColumn;
	@FXML private TableColumn<OrderVO, Boolean> hotelNameColumn;
	@FXML private TableColumn<OrderVO, Boolean> generateTimeColumn;
	@FXML private TableColumn<OrderVO, Boolean> creditColumn;
	@FXML private TableColumn<OrderVO, Boolean> priceColumn;
	@FXML private TableColumn<OrderVO, Boolean> checkOrderButtonColumn;
	@FXML private TableColumn<OrderVO, Boolean> appealButtonColumn;
	
	@FXML private ObservableList<OrderVO> abnormalOrderData;
	private int userID;
	private OrderCustomerService customerService;
	private Stage stage;
	private Scene preScene;
	private OrderVO selectedOrder;
	
	public void init(Stage stage,Scene preScene,int userID)
	{
		this.stage = stage;
		this.preScene = preScene;
		customerService = new OrderCustomerServiceImpl();
		this.userID = userID;
		initTable();
	}
	
	private void initTable()
	{
		idColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		hotelNameColumn.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		generateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("generateTime"));
		creditColumn.setCellValueFactory(new PropertyValueFactory<>("credit"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		checkOrderButtonColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() 
		{
			@Override
			public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> param)
			{
				return new CheckInfoButtonCell();
			}
		});
		appealButtonColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() 
		{
			@Override
			public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> param)
			{
				return new AppealButtonCell(stage,preScene);
			}
		});
		
		abnormalOrderData = FXCollections.observableArrayList();
		if(customerService.getAbnormalOrderList(userID)!=null)
		{
//			System.out.println(userID);
			for (OrderVO orderVO : customerService.getAbnormalOrderList(userID).values())
			{
				abnormalOrderData.add(orderVO);
			}
		}
		list.setItems(abnormalOrderData);
	}
	
	//为表格的最后一项添加一个按钮
	public class CheckInfoButtonCell extends TableCell<OrderVO, Boolean>
	{
		 private Button checkButton = new Button();
		 public CheckInfoButtonCell()
		 {
			 checkButton.setStyle("-fx-background-color:transparent;");
			 ImageView imageView = new ImageView();
			 imageView.setFitHeight(30);
			 imageView.setFitWidth(30);
			 Image image = new Image(getClass().getResourceAsStream("../CustomerImage/HotelListPageCheckButton.png"));
			 imageView.setImage(image);
			 checkButton.setGraphic(imageView);
		
			 checkButton.setOnAction((ActionEvent e)->{
				 int seletedIndex=getTableRow().getIndex();
				 selectedOrder = (OrderVO) list.getItems().get(seletedIndex);
				 new OrderInfoPage(selectedOrder);
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
				setGraphic(checkButton);
				setText(null);
			}
		}
	}
	
	//为表格的最后一项添加一个按钮
	public class AppealButtonCell extends TableCell<OrderVO, Boolean>
	{
		private Button appealButton = new Button();
		public AppealButtonCell(Stage stage,Scene preScene)
		{
			appealButton.setStyle("-fx-background-color:transparent;");
			 ImageView imageView = new ImageView();
			 imageView.setFitHeight(30);
			 imageView.setFitWidth(30);
			 Image image = new Image(getClass().getResourceAsStream("../CustomerImage/AppealButtonImage.png"));
			 imageView.setImage(image);
			 appealButton.setGraphic(imageView);
		
			appealButton.setOnAction((ActionEvent e)->{
				int selectedIndex = getTableRow().getIndex();
				OrderVO orderVO = (OrderVO)list.getItems().get(selectedIndex);
				stage.setScene(new AppealPageUI(new Group(),stage,preScene,userID,orderVO));
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
				setGraphic(appealButton);
				setText(null);
			}
		}
	}
}
