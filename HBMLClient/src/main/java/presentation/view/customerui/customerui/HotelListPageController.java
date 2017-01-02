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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;
import message.OrderStateMessage;
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
	 //初始化酒店列表表格，并初始化表格上方的筛选逻辑选择框
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
			 //添加标记的过程中，会用“（”、“空”、“||”关键字进行分割
			 for (HotelVO hotelVO : service.getHotelList(filter, order, checkinTime).values()) 
			 {
				 if(hotelVO.getLowestPrice() == 0)
				 {
					 //判断是否已经在名字上加过无空房，加过就不加
					 if(hotelVO.getName().indexOf("空") == -1)
					 {
					 hotelVO.setName(hotelVO.getName() + " (无空房) ");
					 }
				 }else
				 {
					 //酒店价格不为0，所以要将添加的字段无空房删掉
					 if(hotelVO.getName().indexOf("空") != -1)
					 {
						 String[] hotelNameArr = hotelVO.getName().split("(");
						 hotelVO.setName(hotelNameArr[0]);
					 }
				 }
				 if(service.hotelRecord(userVO.getUserID(), OrderStateMessage.Executed)!=null)
				 {
					 if(service.hotelRecord(userVO.getUserID(), OrderStateMessage.Executed).contains(hotelVO.getId()))
					 {
						 hotelVO.setName(hotelVO.getName() + "@已");
					 }
				 }else
				 {
					 //如果该酒店没有已执行订单，就要将名字里的字段删掉
					 if(hotelVO.getName().indexOf("@已") != -1)
					 {
						 String[] hotelNameArr = hotelVO.getName().split("@已");
						 for(int i = 0;i < hotelName.length();i++)
						 {
							 if(i==0)
							 {
								 hotelVO.setName(hotelNameArr[0]);
							 }else
							 {
								 hotelVO.setName(hotelVO.getName() + hotelNameArr[i]);
							 }
						 }
					 }
				 }
				 if(service.hotelRecord(userVO.getUserID(), OrderStateMessage.Unexecuted)!=null)
				 {
					 if(service.hotelRecord(userVO.getUserID(), OrderStateMessage.Unexecuted).contains(hotelVO.getId()))
					 {
						 hotelVO.setName(hotelVO.getName() + "@未");
					 }
				 }else
				 {
					 //如果该酒店没有已执行订单，就要将名字里的字段删掉
					 if(hotelVO.getName().indexOf("@未") != -1)
					 {
						 String[] hotelNameArr = hotelVO.getName().split("@未");
						 for(int i = 0;i < hotelName.length();i++)
						 {
							 if(i==0)
							 {
								 hotelVO.setName(hotelNameArr[0]);
							 }else
							 {
								 hotelVO.setName(hotelVO.getName() + hotelNameArr[i]);
							 }
						 }
					 }
				 }
				 if(service.hotelRecord(userVO.getUserID(), OrderStateMessage.Cancelled)!=null)
				 {
					 if(service.hotelRecord(userVO.getUserID(), OrderStateMessage.Cancelled).contains(hotelVO.getId()))
					 {
						 hotelVO.setName(hotelVO.getName() + "@撤");
					 }
				 }else
				 {
					 //如果该酒店没有已执行订单，就要将名字里的字段删掉
					 if(hotelVO.getName().indexOf("@撤") != -1)
					 {
						 String[] hotelNameArr = hotelVO.getName().split("@撤");
						 for(int i = 0;i < hotelName.length();i++)
						 {
							 if(i==0)
							 {
								 hotelVO.setName(hotelNameArr[0]);
							 }else
							 {
								 hotelVO.setName(hotelVO.getName() + hotelNameArr[i]);
							 }
						 }
					 }
				 }
				 if(service.hotelRecord(userVO.getUserID(), OrderStateMessage.Abnormal)!=null)
				 {
					 if(service.hotelRecord(userVO.getUserID(), OrderStateMessage.Abnormal).contains(hotelVO.getId()))
					 {
						 hotelVO.setName(hotelVO.getName() + "@异");
					 }
				 }else
				 {
					 //如果该酒店没有已执行订单，就要将名字里的字段删掉
					 if(hotelVO.getName().indexOf("@异") != -1)
					 {
						 String[] hotelNameArr = hotelVO.getName().split("@异");
						 for(int i = 0;i < hotelName.length();i++)
						 {
							 if(i==0)
							 {
								 hotelVO.setName(hotelNameArr[0]);
							 }else
							 {
								 hotelVO.setName(hotelVO.getName() + hotelNameArr[i]);
							 }
						 }
					 }
				 }
				hotelData.add(hotelVO);
			} 
		 }

		 list.setItems(hotelData);
	 }
	 
	 //初始化条件选择框
	 private void initComboBox()
	 {
		 service = new HotelCustomerImpl();
		 
		 ObservableList<String> optionsOne = FXCollections.observableArrayList(
				 "星级排序","好评优先","低价排序");
		 ObservableList<String> optionsTwo = FXCollections.observableArrayList(
				 "五星级","四星级","三星级","二星级","一星级","默认星级");
		 ObservableList<String> optionsThree = FXCollections.observableArrayList(
				 "酒店促销优惠","网站促销优惠");
		 
		 //为三个筛选逻辑的选择框添加内容
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
		 
		 //为三个筛选逻辑选择框添加事件响应
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
				 new PromotionPageUI(choiceThree).showAndWait();
			 }
		});
	 }

	 //星级筛选策略方法，通过filter添加和删除条件来实现筛选功能
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

	//内部类，为表格最后的列，添加按钮
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
	 
	 //内部类，为表格最后的列，添加按钮
	 public class MakeOrderButtonCell extends TableCell<HotelVO, Boolean>
	 {
		 private Button makeOrderButton = new Button();
		 
		 public MakeOrderButtonCell(Stage stage)
		 {	
			 makeOrderButton.setStyle("-fx-background-color:transparent;");
			 ImageView imageView = new ImageView();
			 imageView.setFitHeight(30);
			 imageView.setFitWidth(30);
			 Image image = new Image(getClass().getResourceAsStream("CustomerImage/GouWuChe.png"));
			 imageView.setImage(image);
			 makeOrderButton.setGraphic(imageView);
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
	 
	 //搜索事件响应
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
					hotelData.add(hotelVO);
				} 
			 }
			 list.setItems(hotelData);
		}

}
