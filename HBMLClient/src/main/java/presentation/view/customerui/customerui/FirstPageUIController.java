package presentation.view.customerui.customerui;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
		
	}
	@FXML 
	private void login()
	{
		
	}
	
}
