package presentation.view.application;



import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UserRegisterScene extends Scene{
	/*
	 * 注册网状布局
	 */
	private GridPane registerGridPane;
	
	/*
	 * 用户注册标签
	 */
	private Label registerLabel;
	
	/*
	 * 分隔符
	 */
	private Separator separator;
	
	/*
	 * 注册姓名标签
	 */
	private Label registerNameLabel;
	
	/*
	 * 姓名文本域
	 */
	private TextField nameTextField;
	
	/*
	 * 注册密码标签
	 */
	private Label registerPasswordLabel;
	
	/*
	 * 密码文本域
	 */
	private PasswordField registerPasswordField;
	
	/*
	 * 联系方式标签
	 */
	private Label phoneLabel;
	
	/*
	 * 联系方式文本域
	 */
	private TextField phoneTextField;
	
	/*
	 * 注册按钮
	 */
	private Button registerButton;
	
	/*
	 * 返回登录界面按钮
	 */
	private Button backButton;
	
	/*
	 * 返回按钮与用户登录标签的分隔符
	 */
	private Separator backSeparator;
	
	
		
	public UserRegisterScene(Group root,Stage stage,Scene beforeScene) {
		super(root);
		registerGridPane=new GridPane();
		
		registerGridPane.setId("r");
		registerGridPane.setHgap(10);
		registerGridPane.setVgap(10);
		
		addManageLabel(registerGridPane);
		
		HBox hBox=new HBox();
		hBox.setSpacing(10);
		backSeparator=new Separator();
		backSeparator.setOrientation(Orientation.VERTICAL);
		backButton=new Button("返回");
		backButton.setId("backButton");
		backButton.setOnAction((ActionEvent e)->{
			stage.setScene(beforeScene);
		});

		registerLabel=new Label("用户注册");
		registerLabel.setFont(Font.font("微软雅黑",20));
		hBox.getChildren().addAll(backButton,backSeparator,registerLabel);
		registerGridPane.add(hBox, 0,1,3,1);
		
		
		
		registerNameLabel=new Label("    姓名");
		registerGridPane.add(registerNameLabel, 0, 3);
		nameTextField=new TextField();
		registerGridPane.add(nameTextField, 1, 3);
		
		registerPasswordLabel=new Label("    密码");
		registerGridPane.add(registerPasswordLabel, 0, 5);
		registerPasswordField=new PasswordField();
		registerGridPane.add(registerPasswordField, 1, 5);
		
		phoneLabel=new Label("    联系方式");
		registerGridPane.add(phoneLabel, 0, 7);
		phoneTextField=new TextField();
		registerGridPane.add(phoneTextField, 1, 7);
		
		registerButton=new Button("立   即   注   册");
		registerButton.setPrefSize(202, 30);
		registerButton.setId("registerButton");
		registerGridPane.add(registerButton, 1, 8);
		
		this.getStylesheets().add(UserRegisterScene.class.getResource("reg.css").toExternalForm());
		root.getChildren().add(registerGridPane);
	}
	
	public void addManageLabel(GridPane seekGridPane){
		HBox manageHBox=new HBox();
		manageHBox.setId("manageHBox");
		Label manageLabel=new Label("酒店管理系统");
		manageLabel.setId("manageLabel");
		
		manageHBox.getChildren().addAll(manageLabel);
		manageHBox.setAlignment(Pos.CENTER);
		seekGridPane.add(manageHBox, 0, 0,3,1);
	}
	
}
