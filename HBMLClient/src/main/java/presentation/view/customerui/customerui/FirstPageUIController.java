package presentation.view.customerui.customerui;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FirstPageUIController {
	@FXML private TextField searchField;
	@FXML private Button searchButton;
	@FXML private Button firstPageButton;
	@FXML private Button orderButton;
	@FXML private Button commentButton;
	@FXML private Button personInfoButton;
	@FXML private ImageView hotelPicView;
	@FXML private Button loginButton;
	
	@FXML private Button searchTwoButton;
	@FXML private TextField address_field;
	@FXML private TextField circle_field;
	@FXML private DatePicker checkinTimePicker;
	@FXML private DatePicker checkoutTimePicker;
//	@FXML private 如何判断选中星级
	@FXML private Button searchByConditionsButton;
	
	private Scene firstPageUI;
	private Stage stage;
	
	public void init(Stage stage, Scene firstPageUI)
	{
		this.stage = stage;
		this.firstPageUI = firstPageUI;
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
		stage.setScene(new PersonInfoPageFromFirstPage(new Group(),stage, firstPageUI));
	}
	
	@FXML
	private void search()
	{
		String searchInfo = "recommendedHotel";
		if(searchField.getText()!=null&&!searchField.getText().isEmpty())
		{
			searchInfo = searchField.getText();
		}
		stage.setScene(new HotelListPageUI(new Group(), stage, firstPageUI, searchInfo));
	}
	
	@FXML 
	private void searchByConditions()
	{
		String address = "江苏省南京市";
		String region = "栖霞区";
		String checkinTime = "2016:12:08";
		String checkoutTime = "2016:12:08";
		int star = 1;
		if(address_field.getText()!=null&&!address_field.getText().isEmpty())
		{
			address = address_field.getText();
		}
		if(circle_field.getText()!=null&&!circle_field.getText().isEmpty())
		{
			region = circle_field.getText();
		}
		
		//获取两个DatePicker里面的时间
		
		
		stage.setScene(new HotelListPageUI(new Group(), stage, firstPageUI, address, region, checkinTime, checkoutTime, star));
	}
	@FXML 
	private void login()
	{
		new LoginPageUI();
	}
	
}
