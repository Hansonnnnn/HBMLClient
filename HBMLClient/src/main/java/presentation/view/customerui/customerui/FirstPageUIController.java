package presentation.view.customerui.customerui;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import businesslogic.hotelInfobl.HotelCustomerImpl;
import businesslogic.hotelInfobl.helper.RegionHelper;
import businesslogicservice.hotelinfoblservice.HotelCustomerService;
import businesslogicservice.hotelinfoblservice.HotelRegionHelper;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.DateHelper;
import vo.HotelVO;
import vo.RegionVO;

public class FirstPageUIController {
	@FXML private TextField searchField;
	@FXML private Button searchButton;
	@FXML private Button firstPageButton;
	@FXML private Button orderButton;
	@FXML private Button commentButton;
	@FXML private Button personInfoButton;
	@FXML private Button loginButton;
	
	@FXML private Button searchTwoButton;
	
	@FXML private ChoiceBox<String> provinceBox;
	@FXML private ChoiceBox<String> cityBox;
	@FXML private ChoiceBox<String> regionBox;
	@FXML private DatePicker checkinTimePicker;
	@FXML private DatePicker checkoutTimePicker;
	@FXML private Button searchByConditionsButton;
	@FXML private CheckBox fiveStarCheckBox;
	@FXML private CheckBox fourStarCheckBox;
	@FXML private CheckBox threeStarCheckBox;
	@FXML private CheckBox twoStarCheckBox;
	@FXML private CheckBox oneStarCheckBox;
	
	private Scene firstPageUI;
	private Stage stage;
	
	private boolean state;
	private String userName;
	private int userID;
	
	private Map<Integer, HotelVO> hotelList = null;
	private HotelRegionHelper helper = null;
	private String provinceName;
	private ObservableList<String> provinceShowList;
	private String cityName;
	private ObservableList<String> cityShowList;
	private String regionName;
	private ObservableList<String> regionNameShowList ;
	private Map<String, Integer> regionNameMap ;
	private int regionID;
	private Date checkinTime;
	private Date checkoutTime;
	private DateHelper dateHelper;
	private ObservableList<String> defaultList;
	
	public void init(Stage stage, Scene firstPageUI)
	{
		this.stage = stage;
		this.firstPageUI = firstPageUI;
		helper = new RegionHelper();
		initDatePicker();
		initProvinceBox();
	}
	
	@FXML
	private void orderPartAction()
	{
		stage.setScene(new OrderFirstPageUIFromFirstPage(new Group(),stage,firstPageUI, userID));
	}
	
	@FXML
	private void commentPartAction()
	{
		stage.setScene(new CommentPageUIFromFirstPage(new Group(),stage,firstPageUI));
	}
	
	@FXML
	private void personalInfoPartAction()
	{
		if(!state)
		{
			stage.setScene(new NullUserPage(new Group(), stage, firstPageUI));
		}else
		{
			stage.setScene(new PersonalCenterPage(new Group(), stage, firstPageUI, userName));
		}
	}
	
//	@FXML
//	private void search()
//	{
//		String searchInfo = "绿地洲际酒店";
//		if(searchField.getText()!=null&&!searchField.getText().isEmpty())
//		{
//			searchInfo = searchField.getText();
//		}
//		checkinTime = DateHelper.localDateToDate(checkinTimePicker.getValue());
//		stage.setScene(new HotelListPageUI(new Group(), stage, firstPageUI, searchInfo, checkinTime,state));
//	}
	
	@FXML 
	private void searchByConditions()
	{
		int star = 1;
		String hotelName = null;
		if(searchField.getText()!=null&&!searchField.getText().isEmpty())
		{
			hotelName = searchField.getText();
		}
		//获取两个DatePicker里面的时间
		checkinTime = DateHelper.localDateToDate(checkinTimePicker.getValue());
		checkoutTime = DateHelper.localDateToDate(checkoutTimePicker.getValue());
//		//获得星级
//		if(fiveStarCheckBox.isSelected()){star = 5;}
//		if(fourStarCheckBox.isSelected()){star = 4;}
//		if(threeStarCheckBox.isSelected()){star = 3;}
//		if(twoStarCheckBox.isSelected()){star = 2;}
//		if(oneStarCheckBox.isSelected()){star = 1;}
		stage.setScene(new HotelListPageUI(new Group(), stage, firstPageUI, provinceName, cityName, regionID,hotelName, checkinTime, star, state));
	}
	
	private void initDatePicker()
	{
		checkinTimePicker.setPromptText(LocalDate.now().toString());
		checkoutTimePicker.setPromptText(LocalDate.now().toString());
		checkinTimePicker.setValue(LocalDate.now());
		final Callback<DatePicker, DateCell> dateCellFactory = new Callback<DatePicker, DateCell>() 
		{
			@Override
			public DateCell call(final DatePicker datePicker)
			{
				return new DateCell()
						{
							@Override
							public void updateItem(LocalDate item, boolean empty)
							{
								super.updateItem(item, empty);
								if(item.isBefore(checkinTimePicker.getValue().plusDays(1)))
								{
									setDisable(true);
									 setStyle("-fx-background-color: #ffc0cb;");
								}
							}
						};
			}
		};
		checkoutTimePicker.setDayCellFactory(dateCellFactory);
		checkoutTimePicker.setValue(LocalDate.now().plusDays(1));
	}
	
	private void initProvinceBox()
	{
		List<String> provinceMap = helper.getProvinces();
		provinceShowList = FXCollections.observableArrayList();
		provinceShowList.addAll(provinceMap);
		provinceBox.setItems(provinceShowList);
		defaultList = FXCollections.observableArrayList();
		defaultList.add("");
		
		provinceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				provinceName = provinceShowList.get(newValue.intValue());
				cityBox.setItems(defaultList);
				regionBox.setItems(defaultList);
				initCityBox();
			}
		});
		
		cityBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue()>=0) {
					cityName = cityShowList.get(newValue.intValue());
					regionBox.setItems(defaultList);
					initRegionBox();
				}
				
			}
			
		});
		
		regionBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue()>=0) {
					regionID = regionNameMap.get(regionNameShowList.get(newValue.intValue()));
				}
			}
			
		});
		
	}
	
	private void initCityBox()
	{
		List<String> cityNameList = helper.getCities(provinceName);
		cityShowList = FXCollections.observableArrayList();
		cityShowList.addAll(cityNameList);
		defaultList = FXCollections.observableArrayList();
		defaultList.add("");
		cityBox.setItems(cityShowList);
	
	}
	
	private void initRegionBox()
	{
		Map<Integer, RegionVO> regionMap = helper.getRegions(cityName);
		regionNameMap = new LinkedHashMap<>();
		
		for (int key : regionMap.keySet()) {
			regionNameMap.put(regionMap.get(key).getRegionName(), key);
		}
	
		regionNameShowList = FXCollections.observableArrayList();
		regionNameShowList.addAll(regionNameMap.keySet());
		regionBox.setItems(regionNameShowList);
		
	
	}
	@FXML 
	private void login()
	{
		if(state)
		{
			new LogoutPageUI(stage, firstPageUI, this).showAndWait();
		}else 
		{
			new LoginPageUI(stage, firstPageUI, this).showAndWait();
		}
	}
	public boolean getState()
	{
		return state;
	}
	public void setState(boolean state, String userName, int userID)
	{
		this.state = state;
		this.userName = userName;
		this.userID = userID;
	}
	public void setState(boolean state)
	{
		this.state = state;
	}
}
