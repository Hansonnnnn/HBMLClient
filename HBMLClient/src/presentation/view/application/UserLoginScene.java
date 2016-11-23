package presentation.view.application;





import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import presentation.view.WebMarketerUI.WebMarker;

public class UserLoginScene {
	/*
     * 网状布局
     */
	private GridPane gridPane;
	
	/*
	 * 用户登录标签
	 */
	private Label mainLabel;
	
	/*
	 * 分隔符
	 */
	private Separator separator;
	
	/*
	 * 账号标签
	 */
	private Label accountLabel;
	
	/*
	 * 账号文本域
	 */
	private TextField accountTextField;
	
	/*
	 * 注册按钮
	 */
	private Button registerButton;
	
	/*
	 * 密码标签
	 */
	private Label passwordLabel;
	
	/*
	 * 密码文本域
	 */
	private PasswordField passwordField;
	
	/*
	 * 找回密码按钮
	 */
	private Button seekButton;
	
	/*
	 * 登录按钮
	 */
	private Button loginButton;
	
//	/*
//	 * 关闭图标
//	 */
//	private Image closeImage=new Image(getClass().getResourceAsStream("close.png"));
//	
//	/*
//	 * 最小化图标
//	 */
//	private Image minimizeImage=new Image(getClass().getResourceAsStream("minimize.png"));
//	
//	public Image getCloseImage() {
//		return closeImage;
//	}
//
//
//	public Image getMinimizeImage() {
//		return minimizeImage;
//	}

	private double xOffset = 0;
	
	private double yOffset = 0;
	
	public UserLoginScene(Stage primaryStage) {
		gridPane=new GridPane();
		Scene scene=new Scene(gridPane,400,210);
		
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
//		addCustomWindow(gridPane);
		mainLabel=new Label("用户登录");
		mainLabel.setId("mainLabel");
		mainLabel.setFont(Font.font("微软雅黑",20));
		gridPane.add(mainLabel, 0, 1);
		
		separator=new Separator();
		separator.setId("separator1");
		gridPane.add(separator, 0, 2,3,1);
		
		accountLabel=new Label("   账号:");
		accountLabel.setFont(Font.font("微软雅黑"));
		gridPane.add(accountLabel, 0, 3);
		
		accountTextField=new TextField();
		gridPane.add(accountTextField, 1, 3);
		
		registerButton=new Button("账号注册");
		registerButton.getStyleClass().add("button1");
		gridPane.add(registerButton, 2, 3);
		
		passwordLabel=new Label("   密码:");
		passwordLabel.setFont(Font.font("微软雅黑"));
		gridPane.add(passwordLabel, 0, 4);
		
		passwordField=new PasswordField();
		gridPane.add(passwordField, 1, 4);
		
		seekButton=new Button("找回密码");
		seekButton.getStyleClass().add("button1");
		gridPane.add(seekButton, 2, 4);
		
		loginButton=new Button("安   全   登   录");
		loginButton.setId("loginButton");
		loginButton.setPrefSize(200, 30);
		
		HBox hBox=new HBox(10);
		hBox.setAlignment(Pos.BOTTOM_RIGHT);
		hBox.getChildren().add(loginButton);
		gridPane.add(hBox, 1, 5);
		
	
		registerButton.setOnAction((ActionEvent e)->{
			primaryStage.setScene(new UserRegisterScene(new Group(),primaryStage,scene));
		});
		gridPane.setAlignment(Pos.CENTER);
		
		seekButton.setOnAction((ActionEvent e)->{
			primaryStage.setScene(new UserSeekScene(new Group(), primaryStage, scene));
		});
		
		
		accountTextField.setText("11");
		passwordField.setText("admin");
		loginButton.setOnAction((ActionEvent e)->{
			if(accountTextField.getText().equals("11")
					&&passwordField.getText().equals("admin")){
				primaryStage.setScene(new WebMarker(new Group(),primaryStage,scene));
			}
		});
		
		primaryStage.setScene(scene);
//		canWindowDrag(scene, primaryStage);
		scene.getStylesheets().add(UserLoginScene.class.getResource("beauty.css").toExternalForm());
		primaryStage.show();
	}
	
	
//	/*
//	 * 实现自定义窗口的鼠标拖动
//	 */
//	public void canWindowDrag(Scene root,Stage primaryStage){
//		root.setOnMousePressed((MouseEvent event)->{
//			event.consume();
//			xOffset=event.getSceneX();
//			yOffset=event.getSceneY();
//		});
//		
//		root.setOnMouseDragged((MouseEvent event)->{
//			event.consume();
//			primaryStage.setX(event.getScreenX()-xOffset);
//			primaryStage.setY(event.getScreenY()-yOffset);
//		});
//	}
//	
//	/**
//	 * 实现添加自定义窗口
//	 * @param pane 布局
//	 */
//	public void addCustomWindow(GridPane pane){
//		HBox hBox=new HBox();
//		Button closeButton=new Button();
//		closeButton.setGraphic(new ImageView(getCloseImage()));
//		Button minimizeButton=new Button();
//		minimizeButton.setGraphic(new ImageView(getMinimizeImage()));
//		hBox.getChildren().addAll(closeButton,minimizeButton);
//		closeButton.setAlignment(Pos.TOP_RIGHT);
//		minimizeButton.setAlignment(Pos.CENTER_RIGHT);
//		pane.add(hBox, 0, 0,3,1);
//	}
//	/*
//	 * 实现自定义窗口自由改变大小
//	 */
//	public void canWindowChangeSize(Scene view,Stage stage){
//		view.setOnMouseMoved((MouseEvent event) -> {
//			event.consume();
//			double x = event.getSceneX();
//			double y = event.getSceneY();
//			double width = stage.getWidth();
//			double height = stage.getHeight();
//			Cursor cursorType = Cursor.DEFAULT;
//			isRight = isBottomRight = isBottom = false;
//			
//	}
}
