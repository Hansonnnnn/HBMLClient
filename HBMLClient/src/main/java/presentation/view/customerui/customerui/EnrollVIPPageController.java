package presentation.view.customerui.customerui;

import businesslogic.userbl.UserCustomerImpl;
import businesslogicservice.userblservice.UserCustomerService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.DateHelper;
import model.MemberType;
import presentation.view.application.MyDialog;
import vo.UserVO;

public class EnrollVIPPageController {
	@FXML private Button backButton;
	@FXML private TextField nameField;
	@FXML private DatePicker birthPicker;
	@FXML private TextField numberField;
	@FXML private TextField companyNameField;
	@FXML private ComboBox<String> typeComboBox;
	@FXML private Button enrollButton;
	@FXML private HBox birthHBox;
	@FXML private HBox contactHBox;
	@FXML private HBox companyNameHBox;
	@FXML private ImageView headImageView; 
	
	private Stage stage;
	private Scene preScene;
	private UserVO userVO;
	private String vipType;
	private String memberInfo;
	private MemberType memberType;
	private String contact;
	private UserCustomerService customerService;
	
	public void init(Stage stage, Scene preScene, UserVO userVO)
	{
		this.stage = stage;
		this.preScene = preScene;
		this.userVO = userVO;
		customerService = new UserCustomerImpl();
		memberInfo = userVO.getMemberInfo();
		memberType = userVO.getMemberType();
		contact = userVO.getContact();
		companyNameHBox.setDisable(true);
		vipType = "普通会员";
		if(userVO.getName()!=null)
		{
			nameField.setPromptText(userVO.getName());
		}
		if(memberInfo!=null)
		{
			if(memberInfo.indexOf('@')==-1)
			{
				birthPicker.setPromptText(memberInfo);
			}else
			{
				int index = memberInfo.indexOf("@");
				birthPicker.setPromptText(memberInfo.substring(0, index));
			}
		}
		if(contact!=null)
		{
			numberField.setPromptText(contact);
		}
		initComboBox();
		initHeadImage();
	}
	
	@FXML
	private void back()
	{
		stage.setScene(preScene);
	}
	
	@FXML 
	private void enroll()
	{
		if(vipType.equals("企业会员"))
		{
			memberType = MemberType.Enterprise;
			if(birthPicker.getValue()!=null)
			{
				memberInfo = DateHelper.dateToString(DateHelper.localDateToDate(birthPicker.getValue()));
			}
			if(companyNameField.getText()!=null&&!companyNameField.getText().isEmpty())
			{
				memberInfo = memberInfo.concat("@" + companyNameField.getText()); 
			}
		}
		if(numberField.getText()!=null&&!numberField.getText().isEmpty())
		{
			contact = numberField.getText();
		}
		userVO = new UserVO(userVO.getUserID(), userVO.getUserType(), userVO.getAccountName(), 
				userVO.getPassword(), userVO.getName(), userVO.getContact(), userVO.getPortrait(),
				userVO.getCreditValue(), memberType, memberInfo, userVO.getRank(),
				userVO.getWorkid(), userVO.getHotelid());
		customerService.modifyUser(userVO);
		new MyDialog(stage, "注册会员成功！", 2);
		stage.setScene(preScene);
	}
	
	private void initComboBox()
	{
		String[] typeArr = new String[]{"普通会员","企业会员"};
		ObservableList<String> typeData = FXCollections.observableArrayList();
		typeData.addAll(typeArr);
		
		if(typeComboBox.getItems().isEmpty())
		{
			typeComboBox.getItems().addAll(typeData);
		}
		
		typeComboBox.valueProperty().addListener(new ChangeListener<String>() {
			 @Override
			 public void changed(ObservableValue ov, String oldValue, String newValue){
				vipType = newValue;
				if(vipType.equals("企业会员"))
				{
					companyNameHBox.setDisable(false);
					if(memberInfo!=null)
					{
						if(memberInfo.indexOf('@')!=-1)
						{
							int index = memberInfo.indexOf("@");
							companyNameField.setPromptText(memberInfo.substring(index));
						}
					}
					memberType = MemberType.Enterprise;
				}
				else if(vipType.equals("普通会员"))
				{
					companyNameField.setDisable(true);
					memberType = MemberType.Person;
				}
			 }
		});
		
	}
	
	private void initHeadImage()
	{
		if(userVO.getPortrait()!=null){
	   		 Image  headImage=new Image("file:///"+userVO.getPortrait().getAbsolutePath().replace('\\', '/').replaceAll("HBMLClient/HBMLClient", "Final_HBMSServer/HBMSServer"));
	   		 headImageView.setImage(headImage);
	   	}
	}
}
