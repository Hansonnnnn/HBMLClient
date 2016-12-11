package presentation.view.customerui.customerui;

import java.time.LocalDate;
import java.util.Date;

import com.sun.corba.se.spi.orbutil.fsm.Action;

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
import message.OrderStateMessage;
import model.DateHelper;
import presentation.view.customerui.customerui.EditingOrderUIController.EditingOrder;
import presentation.view.customerui.customerui.EditingOrderUIController.EditingOrderButtonCell;
import vo.OrderVO;

public class UnexecutedOrderPageController 
{
	@FXML private TableView list;
	
	@FXML private TableColumn idColumn;
	@FXML private TableColumn generateTimeColumn;
	@FXML private TableColumn	 cancelTimeColumn;
	@FXML private TableColumn priceColumn;
	@FXML private TableColumn executeDDLColumn;
	@FXML private TableColumn checkOrderButtonColumn;
	@FXML private TableColumn cancelOrderButtonColumn;
	
	@FXML private ObservableList<OrderVO> unexecuteOrderData;
	
	public void init()
	{
		initTable();
	}
	
	private void initTable()
	{
		idColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		generateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("generateTime"));
		cancelTimeColumn.setCellValueFactory(new PropertyValueFactory<>("cancelTime"));
		executeDDLColumn.setCellValueFactory(new PropertyValueFactory<>("executeDDL"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		checkOrderButtonColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() 
		{
			@Override
			public TableCell call(TableColumn param)
			{
				return new CheckOrderButtonCell();
			}
		});
		cancelOrderButtonColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() 
		{
			@Override
			public TableCell call(TableColumn param)
			{
				return new UnexecutedOrderButtonCell();
			}
		});
		
		
		unexecuteOrderData = FXCollections.observableArrayList();
		
		
		LocalDate localDate = LocalDate.now();
		Date date = DateHelper.localDateToDate(localDate);
		unexecuteOrderData.add(new OrderVO(111, 111, 111, "绿地洲际酒店", 000000, OrderStateMessage.Abnormal, date, date, date, date, date, 9, 9, 200));
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
