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

public class CancelledOrderPageUIController {
	@FXML private TableView list;
	@FXML private TableColumn idColumn;
	@FXML private TableColumn generateTimeColumn;
	@FXML private TableColumn	 cancelTimeColumn;
	@FXML private TableColumn priceColumn;
	@FXML private TableColumn executeDDLColumn;
	
	@FXML private TableColumn appealButtonColumn;
	
	@FXML private ObservableList cancelledOrderData;
	
	public void init()
	{
		initTable();
	}
	
	private void initTable()
	{
		idColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		generateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("generateTime"));
		cancelTimeColumn.setCellValueFactory(new PropertyValueFactory<>("cancelTimeColumn"));
		executeDDLColumn.setCellValueFactory(new PropertyValueFactory<>("executeDDL"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		appealButtonColumn.setCellFactory(new Callback<TableColumn<CancelledOrder, Boolean>, TableCell<CancelledOrder, Boolean>>() 
		{
			@Override
			public TableCell call(TableColumn param)
			{
				return new AppealButtonCell();
			}
		});
		
		cancelledOrderData = FXCollections.observableArrayList();
		cancelledOrderData.add(new CancelledOrder("201611220001","2016.11.22 8:00","2016.11.22 20:00","2016.11.22 24:00",200));
		list.setItems(cancelledOrderData);
	}
	
	public class CancelledOrder
	{
		private String orderID;
		private String generateTime;
		private String cancelTime;
		private String executeDDL;
		private double price;
		
		public CancelledOrder(String id, String generateTime, String cancelTime, String executeDDL, double price)
		{
			this.orderID = id;
			this.generateTime = generateTime;
			this.cancelTime = cancelTime;
			this.executeDDL = executeDDL;
			this.price = price;
		}

		public String getId() {
			return orderID;
		}

		public void setId(String id) {
			this.orderID = id;
		}

		public String getGenerateTime() {
			return generateTime;
		}

		public void setGenerateTime(String generateTime) {
			this.generateTime = generateTime;
		}

		public String getCancelTime() {
			return cancelTime;
		}

		public void setCancelTime(String cancelTime) {
			this.cancelTime = cancelTime;
		}

		public String getExecuteDDL() {
			return executeDDL;
		}

		public void setExecuteDDL(String executeDDL) {
			this.executeDDL = executeDDL;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
	}
	
	public class AppealButtonCell extends TableCell<CancelledOrder, Boolean>
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
