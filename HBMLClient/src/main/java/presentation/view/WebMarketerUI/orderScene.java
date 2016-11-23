package presentation.view.WebMarketerUI;




import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class orderScene extends Scene{
	
	/*
	 * 异常订单界面网状布局
	 */
	private GridPane orderGridPane;
		
	/*
	 * 异常订单列表
	 */
	private TableView<ExceptionOrder> exceptionTableView;
	
	/*
	 * 订单列表数据
	 */
	private final ObservableList<ExceptionOrder> data;
	
	/*
	 * 异常订单编号标签
	 */
	private Label exceptionLabel;
	
	/*
	 * 异常订单编号文本框
	 */
	private TextField exceptionTextField;
	
	/*
	 * 确认撤销异常订单按钮
	 */
	private Button revokeButton;
	
	public orderScene(Group root,Stage stage,Scene beforeScene,WebMarker webMarker,Scene loginScene) {
		super(root);
		orderGridPane=new GridPane();
		orderGridPane.setVgap(10);
		orderGridPane.setHgap(10);
		
		webMarker.addManageLabel(orderGridPane, 1, 480);
		webMarker.addUserWindow(orderGridPane, "异常订单处理", beforeScene, loginScene, stage,1);
		
		exceptionTextField=new TextField();
		exceptionTextField.setPrefWidth(200);
		exceptionTextField.setEditable(false);
		
		exceptionTableView=new TableView<>();
		exceptionTableView.setEditable(false);
		data=FXCollections.observableArrayList();
		data.add(new ExceptionOrder("201611220001","李四","2016.11.22 08:00",
				"2016.11.22 20:00",200));
		data.add(new ExceptionOrder("201611220002","王五","2016.11.23 09:00",
				"2016.11.22 22:00",300));
		exceptionTableView=addTableView(exceptionTableView, data,exceptionTextField);
		orderGridPane.add(exceptionTableView, 0, 2);
		
		HBox hBox=new HBox();
		hBox.setSpacing(20);
		hBox.setPadding(new Insets(20,85,10,85));
		exceptionLabel=new Label("异常订单编号");
		exceptionLabel.setStyle("-fx-font-size:16px");
		
		
		revokeButton=new Button("确 认 撤 销");
		revokeButton.setId("revokeButton");
		//TODO
		revokeButton.setOnAction((ActionEvent e)->{
			exceptionTableView.getSelectionModel().getSelectedItems()
				.forEach(exceptionTableView.getItems()::remove);
		});
		
		revokeButton.setPrefWidth(150);
		hBox.getChildren().addAll(exceptionLabel,exceptionTextField,revokeButton);
		orderGridPane.add(hBox, 0, 3);
		
		VBox blankVBox=new VBox();
		blankVBox.setPrefHeight(30);
		blankVBox.setStyle("-fx-background-color:#BEBEBE");
		orderGridPane.add(blankVBox, 0, 4);
		
		this.getStylesheets().add(orderScene.class.getResource("order.css").toExternalForm());
		root.getChildren().add(orderGridPane);
		
		
	}
	
	public static TableView<ExceptionOrder> addTableView(TableView<ExceptionOrder> exceptionTabelView,
			ObservableList<ExceptionOrder> data,TextField exceptionTextField){
		TableColumn idColumn=new TableColumn("订单编号");
		idColumn.setMinWidth(150);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		
		TableColumn nameColumn=new TableColumn("用户姓名");
		nameColumn.setMinWidth(100);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
		
		TableColumn startColumn=new TableColumn("生成时间");
		startColumn.setMinWidth(150);
		startColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
		
		TableColumn endColumn=new TableColumn("最晚执行时间");
		endColumn.setMinWidth(150);
		endColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));
		
		TableColumn priceColumn=new TableColumn("价格");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		exceptionTabelView.setItems(data);
		exceptionTabelView.getColumns().addAll(idColumn,nameColumn,startColumn,endColumn,priceColumn);
		
		exceptionTabelView.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue) ->{
			exceptionTextField.setText(((ExceptionOrder)exceptionTabelView.getSelectionModel().getSelectedItem()).getOrderID());
		});
		return exceptionTabelView;
	}
	
	public static class ExceptionOrder{
		private String orderID;
		private String userName;
		private String startTime;
		private String endTime;
		private int price;
		public ExceptionOrder(String orderID,String userName,String startTime,String endTime,int price) {
			this.orderID=orderID;
			this.userName=userName;
			this.startTime=startTime;
			this.endTime=endTime;
			this.price=price;
		}
		
		public String getOrderID() {
			return orderID;
		}
		public void setOrderID(String orderID) {
			this.orderID = orderID;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
	}
}
