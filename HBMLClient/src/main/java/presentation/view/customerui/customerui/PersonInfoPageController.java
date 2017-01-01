package presentation.view.customerui.customerui;

import java.io.File;
import java.util.Date;

import businesslogic.userbl.UserCustomerImpl;
import businesslogicservice.userblservice.UserCustomerService;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.DateHelper;
import presentation.view.application.MyDialog;
import vo.UserVO;

public class PersonInfoPageController {
	@FXML private Button backButton;
	@FXML private Button editImageButton;
	@FXML private Button vipEnrollButton;
	@FXML private ImageView headImageView;
	@FXML private Label creditValueLabel;
	@FXML private TextField nameField;
	@FXML private DatePicker birthDatePicker;
	@FXML private TextField numberField;
	@FXML private Button saveButton;
	@FXML private Label rankLabel;
	
	private Stage stage;
	private Scene preScene;
	private Scene presentScene;
	private UserVO userVO;
	private File choiceFile;
	
	private FileChooser fileChooser;
	private UserCustomerService customerService;
	
	private String userName;
	private String birthday;
	private String contact;
	
	//初始化关于个人信息界面的配置信息、固定标签内容、初始化头像
	public void init(Stage stage, Scene preScene, Scene presentScene, UserVO userVO)
	{
		this.stage = stage;
		this.preScene = preScene;
		this.presentScene = presentScene;
		this.userVO = userVO;
		userName = userVO.getName();
		nameField.setPromptText(userName);
		contact = userVO.getContact();
		numberField.setPromptText(contact);
		creditValueLabel.setText(userVO.getCreditValue()+"");
		rankLabel.setText(userVO.getRank()+"");
		birthDatePicker.setPromptText(userVO.getMemberInfo());
		birthday = userVO.getMemberInfo();
		customerService = new UserCustomerImpl();
		initHeadImage();
	}
	
	private void initHeadImage()
	{
		if(userVO.getPortrait()!=null){
	   		 Image  headImage=new Image("file:///"+userVO.getPortrait().getAbsolutePath().replace('\\', '/').replaceAll("HBMLClient/HBMLClient", "Final_HBMSServer/HBMSServer"));
	   		 headImageView.setImage(headImage);
	   	}
	}
	@FXML
	private void back()
	{
		stage.setScene(preScene);
	}
	
	@FXML
	private void enroll()
	{
		stage.setScene(new EnrollVIPPage(new Group(), stage, presentScene, userVO));
	}
	
	//编辑上传头像
	@FXML
	private void editImage()
	{
		fileChooser = new FileChooser();
		choiceFile = fileChooser.showOpenDialog(stage);
		fileChooser.setTitle("选择头像");
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("JPG","*.JPG"),
				new FileChooser.ExtensionFilter("PNG","*PNG")
				);
		if (choiceFile!=null) 
		{
	         Image image=new Image("file:///"+choiceFile.getPath());
	         headImageView.setImage(image);
		}
	}
	
	@FXML
	private void save()
	{
		if(nameField.getText()!=null&&!nameField.getText().isEmpty())
		{
			userName = nameField.getText();
		}
		if(birthDatePicker.getValue()!=null)
		{
			Date tempDate = DateHelper.localDateToDate(birthDatePicker.getValue());
			birthday = DateHelper.dateToString(tempDate);
		}
		if(numberField.getText()!=null&&!numberField.getText().isEmpty())
		{
			contact = numberField.getText();
		}
		userVO = new UserVO(userVO.getUserID(), userVO.getUserType(),
				userVO.getAccountName(), userVO.getPassword(), userName, 
				contact, choiceFile, userVO.getCreditValue(),
				userVO.getMemberType(), birthday, userVO.getRank(),
				userVO.getWorkid(), userVO.getHotelid());
		customerService.modifyUser(userVO);
		new MyDialog(stage, "保存信息成功", 2);
		stage.setScene(preScene);
	}
}
