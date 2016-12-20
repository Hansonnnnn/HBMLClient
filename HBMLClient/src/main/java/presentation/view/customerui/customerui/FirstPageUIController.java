package presentation.view.customerui.customerui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import businesslogic.hotelInfobl.helper.RegionHelper;
import businesslogicservice.hotelinfoblservice.HotelRegionHelper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.DateHelper;
import presentation.view.application.MyDialog;
import vo.HotelVO;
import vo.RegionVO;
import vo.UserVO;

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
	@FXML private Button starButton1;
    @FXML private Button starButton2;
    @FXML private Button starButton3;
    @FXML private Button starButton4;
    @FXML private Button starButton5;
    @FXML private ImageView starImageView1;
    @FXML private ImageView starImageView2;
    @FXML private ImageView starImageView3;
    @FXML private ImageView starImageView4;
    @FXML private ImageView starImageView5;
    
    private ArrayList<ImageView> imageViews;
	
	private Image starImage = new Image(getClass().getResourceAsStream("../CustomerImage/star.png"));
	private Image blueStarImage = new Image(getClass().getResourceAsStream("../CustomerImage/bluestar.png"));
	private Scene firstPageUI;
	private Stage stage;
	
	private boolean logined;
	private UserVO userVO;
	
	private HotelRegionHelper helper = null;
	private String provinceName;
	private ObservableList<String> provinceShowList;
	private String cityName;
	private ObservableList<String> cityShowList;
	private ObservableList<String> regionNameShowList ;
	private Map<String, Integer> regionNameMap ;
	private int regionID;
	private int star;
	private Date checkinTime;
	private ObservableList<String> defaultList;
	
	public void init(Stage stage, Scene firstPageUI, UserVO userVO, boolean logined)
	{
		this.stage = stage;
		this.firstPageUI = firstPageUI;
		helper = new RegionHelper();
		this.userVO = userVO;
		this.logined  = logined;
		initDatePicker();
		initProvinceBox();
		initstar();
	}
	
	@FXML
	private void orderPartAction()
	{
//		System.out.println(userID);
//		stage.setScene(new OrderFirstPageUIFromFirstPage(new Group(),stage,firstPageUI, userID));
		if(logined)
		{
			stage.setScene(new OrderFirstPageUIFromFirstPage(new Group(),stage,firstPageUI, userVO.getUserID()));
		}
		else
		{
			new MyDialog(stage, "请登录", 0);
		}
	}
	
	@FXML
	private void commentPartAction()
	{
		if(logined)
		{
			stage.setScene(new CommentPageUIFromFirstPage(new Group(),stage,firstPageUI,userVO.getUserID()));
		}
		else
		{
			new MyDialog(stage, "请登录", 0);
		}
		
	}
	
	@FXML
	private void personalInfoPartAction()
	{
		if(!logined)
		{
			new MyDialog(stage, "请登录", 0);
		}else
		{
			stage.setScene(new PersonalCenterPage(new Group(), stage, firstPageUI, userVO));
		}
	}
	
	
	@FXML 
	private void searchByConditions()
	{
		String hotelName = null;
		if(searchField.getText()!=null&&!searchField.getText().isEmpty())
		{
			hotelName = searchField.getText();
		}
		//获取两个DatePicker里面的时间
		checkinTime = DateHelper.localDateToDate(checkinTimePicker.getValue());
		
		stage.setScene(new HotelListPageUI(new Group(), stage, firstPageUI,userVO, regionID,hotelName, checkinTime, star, logined));
	}
	
	private void initstar() {
        imageViews = new ArrayList<>();
        imageViews.add(starImageView1);
        imageViews.add(starImageView2);
        imageViews.add(starImageView3);
        imageViews.add(starImageView4);
        imageViews.add(starImageView5);

        starButton1.setOnAction((ActionEvent e) -> {
            star = 1;
            for (int j = 0; j <= 0; j++) {
                imageViews.get(j).setImage(blueStarImage);
            }
            for (int k = 0 + 1; k < imageViews.size(); k++) {
                imageViews.get(k).setImage(starImage);
            }
        });
        starButton2.setOnAction((ActionEvent e) -> {
            star = 2;
            for (int j = 0; j <= 1; j++) {
                imageViews.get(j).setImage(blueStarImage);
            }
            for (int k = 1 + 1; k < imageViews.size(); k++) {
                imageViews.get(k).setImage(starImage);
            }
        });
        starButton3.setOnAction((ActionEvent e) -> {
            star = 3;
            for (int j = 0; j <= 2; j++) {
                imageViews.get(j).setImage(blueStarImage);
            }
            for (int k = 2 + 1; k < imageViews.size(); k++) {
                imageViews.get(k).setImage(starImage);
            }
        });
        starButton4.setOnAction((ActionEvent e) -> {
            star = 4;
            for (int j = 0; j <= 3; j++) {
                imageViews.get(j).setImage(blueStarImage);
            }
            for (int k = 3 + 1; k < imageViews.size(); k++) {
                imageViews.get(k).setImage(starImage);
            }
        });
        starButton5.setOnAction((ActionEvent e) -> {
            star = 5;
            for (int j = 0; j <= 4; j++) {
                imageViews.get(j).setImage(blueStarImage);
            }
            for (int k = 4 + 1; k < imageViews.size(); k++) {
                imageViews.get(k).setImage(starImage);
            }
        });
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
		if(logined)
		{
			stage.setScene(new WelcomePageUILogoutEdition(new Group(), stage, firstPageUI, this, userVO.getName()));
		}else 
		{
			stage.setScene(new WelcomePageUI(new Group(), stage));
		}
	}
	public boolean getState()
	{
		return logined;
	}
	public void setState(boolean logined, String userName, int userID)
	{
		this.logined = logined;
//		this.userName = userName;
//		this.userID = userID;
	}
	public void setState(boolean logined)
	{
		this.logined = logined;
	}
}
