package presentation.view.customerui.customerui;


import businesslogic.orderbl.OrderCustomerServiceImpl;
import businesslogicservice.orderblservice.OrderCustomerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class CancelledOrderPageUIController {
	@FXML private TableView<OrderVO> list;
	@FXML private TableColumn<OrderVO, Boolean> idColumn;
	@FXML private TableColumn<OrderVO, Boolean> hotelNameColumn;
	@FXML private TableColumn<OrderVO, Boolean> generateTimeColumn;
	@FXML private TableColumn<OrderVO, Boolean>	cancelledTimeColumn;
	
	@FXML private TableColumn<OrderVO, Boolean> checkOrderButtonColumn;
	
	@FXML private ObservableList<OrderVO> cancelledOrderData;
	private int userID;
	private OrderCustomerService customerService;
	private Stage stage;
	private OrderVO selectedOrder;
	
	public void init(Stage stage,int userID)
	{
		this.stage = stage;
		this.userID = userID;
		customerService = new OrderCustomerServiceImpl();
		initTable();
	}
	
	private void initTable()
	{
		idColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		hotelNameColumn.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		generateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("generateTime"));
		cancelledTimeColumn.setCellValueFactory(new PropertyValueFactory<>("cancelTime"));
//		creditColumn.setCellValueFactory(new PropertyValueFactory<>("credit"));
		
		checkOrderButtonColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() 
		{
			@Override
			public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> param)
			{
				return new CheckInfoButtonCell(stage);
			}
		});
		
		cancelledOrderData = FXCollections.observableArrayList();
		if(customerService.getCancelledOrderList(userID)!=null)
		{
			for (OrderVO orderVO : customerService.getCancelledOrderList(userID).values())
			{
				cancelledOrderData.add(orderVO);
			}
		}
		list.setItems(cancelledOrderData);
	}
	
	public class CheckInfoButtonCell extends TableCell<OrderVO, Boolean>
	{
		 private Button checkButton = new Button();
		 public CheckInfoButtonCell(Stage stage)
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
}
