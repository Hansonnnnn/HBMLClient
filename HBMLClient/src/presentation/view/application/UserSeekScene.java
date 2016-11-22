package presentation.view.application;





import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserSeekScene extends Scene	{
	
	/*
	 * 找回界面网状布局
	 */
	private GridPane seekGridPane;
	
	/*
	 * 横向布局
	 */
	private HBox manageHBox;
	
	/*
	 * 酒店管理系统标签
	 */
	private Label manageLabel;
	
	private HBox hBox;
	
	/*
	 * 返回按钮
	 */
	private Button backButton;
	
	/*
	 * 分隔符
	 */
	private Separator separator;
	
	/*
	 * 找回密码标签
	 */
	private Label seekLabel;
	
	/*
	 * 姓名标签
	 */
	private Label nameLabel;
	
	/*
	 * 姓名文本域
	 */
	private TextField nameTextField;
	
	/*
	 * 手机号码标签
	 */
	private Label phoneLabel;
	
	/*
	 * 手机号码文本域
	 */
	private TextField phoneTextField;
	
	/*
	 * 确认按钮
	 */
	private Button confirmButton;
	
	/*
	 * 垂直布局
	 */
	private	VBox vBox;
	
	private Label whiteLabel;
	private Label blankLabel;
	public UserSeekScene(Group root,Stage stage,Scene beforeScene) {
		super(root);
		seekGridPane=new GridPane();
		seekGridPane.setHgap(10);
		seekGridPane.setVgap(10);
		
		addManageLabel(seekGridPane);
		
		hBox=new HBox();
		hBox.setSpacing(10);
		backButton=new Button("返回");
		backButton.setId("backButton");
		backButton.setOnAction((ActionEvent event)->{
			stage.setScene(beforeScene);
		});
		separator=new Separator();
		separator.setOrientation(Orientation.VERTICAL);
		seekLabel=new Label("找回密码");
		seekLabel.setId("seekLabel");
		hBox.getChildren().addAll(backButton,separator,seekLabel);
		seekGridPane.add(hBox, 0, 1,3,1);
		
		nameLabel=new Label("    姓名");
		nameTextField=new TextField();
		nameTextField.setPrefWidth(200);
		whiteLabel=new Label("  ");
		seekGridPane.add(nameLabel, 0, 2);
		seekGridPane.add(nameTextField, 1, 2);
		seekGridPane.add(whiteLabel, 2, 2);
		
		phoneLabel=new Label("    手机号码");
		phoneTextField=new TextField();
		blankLabel=new Label("  ");
		seekGridPane.add(phoneLabel, 0, 3);
		seekGridPane.add(phoneTextField, 1, 3);
		seekGridPane.add(blankLabel, 2, 3);
	
		vBox=new VBox();
		confirmButton=new Button("确           认");
		confirmButton.setPrefWidth(180);
		confirmButton.setId("confirmButton");
		vBox.getChildren().add(confirmButton);
		vBox.setAlignment(Pos.CENTER);
		seekGridPane.add(vBox, 0, 4,3,1);
		
		this.getStylesheets().add(UserSeekScene.class.getResource("seek.css").toExternalForm());
		root.getChildren().add(seekGridPane);
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
