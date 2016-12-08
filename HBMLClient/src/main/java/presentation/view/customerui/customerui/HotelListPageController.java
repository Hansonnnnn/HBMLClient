package presentation.view.customerui.customerui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import vo.HotelVO;

public class HotelListPageController {
	@FXML private Button backButton;
	@FXML private TextField searchField;
	@FXML private Button searchButton;
	
	@FXML private TableColumn nameColumn; 
	@FXML private TableColumn addressColumn;
	@FXML private TableColumn starColumn;
	@FXML private TableColumn scoreColumn;
	@FXML private TableColumn priceColumn;
	@FXML private TableColumn buttonColumn; 
	
	@FXML private TableView list;
	 private Stage stage;
	 private Scene preScene;
	 
	 private String address;
	 private String region;
	 private String checkinTime;
	 private String checkoutTime;
	 private int star;
	 private ObservableList<HotelVO> hotelData;
	 public void init(Stage stage, Scene preScene, String searchInfo)
	 {
		 this.stage = stage;
		 this.preScene = preScene;
	 }
	 public void init(Stage stage, Scene preScene, String address, String region, String checkinTime, String checkoutTime, int star)
	 {
		 this.stage = stage;
		 this.preScene = preScene;
		 initTable();
	 }
	 @FXML
	 private void back()
	 {
		 stage.setScene(preScene);
	 }
	 
	 private void initTable()
	 {
		 nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		 addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
		 starColumn.setCellValueFactory(new PropertyValueFactory<>("star"));
		 scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
		 priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		 buttonColumn.setCellFactory(new Callback<TableColumn<HotelVO, Boolean>, TableCell<HotelVO, Boolean>>()
		 {
			 @Override
			 public TableCell call(TableColumn param)
			 {
				 return new CheckInfoButtonCell();
			 }
		});
		 hotelData = FXCollections.observableArrayList();
		 hotelData.add(new HotelVO("绿地洲际酒店","江苏省南京市栖霞区", 5,5,2000));
		 list.setItems(hotelData);
	 }
	 
	 public class CheckInfoButtonCell extends TableCell<HotelVO, Boolean>
	 {
		 private Button checkButton = new Button("查看");
//		 public CheckInfoButtonCell(Button button)
//		 {
//			 this.checkButton = button;
//		 }
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
