package presentation.view.customerui.customerui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class EditingOrderUIController {
	@FXML private TableView list;
	
	@FXML private TableColumn idColumn;
	@FXML private TableColumn generateTimeColumn;
	@FXML private TableColumn	 cancelTimeColumn;
	@FXML private TableColumn priceColumn;
	@FXML private TableColumn executeDDLColumn;
	
	@FXML private TableColumn makeOrderButtonColumn;
	
	@FXML private ObservableList<EditingOrder> editingOrderData;
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
		makeOrderButtonColumn.setCellFactory(new Callback<TableColumn<EditingOrder, Boolean>, TableCell<EditingOrder, Boolean>>() 
		{
			@Override
			public TableCell call(TableColumn param)
			{
				return new EditingOrderButtonCell();//EditingOrderButtonCell类为添加了按钮的列的单元格
			}
		});
		
		editingOrderData = FXCollections.observableArrayList();
		editingOrderData.add(new EditingOrder("201611220001","2016.11.22 8:00","2016.11.22 20:00","2016.11.22 24:00",200));
		list.setItems(editingOrderData);
	}
	
	public class EditingOrder
	{
		private String orderID;
		private String generateTime;
		private String cancelTime;
		private String executeDDL;
		private double price;
		
		public EditingOrder(String id, String generateTime, String cancelTime, String executeDDL, double price)
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
	
	public class EditingOrderButtonCell extends TableCell<EditingOrder, Boolean>
	{
		private Button makeOrderButton = new Button("生成订单");
		private Stage stage;
		
		protected void updateItem(Boolean t, boolean empty)
		{
			super.updateItem(t, empty);
			if(empty)
			{
				setGraphic(null);
				setText(null);
			}else
			{
				setGraphic(makeOrderButton);
				setText(null);
			}
		}
	}
}
