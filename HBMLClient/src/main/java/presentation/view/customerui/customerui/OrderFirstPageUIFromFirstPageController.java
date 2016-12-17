package presentation.view.customerui.customerui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OrderFirstPageUIFromFirstPageController {
	@FXML private Button backButton;
//	@FXML private Button firstOrderButton;
	@FXML private Button secondOrderButton;
	@FXML private Button thirdOrderButton;
	@FXML private Button forthOrderButton;
	@FXML private Button fifthOrderButton;
	
	@FXML private VBox contentBox;
	
	@FXML private TableColumn idColumn;
	@FXML private TableColumn generateTime;
	@FXML private TableColumn	 cancelTime;
	@FXML private TableColumn price;
	@FXML private TableColumn executeDDL;
	
	@FXML private TableView list;
	
	private Stage stage;
	private Scene preScene;
	private int userID;
	
	public void init(Stage stage, Scene preScene,int userID)
	{
		this.stage = stage;
		this.preScene = preScene;
		contentBox.getChildren().add(new UnexecutedOrderPageUI(userID));
	}
	
	@FXML
	private void back()
	{
		stage.setScene(preScene);
	}
	
//	@FXML
//	private void firstButtonAction()//待提交订单
//	{
//		contentBox.getChildren().remove(0);
//		contentBox.getChildren().add(new EditingOrderUI());
//	}
	

	@FXML
	private void secondButtonAction()//未完成订单
	{
		contentBox.getChildren().remove(0);
		contentBox.getChildren().add(new UnexecutedOrderPageUI(userID));
	}
	

	@FXML
	private void thirdButtonAction()//已执行订单
	{
		contentBox.getChildren().remove(0);
		contentBox.getChildren().add(new ExecutedOrderPageUI(userID));
	}
	

	@FXML
	private void forthButtonAction()//已撤销订单
	{
		contentBox.getChildren().remove(0);
		contentBox.getChildren().add(new CancelledOrderPageUI(userID));
	}
	
	@FXML
	private void fifthBuutonAction()//异常订单
	{
		contentBox.getChildren().remove(0);
		contentBox.getChildren().add(new AbnormalOrderPageUI(userID));
	}
	
	
}
