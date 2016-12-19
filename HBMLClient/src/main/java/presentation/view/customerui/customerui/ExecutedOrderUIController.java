package presentation.view.customerui.customerui;

import java.util.Map;

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
import javafx.util.Callback;
import message.OrderStateMessage;
import presentation.view.customerui.customerui.UnexecutedOrderPageController.CheckOrderButtonCell;
import vo.OrderVO;

public class ExecutedOrderUIController {
	@FXML private TableView list;
	
	@FXML private TableColumn idColumn;
	@FXML private TableColumn hotelNameColumn;
	@FXML private TableColumn generateTimeColumn;
	@FXML private TableColumn	 executeTimeColumn;
	@FXML private TableColumn creditColumn;
	@FXML private TableColumn checkOrderButtonColumn;
	
	@FXML private ObservableList<OrderVO> executedOrderData;
	private OrderCustomerService service;
	
	private Map<Integer, OrderVO> orderList;
	private int userID;
//	private OrderBLService service;
	
	public void init(int userID)
	{
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
			public TableCell call(TableColumn param)
			{
				return new CheckOrderButtonCell();
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
	
	public class CheckOrderButtonCell extends TableCell<OrderVO, Boolean>
	{
		private Button checkOrderButton = new Button("查看");
		public CheckOrderButtonCell()
		{
			checkOrderButton.setOnAction((ActionEvent e)->{
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
				setGraphic(checkOrderButton);
				setText(null);
			}
		}
	}
}
