package presentation.view.customerui.customerui;

import java.util.Date;

import businesslogic.hotelInfobl.HotelCustomerImpl;
import businesslogicservice.hotelinfoblservice.HotelCustomerService;
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
import message.OrderStateMessage;
import vo.HotelVO;
import vo.UserVO;

public class MyHotelListPageController 
{
		@FXML private Button backButton;
		@FXML private TableColumn<HotelVO, Boolean> nameColumn; 
		@FXML private TableColumn<HotelVO, Boolean> addressColumn;
		@FXML private TableColumn<HotelVO, Boolean> starColumn;
		@FXML private TableColumn<HotelVO, Boolean> scoreColumn;
		@FXML private TableColumn<HotelVO, Boolean> priceColumn;
		@FXML private TableColumn<HotelVO, Boolean> checkButtonColumn;
		@FXML private TableView<HotelVO> list;

		 private ObservableList<HotelVO> hotelData;
		
		 private Stage stage;
		 private Scene preScene;
		 private Scene thisScene;
		
		 private UserVO userVO;
		 private HotelCustomerService service;
		 private HotelVO selectedHotel;
		
		public void init(Stage stage, Scene preScene,UserVO userVO, Scene thisScene)
		{
			this.stage = stage;
			this.preScene = preScene;
			this.userVO = userVO;
			this.thisScene = thisScene;
			service = new HotelCustomerImpl();
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
			 starColumn.setCellValueFactory(new PropertyValueFactory<>("star"));
			 scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
			 priceColumn.setCellValueFactory(new PropertyValueFactory<>("lowestPrice"));
			 addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

			 checkButtonColumn.setCellFactory(new Callback<TableColumn<HotelVO, Boolean>, TableCell<HotelVO, Boolean>>()
			 {
				 @Override
				 public TableCell<HotelVO, Boolean> call(TableColumn<HotelVO, Boolean> param)
				 {
					 return new CheckInfoButtonCell(stage);
				 }
			});
			 
			 hotelData = FXCollections.observableArrayList();
			 
			 if(service.hotelRecord(userVO.getUserID(), OrderStateMessage.Executed)!=null)
			 {
				 for (int  hotelID : service.hotelRecord(userVO.getUserID(), OrderStateMessage.Executed))
				 {
					HotelVO hotelVO = service.getHotelInfo(hotelID);
					hotelData.add(hotelVO);
				 }
			 }
			 list.setItems(hotelData);
		 }

		 public class CheckInfoButtonCell extends TableCell<HotelVO, Boolean>
		 {
			 private Button checkButton = new Button();
			 public CheckInfoButtonCell(Stage stage)
			 {
				 checkButton.setStyle("-fx-background-color:transparent;");
				 ImageView imageView = new ImageView();
				 imageView.setFitHeight(30);
				 imageView.setFitWidth(30);
				 Image image = new Image(getClass().getResourceAsStream("CustomerImage/HotelListPageCheckButton.png"));
				 imageView.setImage(image);
				 checkButton.setGraphic(imageView);
			
				 checkButton.setOnAction((ActionEvent e)->{
//					 hotelName = 把列表的选中项里面的vo取出来
					 int seletedIndex=getTableRow().getIndex();
					 selectedHotel = (HotelVO) list.getItems().get(seletedIndex);
					 stage.setScene(new HotelInfoUI(new Group(), stage, thisScene, selectedHotel,userVO,new Date(),true));
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
		 
}
