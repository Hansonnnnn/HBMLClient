package presentation.view.customerui.customerui;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import businesslogic.hotelInfobl.HotelCustomerImpl;
import businesslogicservice.hotelinfoblservice.HotelCustomerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.HotelFilter;
import presentation.view.customerui.customerui.HotelListPageController.CheckInfoButtonCell;
import presentation.view.customerui.customerui.HotelListPageController.MakeOrderButtonCell;
import vo.HotelVO;
import vo.OrderVO;

public class MyHotelListPageController 
{
		@FXML private Button backButton;
		@FXML private TableColumn nameColumn; 
		@FXML private TableColumn addressColumn;
		@FXML private TableColumn starColumn;
		@FXML private TableColumn scoreColumn;
		@FXML private TableColumn priceColumn;
		@FXML private TableColumn checkButtonColumn;
		@FXML private TableColumn makeOrderButtonColumn;
		@FXML private TableView list;
		
		@FXML private ComboBox first;
		@FXML private ComboBox second;
		@FXML private ComboBox third;
		
		private String choice = "推荐排序";
		 private ObservableList<HotelVO> hotelData;
		
		private Stage stage;
		private Scene preScene;
		
		 private String hotelName;
		 private Map<String, Integer> nameMapID;
		 private String region;
		 private Date checkinTime;
		 private int star;
		 
		private HotelCustomerService service;
		
		public void init(Stage stage, Scene preScene)
		{
			this.stage = stage;
			this.preScene = preScene;
		}
		
		@FXML 
		private void back()
		{
			stage.setScene(preScene);
		}
		
		private void initTable()
		 {
			 initComboBox();
			 nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
			 addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
			 starColumn.setCellValueFactory(new PropertyValueFactory<>("star"));
			 scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
			 priceColumn.setCellValueFactory(new PropertyValueFactory<>("lowestPrice"));
			 checkButtonColumn.setCellFactory(new Callback<TableColumn<HotelVO, Boolean>, TableCell<HotelVO, Boolean>>()
			 {
				 @Override
				 public TableCell call(TableColumn param)
				 {
					 return new CheckInfoButtonCell(stage);
				 }
			});
			 makeOrderButtonColumn.setCellFactory(new Callback<TableColumn<HotelVO, Boolean>, TableCell<HotelVO, Boolean>>() 
			 {
				 @Override
				 public TableCell call(TableColumn param)
				 {
					 return new MakeOrderButtonCell(stage);
				 }
			});
			 hotelData = FXCollections.observableArrayList();

			 HotelFilter filter = new HotelFilter();
			
			 nameMapID = new LinkedHashMap<>();
			 for (HotelVO hotelVO : service.getHotelList(filter, "star", checkinTime).values()) 
			 {
				hotelData.add(hotelVO);
				nameMapID.put(hotelVO.getName(), hotelVO.getId());
			}
			 list.setItems(hotelData);
		 }
		 
		 private void initComboBox()
		 {
			 ObservableList<String> optionsOne = FXCollections.observableArrayList(
					 "推荐排序","好评优先","高价排序","低价排序");
			 ObservableList<String> optionsTwo = FXCollections.observableArrayList(
					 "五星级","四星级","三星级","二星级","一星级");
			 ObservableList<String> optionsThree = FXCollections.observableArrayList(
					 );
			 first.setItems(optionsOne);
			 second.setItems(optionsTwo);
			 third.setItems(optionsThree);
			
			 first.setPromptText("推荐排序");
			 second.setPromptText("星级排序");
			 third.setPromptText("位置区域");
			 
			 first.setOnAction((Event e) -> {
				 choice = first.getSelectionModel().getSelectedItem().toString();
//				 System.out.println(choice);
			 });
			 second.setOnAction((Event e)->{
				 choice = second.getSelectionModel().getSelectedItem().toString();
			 });
			 third.setOnAction((Event e)->{
				 choice = third.getSelectionModel().getSelectedItem().toString();
			 });
			 //调用搜索方法
			 service = new HotelCustomerImpl();
		 }

		 public class CheckInfoButtonCell extends TableCell<HotelVO, Boolean>
		 {
			 private Button checkButton = new Button("查看");
			 public CheckInfoButtonCell(Stage stage)
			 {
				 DropShadow shadow = new DropShadow();
				 checkButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
					checkButton.setEffect(shadow); 
				 });
				 checkButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
					 checkButton.setEffect(null);
				 });
			
				 checkButton.setOnAction((ActionEvent e)->{
					 HotelVO hotelVO = (HotelVO)list.getSelectionModel().getSelectedItem();
					 stage.setScene(new HotelInfoUI(new Group(), stage, preScene,hotelVO.getId(),checkinTime));
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
		 
		 public class MakeOrderButtonCell extends TableCell<HotelVO, Boolean>
		 {
			 private Button makeOrderButton = new Button("预订");
			 
			 public MakeOrderButtonCell(Stage stage)
			 {
				 DropShadow shadow = new DropShadow();
				 makeOrderButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
					makeOrderButton.setEffect(shadow); 
				 });
				 makeOrderButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
					 makeOrderButton.setEffect(null);
				 });
				 makeOrderButton.setOnAction((ActionEvent e)->{
//					 stage.setScene(new HotelInfoUI(new Group(), stage, preScene));
				 });
				 
				 //设置按钮响应，来生成订单
				 OrderVO orderVO = null;
				 
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
					setGraphic(makeOrderButton);
					setText(null);
				}
			 }
			 
		 }
}
