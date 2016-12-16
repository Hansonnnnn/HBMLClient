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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.HotelFilter;
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
	@FXML private TableColumn checkButtonColumn;
	@FXML private TableColumn makeOrderButtonColumn;
	
	@FXML private ComboBox first;
	@FXML private ComboBox second;
	@FXML private ComboBox third;
	
	@FXML private TableView list;
	 private Stage stage;
	 private Scene firstPage;
	 
	 private String province;
	 private String city;
	 private String region;
	 private Date checkinTime;
	 private int star;
	 private String choice = "推荐排序";
	 private ObservableList<HotelVO> hotelData;
	 
	 private HotelCustomerService service;
	 private boolean state;
	 private boolean searchByName;
	 private String hotelName;
	 private Map<String, Integer> nameMapID;
	 
	 public void init(Stage stage, Scene firstPage, String hotelName,boolean state)
	 {
		 this.stage = stage;
		 this.firstPage = firstPage;
		 this.state = state;
		 this.hotelName = hotelName;
		 this.searchByName = true;
		 initTable();
	 }
	 public void init(Stage stage, Scene firstPage, String province, String city, String region, Date checkinTime,  int star,boolean state)
	 {
		 this.stage = stage;
		 this.firstPage = firstPage;
		 this.state = state;
		 this.province = province;
		 this.city = city;
		 this.region = region;
		 this.checkinTime = checkinTime;
		 this.star = star;
		 this.searchByName = false;
		 initTable();
	 }
	 @FXML
	 private void back()
	 {
		 stage.setScene(firstPage);
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
		 
		 //
		 HotelFilter filter = null;
		 if(searchByName)
		 {
			 filter = new HotelFilter();
//			 filter.add("name", "=", hotelName);
		 }else
		 {
			 filter = new HotelFilter();
			 filter.add("region", "=", region);
			 filter.add("star", "<", star);
		 }
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
//			 System.out.println(choice);
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
//				 hotelName = 把列表的选中项里面的vo取出来
				 int hotelID = nameMapID.get(hotelName);
				 stage.setScene(new HotelInfoUI(new Group(), stage, firstPage,hotelID,checkinTime));
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
	 
	 @FXML
		private void search()
		{
			String searchInfo = "绿地洲际酒店";
			if(searchField.getText()!=null&&!searchField.getText().isEmpty())
			{
				searchInfo = searchField.getText();
			}
			stage.setScene(new HotelListPageUI(new Group(), stage, firstPage, searchInfo,state));
		}
}
