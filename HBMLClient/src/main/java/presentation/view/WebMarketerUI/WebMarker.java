package presentation.view.WebMarketerUI;






import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WebMarker extends Scene{
	/*
	 * 网状布局
	 */
	private GridPane webGridPane;
	
	
	/*
	 * 按钮
	 */
	private Button cancelButton;
	
	/**
	 * 边界布局
	 */
	
	private Label nameLabel;
	
	private Button userButton;
	
	private Button orderButton;
	
	private Button promotionButton;
	
	private Button creditButton;
	
	private Image orderImage=new Image(getClass().getResourceAsStream("order.png"));
	
	private Image promotionImage=new Image(getClass().getResourceAsStream("promotion.png"));
	
	private Image creditImage=new Image(getClass().getResourceAsStream("credit.png"));
	
	private Image cancelImage=new Image(getClass().getResourceAsStream("cancel.png"));
	
	private Image userImage=new Image(getClass().getResourceAsStream("user.png"));
	
	private Image backImage=new Image(getClass().getResourceAsStream("back.png"));
	
	public WebMarker(Group root,Stage stage,Scene beforeScene) {
		super(root);
		webGridPane=new GridPane();
		webGridPane.setVgap(10);
		webGridPane.setHgap(20);
//		webGridPane.setPadding(new Insets(10,10,10,10));
		
		addManageLabel(webGridPane,3,615);
		
		HBox hBox=new HBox();
		cancelButton=new Button();
		cancelButton.setGraphic(new ImageView(cancelImage));
		cancelButton.setOnAction((ActionEvent e)->{
			stage.setScene(beforeScene);
		});
		cancelButton.setId("cancel");
		toLarger(cancelButton);
		nameLabel=new Label("张三");
		nameLabel.setId("name");
		userButton=new Button();
		userButton.setId("user");
		userButton.setGraphic(new ImageView(userImage));
		hBox.setAlignment(Pos.CENTER_RIGHT);
		hBox.getChildren().addAll(userButton,nameLabel,cancelButton);
		webGridPane.add(hBox, 0, 1,3,1);
		
		
		orderButton=new Button();
		orderButton.setId("order");
		orderButton.setGraphic(new ImageView(orderImage));
		promotionButton=new Button();
		promotionButton.setId("promotion");
		promotionButton.setGraphic(new ImageView(promotionImage));
		creditButton=new Button();
		creditButton.setId("credit");
		creditButton.setGraphic(new ImageView(creditImage));
		operationEvent(orderButton, promotionButton, creditButton, stage,beforeScene);
		toLarger(orderButton);
		toLarger(promotionButton);
		toLarger(creditButton);
		webGridPane.add(orderButton, 0, 2);
		webGridPane.add(promotionButton, 1, 2);
		webGridPane.add(creditButton, 2, 2);
		
		VBox vBox=new VBox();
		vBox.setId("vBox");
		vBox.setPrefHeight(30);
		webGridPane.add(vBox, 0, 3,3,1);
		
		
		this.getStylesheets().add(WebMarker.class.getResource("Web.css").toExternalForm());
		root.getChildren().add(webGridPane);
	}
	
	/**
	 * 实现添加酒店管理系统标签
	 * @param seekGridPane 包含标签的布局
	 */
	public void addManageLabel(GridPane seekGridPane,int columnIndex,int width){
		HBox manageHBox=new HBox();
		manageHBox.setId("manageHBox");
		manageHBox.setPrefWidth(width);
		Label manageLabel=new Label("酒店管理系统");
		manageLabel.setId("manageLabel");
		manageHBox.setStyle("-fx-background-color:#BEBEBE;");
		manageLabel.setStyle("-fx-font-weight:bold;-fx-font-size:21px;");
		
		manageHBox.getChildren().addAll(manageLabel);
		manageHBox.setAlignment(Pos.CENTER);
		seekGridPane.add(manageHBox, 0, 0,columnIndex,1);
	}
	
	/**
	 * 实现当鼠标移到组件上的时候，组件放大，鼠标移开后恢复原状
	 * @param node 需要放大的组件
	 */
	public void toLarger(Node node){
		node.setOnMouseEntered((MouseEvent e)->{
			node.setScaleX(1.2);
			node.setScaleY(1.2);
		});
		node.setOnMouseExited((MouseEvent e)->{
			node.setScaleX(1);
			node.setScaleY(1);
		});
	}
	
	/**
	 * 实现添加用户和返回窗口
	 * @param gridPane 包含窗口的布局
	 * @param operation 网站营销人员进行的操作名
	 */
	public void addUserWindow(GridPane gridPane,String operation,Scene beforeScene,
			Scene login,Stage stage,int columnIndex){
		HBox backHBox=new HBox();
		backHBox.setSpacing(10);
		Button backButton=new Button();
		backButton.setGraphic(new ImageView(backImage));
		backButton.setOnAction((ActionEvent e)->{
			stage.setScene(beforeScene);
		});
		toLarger(backButton);
		backButton.setStyle("-fx-background-color:transparent");
		Separator separator=new Separator();
		separator.setOrientation(Orientation.VERTICAL);
		Label operationLabel=new Label(operation);
		operationLabel.setStyle("-fx-font-weight:bold;-fx-font-size:21px;");
		backHBox.getChildren().addAll(backButton,separator,operationLabel);
		
		HBox userHBox=new HBox();
		Button cancelButton=new Button();
		cancelButton.setGraphic(new ImageView(cancelImage));
		cancelButton.setStyle("-fx-background-color:transparent");
		cancelButton.setOnAction((ActionEvent e)->{
			stage.setScene(login);
		});
		toLarger(cancelButton);
		Label nameLabel=new Label("张三");
		nameLabel.setStyle("-fx-font-size:16px;");
		Button userButton=new Button();
		userButton.setStyle("-fx-background-color:transparent");
		userButton.setGraphic(new ImageView(userImage));
		userHBox.setAlignment(Pos.CENTER_RIGHT);
		userHBox.getChildren().addAll(userButton,nameLabel,cancelButton);
		
		BorderPane borderPane=new BorderPane();
		borderPane.setLeft(backHBox);
		borderPane.setRight(userHBox);
		gridPane.add(borderPane, 0, 1,columnIndex,1);
		
	}
	
	/**
	 * 实现点击不同的操作按钮，跳转至对应操作的界面
	 * @param order 异常订单处理按钮
	 * @param promotion 促销策略制定按钮
	 * @param credit 信用值充值按钮
	 * @param stage 主stage
	 * @param beforeScene 各界面对应的前一个界面
	 */
	public void operationEvent(Button order,Button promotion,Button credit,Stage stage,Scene beforeScene){
		//跳转至异常订单处理界面
		order.setOnAction((ActionEvent e)->{
			stage.setScene(new orderScene(new Group(), stage, this, this, beforeScene));
		});
		
		//跳转至促销策略制定界面
		promotion.setOnAction((ActionEvent e)->{
			stage.setScene(new PromotionScene(new Group(), stage, this, this, beforeScene));
		});
		
		//条状至信用值充值界面
		credit.setOnAction((ActionEvent e)->{
			stage.setScene(new CreditScene(new Group(), stage, this, this,beforeScene));
		});
	}
	
}
