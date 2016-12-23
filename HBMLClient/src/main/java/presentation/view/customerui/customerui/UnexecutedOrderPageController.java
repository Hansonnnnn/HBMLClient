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
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.view.application.MyDialog;
import vo.OrderVO;

public class UnexecutedOrderPageController 
{
	@FXML private TableView<OrderVO> list;
	
	@FXML private TableColumn<OrderVO, Boolean> idColumn;
	@FXML private TableColumn<OrderVO, Boolean> generateTimeColumn;
	@FXML private TableColumn<OrderVO, Boolean> priceColumn;
	@FXML private TableColumn<OrderVO, Boolean> executeDDLColumn;
	@FXML private TableColumn<OrderVO, Boolean> checkOrderButtonColumn;
	@FXML private TableColumn<OrderVO, Boolean> cancelOrderButtonColumn;
	
	@FXML private ObservableList<OrderVO> unexecuteOrderData;
	
	private OrderCustomerService service;
	private int userID;
	private Stage stage;
	
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
		generateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("generateTime"));
		executeDDLColumn.setCellValueFactory(new PropertyValueFactory<>("executeDDL"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		checkOrderButtonColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() 
		{
			@Override
			public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> param)
			{
				return new CheckOrderButtonCell();
			}
		});
		cancelOrderButtonColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() 
		{
			@Override
			public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> param)
			{
				return new UnexecutedOrderButtonCell(stage);
			}
		});
		
		
		unexecuteOrderData = FXCollections.observableArrayList();
		if(service.getUnexecutedOrderList(userID)!=null)
		{
			for (OrderVO orderVO : service.getUnexecutedOrderList(userID).values())
			{
				unexecuteOrderData.add(orderVO);
			}
		}
		list.setItems(unexecuteOrderData);
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
	public class UnexecutedOrderButtonCell extends TableCell<OrderVO, Boolean>
	{
		private Button cancelOrderButton = new Button("撤销");
		
		public UnexecutedOrderButtonCell(Stage stage)
		{
			cancelOrderButton.setOnAction((ActionEvent e)->{
				int selectedIndex = getTableRow().getIndex();
				OrderVO orderVO = (OrderVO)list.getItems().get(selectedIndex);
				
				service.revokeOrder(orderVO.getOrderID());
				new MyDialog(stage, "撤销成功", 2);
				initTable();
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
				setGraphic(cancelOrderButton);
				setText(null);
			}
		}
	}
}
