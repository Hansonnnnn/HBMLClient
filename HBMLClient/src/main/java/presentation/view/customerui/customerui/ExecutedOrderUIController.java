package presentation.view.customerui.customerui;

import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.view.customerui.customerui.UnexecutedOrderPageController.CheckOrderButtonCell;
import vo.OrderVO;
import vo.UnexecutedOrderVO;

public class ExecutedOrderUIController {
	@FXML private TableView list;
	
	@FXML private TableColumn idColumn;
	@FXML private TableColumn generateTimeColumn;
	@FXML private TableColumn	 executeTimeColumn;
	@FXML private TableColumn creditColumn;
	@FXML private TableColumn priceColumn; 
	@FXML private TableColumn checkOrderButtonColumn;
	
	@FXML private ObservableList<OrderVO> executedOrderData;
	
	private Map<Integer, OrderVO> orderList;
	public void init()
	{
		initTable();
	}
	
	private void initTable()
	{
		idColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		generateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("generateTime"));
		executeTimeColumn.setCellValueFactory(new PropertyValueFactory<>("cancelTime"));
		creditColumn.setCellValueFactory(new PropertyValueFactory<>("executeDDL"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		checkOrderButtonColumn.setCellFactory(new Callback<TableColumn<UnexecutedOrderVO, Boolean>, TableCell<UnexecutedOrderVO, Boolean>>() 
		{
			@Override
			public TableCell call(TableColumn param)
			{
				return new CheckOrderButtonCell();
			}
		});
		
		
		executedOrderData = FXCollections.observableArrayList();
		for(int i = 0;i < orderList.size();i++)
		{
			executedOrderData.add();
		}
		executedOrderData.add(new OrderVO("201611220001","2016.11.22 8:00","2016.11.22 20:00","2016.11.22 24:00",200));
		list.setItems(executedOrderData);
	}
	
	public class CheckOrderButtonCell extends TableCell<OrderVO, Boolean>
	{
		private Button cancelOrderButton = new Button("撤销订单");
		
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
