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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.view.application.MyDialog;
import vo.OrderVO;

/**
 * 显示未执行订单的界面的controller
 * @author xiezhenyu
 *
 */
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
	private OrderVO selectedOrder;
	
	public void init(Stage stage,int userID)
	{
		this.stage = stage;
		this.userID = userID;
		service = new OrderCustomerServiceImpl();
		initTable();
	}
	
	/**
	 * 初始化未执行订单的表格的内容
	 */
	private void initTable()
	{
		idColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		generateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("generateTime"));
		executeDDLColumn.setCellValueFactory(new PropertyValueFactory<>("executeDDl"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		checkOrderButtonColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() 
		{
			@Override
			public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> param)
			{
				return new CheckInfoButtonCell();
			}
		});
		cancelOrderButtonColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() 
		{
			@Override
			public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> param)
			{
				return new UnexecutedOrderButtonCell();
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
	
	/**
	 * 为表格的最后列添加按钮的内部类
	 * @author xiezhenyu
	 *
	 */
	public class CheckInfoButtonCell extends TableCell<OrderVO, Boolean>
	{
		private Button checkButton = new Button();
		 public CheckInfoButtonCell()
		 {
			 checkButton.setStyle("-fx-background-color:transparent;");
			 ImageView imageView = new ImageView();
			 imageView.setFitHeight(30);
			 imageView.setFitWidth(30);
			 Image image = new Image(getClass().getResourceAsStream("CustomerImage/HotelListPageCheckButton.png"));
			 imageView.setImage(image);
			 checkButton.setGraphic(imageView);
		
			 checkButton.setOnAction((ActionEvent e)->{
				 int seletedIndex=getTableRow().getIndex();
				 selectedOrder = (OrderVO) list.getItems().get(seletedIndex);
				 new OrderInfoPage(selectedOrder);
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
	public class UnexecutedOrderButtonCell extends TableCell<OrderVO, Boolean>
	{
		private Button cancelOrderButton = new Button("撤销");
		
		public UnexecutedOrderButtonCell()
		{
			cancelOrderButton.setStyle("-fx-background-color:transparent;");
			 ImageView imageView = new ImageView();
			 imageView.setFitHeight(30);
			 imageView.setFitWidth(30);
			 Image image = new Image(getClass().getResourceAsStream("CustomerImage/CancelButtonImage.png"));
			 imageView.setImage(image);
			 cancelOrderButton.setGraphic(imageView);
			 
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
