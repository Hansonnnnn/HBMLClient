package presentation.view.customerui.customerui;

import businesslogic.orderbl.OrderCustomerServiceImpl;
import businesslogicservice.orderblservice.OrderCustomerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import message.OrderStateMessage;
import vo.OrderVO;

public class AbnormalOrderVboxUIController {
	@FXML private TableView list;
	@FXML private TableColumn idColumn;
	@FXML private TableColumn hotelNameColumn;
	@FXML private TableColumn generateTimeColumn;
	@FXML private TableColumn creditColumn;
	@FXML private TableColumn priceColumn;
	@FXML private TableColumn checkOrderButtonColumn;
	@FXML private TableColumn appealButtonColumn;
	
	@FXML private ObservableList<OrderVO> abnormalOrderData;
	private int userID;
	private OrderCustomerService customerService;
	public void init(int userID)
	{
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
			public TableCell call(TableColumn param)
			{
				return new CheckButtonCell();
			}
		});
		appealButtonColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() 
		{
			@Override
			public TableCell call(TableColumn param)
			{
				return new AppealButtonCell();
			}
		});
		
		abnormalOrderData = FXCollections.observableArrayList();
		if(customerService.getAbnormalOrderList(userID)!=null)
		{
//			System.out.println(userID);
			for (OrderVO orderVO : customerService.getAbnormalOrderList(userID).values())
			{
				System.out.println(orderVO.getOrderID());
				abnormalOrderData.add(orderVO);
			}
		}
		list.setItems(abnormalOrderData);
	}
	
	public class CheckButtonCell extends TableCell<OrderVO, Boolean>
	{
		private Button checkButton = new Button("查看");
		
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
	
	public class AppealButtonCell extends TableCell<OrderVO, Boolean>
	{
		private Button appealButton = new Button("申诉");
		
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
