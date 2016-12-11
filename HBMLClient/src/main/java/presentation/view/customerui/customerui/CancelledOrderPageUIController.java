package presentation.view.customerui.customerui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import message.OrderStateMessage;
import vo.OrderVO;

public class CancelledOrderPageUIController {
	@FXML private TableView list;
	@FXML private TableColumn idColumn;
	@FXML private TableColumn hotelNameColumn;
	@FXML private TableColumn generateTimeColumn;
	@FXML private TableColumn	 cancelledTimeColumn;
	@FXML private TableColumn creditColumn;
	
	@FXML private TableColumn checkOrderButtonColumn;
	
	@FXML private ObservableList<OrderVO> cancelledOrderData;
	
	public void init()
	{
		initTable();
	}
	
	private void initTable()
	{
		idColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		hotelNameColumn.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		generateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("generateTime"));
		cancelledTimeColumn.setCellValueFactory(new PropertyValueFactory<>("cancelTime"));
		creditColumn.setCellValueFactory(new PropertyValueFactory<>("credit"));
		
		checkOrderButtonColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() 
		{
			@Override
			public TableCell call(TableColumn param)
			{
				return new CheckButtonCell();
			}
		});
		
		cancelledOrderData = FXCollections.observableArrayList();
//		cancelledOrderData.add(new OrderVO(1111111, 00, 1111, "LVZJ", 000, OrderStateMessage.Abnormal, "20161808", null, null, null, null, 0, 0, 200));
		list.setItems(cancelledOrderData);
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
}
