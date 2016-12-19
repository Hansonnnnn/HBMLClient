package presentation.view.customerui.customerui;

import org.omg.CORBA.INTERNAL;

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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import message.OrderStateMessage;
import vo.OrderVO;

public class CancelledOrderPageUIController {
	@FXML private TableView list;
	@FXML private TableColumn idColumn;
	@FXML private TableColumn hotelNameColumn;
	@FXML private TableColumn generateTimeColumn;
	@FXML private TableColumn	 cancelledTimeColumn;
//	@FXML private TableColumn creditColumn;
	
	@FXML private TableColumn checkOrderButtonColumn;
	
	@FXML private ObservableList<OrderVO> cancelledOrderData;
	private int userID;
	private OrderCustomerService customerService;
	private Stage stage;
	
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
			public TableCell call(TableColumn param)
			{
				return new CheckButtonCell();
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
	
	public class CheckButtonCell extends TableCell<OrderVO, Boolean>
	{
		private Button checkButton = new Button("查看");
		public CheckButtonCell()
		{
			checkButton.setOnAction((ActionEvent e)->{
				int selectedIndex = getTableRow().getIndex();
				OrderVO orderVO = (OrderVO)list.getItems().get(selectedIndex);
				new OrderInfoPage(orderVO).show();
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
