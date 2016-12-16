package presentation.view.customerui.customerui;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Date;
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
import model.HotelFilter;
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
	
	private Map<Integer, HotelVO> hotelList = null;
	private HotelRegionHelper helper = null;
	private String provinceName;
	private String cityName;
	private String regionName;
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
		stage.setScene(new OrderFirstPageUIFromFirstPage(new Group(),stage,firstPageUI));
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
	
	@FXML
	private void search()
	{
		String searchInfo = "绿地洲际酒店";
		if(searchField.getText()!=null&&!searchField.getText().isEmpty())
		{
			searchInfo = searchField.getText();
		}
		stage.setScene(new HotelListPageUI(new Group(), stage, firstPageUI, searchInfo,state));
	}
	
	@FXML 
	private void searchByConditions()
	{
		int star = 1;
		//获取两个DatePicker里面的时间
		checkinTime = DateHelper.localDateToDate(checkinTimePicker.getValue());
		checkoutTime = DateHelper.localDateToDate(checkoutTimePicker.getValue());
		//获得星级
		if(fiveStarCheckBox.isSelected())
		{
			star = 5;
//			HotelFilter filter = new HotelFilter();
//			filter.add("star", "=", star);
//			HotelCustomerService serviceImpl = new HotelCustomerImpl();
//			hotelList = serviceImpl.getHotelList(filter, "score", new Date());
		}
		if(fourStarCheckBox.isSelected()){star = 4;}
		if(threeStarCheckBox.isSelected()){star = 3;}
		if(twoStarCheckBox.isSelected()){star = 2;}
		if(oneStarCheckBox.isSelected()){star = 1;}
		stage.setScene(new HotelListPageUI(new Group(), stage, firstPageUI, provinceName, cityName, regionName, checkinTime, star, state));
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
		ObservableList<String> provinceShowList = FXCollections.observableArrayList();
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
		
	}
	
	private void initCityBox()
	{
		List<String> cityNameList = helper.getCities(provinceName);
		ObservableList<String> cityShowList = FXCollections.observableArrayList();
		cityShowList.addAll(cityNameList);
		defaultList = FXCollections.observableArrayList();
		defaultList.add("");
		cityBox.setItems(cityShowList);
		
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
	}
	
	private void initRegionBox()
	{
		Map<Integer, RegionVO> regionMap = helper.getRegions(cityName);
		String[] regionNameList = new String[regionMap.size()];
		int index = 0;
		for (RegionVO regionVO : regionMap.values())
		{
			regionNameList[index++] = regionVO.getRegionName();
		}
		ObservableList<String> regionNameShowList = FXCollections.observableArrayList();
		regionNameShowList.addAll(regionNameList);
		regionBox.setItems(regionNameShowList);
	}
	@FXML 
	private void login()
	{
		new LoginPageUI(stage, firstPageUI, this).showAndWait();
	}
	public boolean getState()
	{
		return state;
	}
	public void setState(boolean state, String userName)
	{
		this.state = state;
		this.userName = userName;
	}
}
