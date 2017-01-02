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

public class ExecutedOrderUIController {
	@FXML private TableView<OrderVO> list;
	
	@FXML private TableColumn<OrderVO, Boolean> idColumn;
	@FXML private TableColumn<OrderVO, Boolean> hotelNameColumn;
	@FXML private TableColumn<OrderVO, Boolean> generateTimeColumn;
	@FXML private TableColumn<OrderVO, Boolean>	 executeTimeColumn;
	@FXML private TableColumn<OrderVO, Boolean> creditColumn;
	@FXML private TableColumn<OrderVO, Boolean> checkOrderButtonColumn;
	
	@FXML private ObservableList<OrderVO> executedOrderData;
	private OrderCustomerService service;
	
	private int userID;
	private Stage stage;
	private OrderVO selectedOrder;
	
	public void init(Stage stage,int userID)
	{
		this.stage = stage;
		this.userID = userID;
		service = new OrderCustomerServiceImpl();
		initTable();
	}
	
	private void initTable()
	{
		idColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		hotelNameColumn.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		generateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("generateTime"));
		executeTimeColumn.setCellValueFactory(new PropertyValueFactory<>("cancelTime"));
		creditColumn.setCellValueFactory(new PropertyValueFactory<>("executeDDL"));
		checkOrderButtonColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() 
		{
			@Override
			public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> param)
			{
				return new CheckInfoButtonCell();
			}
		});
		
		executedOrderData = FXCollections.observableArrayList();
		if(service.getExecutedOrderList(userID)!=null)
		{
			for(OrderVO orderVO : service.getExecutedOrderList(userID).values())
			{
				executedOrderData.add(orderVO);
			}
		}
		list.setItems(executedOrderData);
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
			 Image image = new Image(getClass().getResourceAsStream("CustomerImage/HotelListPageCheckButton.png"));
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
