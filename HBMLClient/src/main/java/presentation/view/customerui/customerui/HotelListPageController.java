package presentation.view.customerui.customerui;

import java.util.Date;

import businesslogic.hotelInfobl.HotelCustomerImpl;
import businesslogic.roomInfobl.RoomInfoCustomerServiceImpl;
import businesslogicservice.hotelinfoblservice.HotelCustomerService;
import businesslogicservice.roominfoblservice.RoomInfoCustomerService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import presentation.view.application.MyDialog;
import vo.HotelVO;
import vo.RoomInfoVO;
import vo.UserVO;

public class HotelListPageController {
	@FXML private Button backButton;
	@FXML private TextField searchField;
	@FXML private Button searchButton;
	@FXML private Button refreshButton;
	
	@FXML private TableColumn<HotelVO, Boolean> nameColumn; 
	@FXML private TableColumn<HotelVO, Boolean> addressColumn;
	@FXML private TableColumn<HotelVO, Boolean> starColumn;
	@FXML private TableColumn<HotelVO, Boolean> scoreColumn;
	@FXML private TableColumn<HotelVO, Boolean> priceColumn;
	@FXML private TableColumn<HotelVO, Boolean> checkButtonColumn;
	@FXML private TableColumn<HotelVO, Boolean> makeOrderButtonColumn;
	
	@FXML private ComboBox<String> first;
	@FXML private ComboBox<String> second;
	@FXML private ComboBox<String> promotionList;
	
	@FXML private TableView<HotelVO> list;
	 private Stage stage;
	 private Scene firstPage;
	 private Scene hotelListPageScene;
	 private int region;
	 private Date checkinTime;
	 private int star;
	 private String choiceOne = "推荐排序";
	 private String choiceTwo = "默认星级";
	 private String choiceThree = "促销策略";
	 private ObservableList<HotelVO> hotelData;
	 
	 private HotelCustomerService service;
	 private RoomInfoCustomerService customerService;
	 private boolean logined;
	 private boolean searchByName;
	 private String hotelName;
//	 private Map<String, Integer> nameMapID;
	 private HotelVO selectedHotel;
	 private RoomInfoVO defaultRoom;
	 private UserVO userVO;
	 private HotelFilter filter;
	 
	 public void init(Stage stage, Scene firstPage,Scene hotelListPageScene, UserVO userVO, int region,String hotelName, Date checkinTime,  int star,boolean logined)
	 {
		 this.stage = stage;
		 this.firstPage = firstPage;
		 this.hotelListPageScene = hotelListPageScene;
		 this.userVO = userVO;
		 this.logined = logined;
		 this.region = region;
		 this.hotelName = hotelName;
		 this.checkinTime = checkinTime;
		 this.star = star;
		 this.searchByName = false;
		 searchField.setPromptText(hotelName);
		 customerService = new RoomInfoCustomerServiceImpl();
		 initComboBox();
		 initTable();
	 }
	 
	 @FXML
	 private void refresh()
	 {
		 initComboBox();
		 initTable();
	 }

	 
	 @FXML
	 private void back()
	 {
		 stage.setScene(firstPage);
	 }
	 
	 @SuppressWarnings("unchecked")
	private void initTable()
	 {
		
		 nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		 starColumn.setCellValueFactory(new PropertyValueFactory<>("star"));
		 scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
		 priceColumn.setCellValueFactory(new PropertyValueFactory<>("lowestPrice"));
		 addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
//		 addressColumn.setCellFactory(new Callback<TableColumn<HotelVO, Boolean>, TableCell<HotelVO, Boolean>>() 
//		 {
//			 @Override
//			 public TableCell call(TableColumn param)
//			 {
//				 return new OrderStateMark();
//			 }
//		});
		 checkButtonColumn.setCellFactory(new Callback<TableColumn<HotelVO, Boolean>, TableCell<HotelVO, Boolean>>()
		 {
			 @Override
			 public TableCell<HotelVO, Boolean> call(TableColumn param)
			 {
				 return new CheckInfoButtonCell(stage);
			 }
		});
		 makeOrderButtonColumn.setCellFactory(new Callback<TableColumn<HotelVO, Boolean>, TableCell<HotelVO, Boolean>>() 
		 {
			 @Override
			 public TableCell<HotelVO, Boolean> call(TableColumn<HotelVO, Boolean> param)
			 {
				 return new MakeOrderButtonCell(stage);
			 }
		});
		 hotelData = FXCollections.observableArrayList();

		 filter = new HotelFilter();
		 if(hotelName!=null)
		 {		
			 filter.del("name");
			 filter.add("name", "like", "'%"+hotelName+"%'"); 
		 }
		 //region一定会传过来
		 filter.del("region");
		 filter.add("region", "=", region);
		 //star也会传过来
		 filter.del("star");
		 filter.add("star", ">=", star);
		//初始化排序方式选择框后，会拿到排序策略（choiceOne）和星级（star）
		 String order = "score";
		 if(choiceOne.equals("星级排序"))
		 {
			 order = "star";
			 choiceTwoStrategy();
		 }
		 else if(choiceOne.equals("低价排序"))
		 {
			 order = "lowestPrice";
			 choiceTwoStrategy();
		 }else
		 {
			 choiceTwoStrategy();
		 }
		 if(service.getHotelList(filter, order, checkinTime) != null)
		 {	
			 hotelData.clear();
			 for (HotelVO hotelVO : service.getHotelList(filter, order, checkinTime).values()) 
			 {
				hotelData.add(hotelVO);
//				 addressColumn.setCellFactory(new Callback<TableColumn<HotelVO, Boolean>, TableCell<HotelVO, Boolean>>() 
//				 {
//					 @Override
//					 public TableCell call(TableColumn param)
//					 {
//						 return new OrderStateMark(hotelVO);
//					 }
//				});
			} 
		 }

		 list.setItems(hotelData);
	 }
	 
	 private void initComboBox()
	 {
		 service = new HotelCustomerImpl();
		 
		 ObservableList<String> optionsOne = FXCollections.observableArrayList(
				 "星级排序","好评优先","低价排序");
		 ObservableList<String> optionsTwo = FXCollections.observableArrayList(
				 "五星级","四星级","三星级","二星级","一星级","默认星级");
		 ObservableList<String> optionsThree = FXCollections.observableArrayList(
				 "酒店促销策略","网站促销策略");
		 
//		 first.setItems(optionsOne);
//		 second.setItems(optionsTwo);
//		 third.setItems(optionsThree);
		 if(first.getItems().isEmpty())
		 {
			 first.getItems().addAll(optionsOne);
		 }
		 if(second.getItems().isEmpty())
		 {
			 second.getItems().addAll(optionsTwo);
		 }
		 if(promotionList.getItems().isEmpty())
		 {
			 promotionList.getItems().addAll(optionsThree);
		 }
		
		 first.setPromptText("排序方式");
		 second.setPromptText("星级筛选");
		 promotionList.setPromptText("促销策略");
		 
		 first.valueProperty().addListener(new ChangeListener<String>() {
			 @Override
			 public void changed(ObservableValue ov, String oldValue, String newValue){
				 choiceOne = newValue;
				 initTable();
			 }
		});
		 
		 second.valueProperty().addListener(new ChangeListener<String>() {
			 @Override
			 public void changed(ObservableValue ov, String oldValue, String newValue)
			 {
				 choiceTwo = newValue;
				 initTable();
			 }
		});
		 
		 promotionList.valueProperty().addListener(new ChangeListener<String>() {
			 @Override
			 public void changed(ObservableValue ov, String oldValue, String newValue)
			 {
				 choiceThree = newValue;
				 new PromotionPageUI(choiceThree);
			 }
		});
	 }

	 private void choiceTwoStrategy()
	 {
		 if (choiceTwo.equals("默认星级")) {
			return;
		}
		 if(choiceTwo.equals("一星级"))
		 {
			 star = 1;
			 filter.del("star");
			 filter.add("star", "=", star);
		 }
		 else if(choiceTwo.equals("二星级"))
		 {
			 star = 2;
			 filter.del("star");
			 filter.add("star", "=", star);
		 }
		 else if(choiceTwo.equals("三星级"))
		 {
			 star = 3;
			 filter.del("star");
			 filter.add("star", "=", star);
		 }
		 else if(choiceTwo.equals("四星级"))
		 {
			 star = 4;
			 filter.del("star");
			 filter.add("star", "=", star);
		 }
		 else if(choiceTwo.equals("五星级"))
		 {
			 star = 5;
			 filter.del("star");
			 filter.add("star", "=", star);
		 }
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
				 int seletedIndex=getTableRow().getIndex();
				 selectedHotel = (HotelVO) list.getItems().get(seletedIndex);
				 stage.setScene(new HotelInfoUI(new Group(), stage, hotelListPageScene, selectedHotel,userVO,checkinTime,logined));
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
			 makeOrderButton.setOnAction((ActionEvent e)->{
				 if(logined)
				 {
					 int seletedIndex=getTableRow().getIndex();
					 selectedHotel = (HotelVO) list.getItems().get(seletedIndex);
					 if(selectedHotel.getLowestPrice() == 0)
					 {
						 new MyDialog(stage, "抱歉，该酒店没有空房，您可查看该酒店信息", 1);
					 }else
					 {
						 if(customerService.getRoomList(selectedHotel.getId(), checkinTime)!=null)
						 {
							 for (RoomInfoVO roomInfoVO : customerService.getRoomList(selectedHotel.getId(), checkinTime).values())
							 {
								defaultRoom = roomInfoVO;
								break;
							 }
						 }
						 stage.setScene(new MakeOrderPage(new Group(), stage, hotelListPageScene, selectedHotel, defaultRoom,userVO,checkinTime));
					 }
				 }else
				 {
					 new MyDialog(stage, "请先登录", 0);
				 }
				
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
		 	hotelData.clear();
			String searchInfo = null;
			if(searchField.getText()!=null&&!searchField.getText().isEmpty())
			{
				searchInfo = searchField.getText();
				filter.del("name");
				filter.add("name", "like", "'%"+ searchInfo+"%'");
			}
			
			 if(service.getHotelList(filter, "star", checkinTime) != null)
			 {
				 for (HotelVO hotelVO : service.getHotelList(filter, "star", checkinTime).values()) 
				 {
					hotelData.clear();
					hotelData.add(hotelVO);
					
//					nameMapID.put(hotelVO.getName(), hotelVO.getId());
				} 
			 }
			 list.setItems(hotelData);
//			stage.setScene(new HotelListPageUI(new Group(), stage, firstPage, searchInfo,checkinTime,state));
		}

//	 	public class OrderStateMark extends TableCell<HotelVO, Boolean>
//	 	{
//	 		BorderPane borderPane=new BorderPane();
//	 		Label hotelNameLabel=new Label();
//	 		HBox hBox=new HBox();
//	 		ImageView imageView1=new ImageView();
//	 		Image unexecutedMark = new Image(getClass().getResourceAsStream("../CustomerImage/UnExecuted.png"));
//	 		ImageView imageView2=new ImageView();
//	 		Image executedMark = new Image(getClass().getResourceAsStream("../CustomerImage/Executed2.png"));
//	 		ImageView imageView3=new ImageView();
//	 		Image abnormalMark = new Image(getClass().getResourceAsStream("../CustomerImage/Abnormal.png"));
//	 		ImageView imageView4=new ImageView();
//	 		Image cancelledMark = new Image(getClass().getResourceAsStream("../CustomerImage/cancelled.png"));
//	 		public OrderStateMark(HotelVO hotelVO)
//	 		{
//	 			hotelNameLabel.setText(hotelVO.getName());
//	 			borderPane.setLeft(hotelNameLabel);
//	 			borderPane.setRight(hBox);
//	 			if(service.hotelRecord(userVO.getUserID(), OrderStateMessage.Unexecuted).contains(hotelVO.getAddress()))
//	 			{
//	 				imageView1.setImage(unexecutedMark);
//	 				hBox.getChildren().add(imageView1);
//	 			}
//	 			if(service.hotelRecord(userVO.getUserID(), OrderStateMessage.Executed).contains(hotelVO.getAddress()))
//	 			{
//	 				imageView2.setImage(executedMark);
//	 				hBox.getChildren().add(imageView2);
//	 			}
//	 			if(service.hotelRecord(userVO.getUserID(), OrderStateMessage.Abnormal).contains(hotelVO.getAddress()))
//	 			{
//	 				imageView2.setImage(abnormalMark);
//	 				hBox.getChildren().add(imageView3);
//	 			}
//	 			if(service.hotelRecord(userVO.getUserID(), OrderStateMessage.Cancelled).contains(hotelVO.getAddress()))
//	 			{
//	 				imageView2.setImage(cancelledMark);
//	 				hBox.getChildren().add(imageView4);
//	 			}
//	 		}
//	 		@Override
//	 		 protected void updateItem(Boolean t, boolean empty) 
//			 {
//				super.updateItem(t, empty);
//				if(empty)
//				{
//					setGraphic(null);
//					setText(null);
//				}else
//				{
//					setGraphic(borderPane);
//					setText(null);
//				}
//			 }
//	 	}
//	 	
}
