package presentation.view.customerui.customerui;

import businesslogic.orderbl.OrderCustomerServiceImpl;
import businesslogicservice.orderblservice.OrderCustomerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;
import vo.OrderVO;

public class UnCommentedHotelListPageController 
{
	@FXML private TableView<OrderVO> list;
	@FXML private TableColumn<OrderVO, Boolean> nameColumn;
	@FXML private TableColumn<OrderVO, Boolean> starColumn;
	@FXML private TableColumn<OrderVO, Boolean> scoreColumn;
	@FXML private TableColumn<OrderVO, Boolean> priceColumn;
	@FXML private TableColumn<OrderVO, Boolean> buttonColumn;
	
	private Stage stage;
	private Scene commentFirstPageScene;
	private ObservableList<OrderVO> orderData;
	private OrderCustomerService customerService;
	private int userID;
	
	
	public void init(Stage stage, Scene commentFirstPageScene, int userID)
	{
		this.stage = stage;
		this.commentFirstPageScene = commentFirstPageScene;
		customerService = new OrderCustomerServiceImpl();
		this.userID = userID;
		initTable();
	}
	
	/**
	 * 初始化未评价酒店的表格内容
	 */
	private void initTable()
	{
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		buttonColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
			@Override
			public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> param)
			{
				return new CommentButtonCell(stage);
			}
		});
		orderData = FXCollections.observableArrayList();
		if(customerService.getExecutedOrderList(userID)!=null)
		{
			for (OrderVO orderVO : customerService.getExecutedOrderList(userID).values()) 
			{
				orderData.add(orderVO);
			}
		}
		list.setItems(orderData);
	}
	
	/**
	 * 为表格最后的列添加按钮的内部类
	 * @author xiezhenyu
	 *
	 */
	public class CommentButtonCell extends TableCell<OrderVO, Boolean>
	{
		private Button commentButton = new Button();
		
		public CommentButtonCell(Stage stage)
		{
			 commentButton.setStyle("-fx-background-color:transparent;");
			 ImageView imageView = new ImageView();
			 imageView.setFitHeight(30);
			 imageView.setFitWidth(30);
			 Image image = new Image(getClass().getResourceAsStream("CustomerImage/CommentButtonImage.png"));
			 imageView.setImage(image);
			 commentButton.setGraphic(imageView);
		
			 commentButton.setOnAction((ActionEvent e)->{
				 int seletedIndex=getTableRow().getIndex();
				 OrderVO selectedOrder = (OrderVO) list.getItems().get(seletedIndex);
				stage.setScene(new CommentSubmitPage(new Group(), stage, commentFirstPageScene, selectedOrder));
			});
		}
	}
}
