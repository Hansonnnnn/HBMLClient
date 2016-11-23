package presentation.view.WebMarketerUI;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class PromotionScene extends Scene{
	
	/*
	 * 网状布局
	 */
	private GridPane promotionGridPane;
	
	/*
	 * 策略类型标签
	 */
	private Label typeLabel;
	
	/*
	 * 策略类型选择框
	 */
	private ChoiceBox<String> typeChoiceBox;
	
	/*
	 * 策略名称标签
	 */
	private Label nameLabel;
	
	/*
	 * 策略名称文本域
	 */
	private TextField nameTextField;
	
	/*
	 * 策略内容标签
	 */
	private Label contentLabel;
	
	/*
	 * 策略文本域
	 */
	private TextArea contentTextArea;
	
	/*
	 * 促销策略开始日期标签
	 */
	private Label startLabel;
	
	/*
	 * 促销策略开始日期选择器
	 */
	private DatePicker startDatePicker;
	
	/*
	 * 促销策略结束日期标签
	 */
	private Label endLabel;
	
	/*
	 * 促销策略结束日期选择器
	 */
	private DatePicker endDatePicker;
	
	/*
	 * 所需会员等级标签
	 */
	private Label levelLabel;
	
	/*
	 * 所需会员等级文本框
	 */
	private TextField levelTextField;
	
	/*
	 * 商圈标签
	 */
	private Label regionLabel;
	
	/*
	 * 商圈选择框
	 */
	private ChoiceBox<String> regionChoiceBox;
	
	/*
	 * 确认制定按钮
	 */
	private Button confirmButton;
	public PromotionScene(Group root,Stage stage,Scene beforeScene,WebMarker webMarker,Scene loginScene) {
		super(root);
		
		promotionGridPane=new GridPane();
		promotionGridPane.setVgap(10);
		promotionGridPane.setHgap(10);
		promotionGridPane.setPrefWidth(620);
		webMarker.addManageLabel(promotionGridPane,2,470);
		webMarker.addUserWindow(promotionGridPane, "营销策略制定", beforeScene, loginScene, stage,2);
		
		typeLabel=new Label("    策略类型 ");
		typeChoiceBox=new ChoiceBox<>(FXCollections.observableArrayList("打折","满减","降价","抽奖"));
		promotionGridPane.add(typeLabel, 0, 2);
		promotionGridPane.add(typeChoiceBox, 1, 2);
		
		nameLabel=new Label("    策略名称");
		nameTextField=new TextField();
		nameTextField.setPrefWidth(250);
		promotionGridPane.add(nameLabel, 0, 3);
		promotionGridPane.add(nameTextField, 1, 3);
		
		contentLabel=new Label("    策略内容");
		VBox vBox=new VBox();
		vBox.getChildren().add(contentLabel);
		contentTextArea=new TextArea();
		contentTextArea.setId("contentTextArea");
		
		promotionGridPane.add(vBox, 0, 4);
		promotionGridPane.add(contentTextArea, 1, 4);
		
		startLabel=new Label("    开始日期");
		startDatePicker=new DatePicker();
		endLabel=new Label("      结束日期 ");
		endDatePicker=new DatePicker();
		addDatePick(startLabel,startDatePicker,endLabel,endDatePicker,promotionGridPane);
		
		levelLabel=new Label("所需会员等级"); 
		levelTextField=new TextField();
		levelTextField.setPrefWidth(210);
		regionLabel=new Label("          商圈");
		regionChoiceBox=new ChoiceBox<>(FXCollections.observableArrayList("仙林","鼓楼","浦口"));
		HBox levelHBox=new HBox();
		levelHBox.setSpacing(8);
		levelHBox.getChildren().addAll(levelTextField,regionLabel,regionChoiceBox);
		promotionGridPane.add(levelLabel, 0, 6);
		promotionGridPane.add(levelHBox, 1, 6);
		
		confirmButton=new Button("确   认   制   定");
		confirmButton.setPrefWidth(210);
		confirmButton.setId("confirmButton");
		VBox confirmVBox=new VBox();
		confirmVBox.getChildren().add(confirmButton);
		confirmVBox.setAlignment(Pos.CENTER_RIGHT);
		promotionGridPane.add(confirmVBox, 1, 7);
		
		VBox blankVBox=new VBox();
		blankVBox.setPrefSize(610, 30);
		blankVBox.setId("blankVBox");
		promotionGridPane.add(blankVBox, 0, 8,2,1);
		
		this.getStylesheets().add(PromotionScene.class.getResource("promotion.css").toExternalForm());
		root.getChildren().add(promotionGridPane);
	}
	
	
	/**
	 * 实现在网状布局中添加日期选择器
	 * @param startLabel 促销开始日期标签
	 * @param startDatePicker 促销开始日期选择器
	 * @param endLabel 促销结束日期标签
	 * @param endDatePiker 促销结束日期选择器
	 * @param promotionGridPane 促销网状布局
	 */
	public void addDatePick(Label startLabel,DatePicker startDatePicker,
			Label endLabel,DatePicker endDatePiker,GridPane promotionGridPane){
		HBox hBox=new HBox();
		startDatePicker.setValue(LocalDate.now());
		final Callback<DatePicker, DateCell> dayCellFactory = 
		      new Callback<DatePicker, DateCell>() {
		           @Override
		           public DateCell call(final DatePicker datePicker) {
		               return new DateCell() {
		                   @Override
		                   public void updateItem(LocalDate item, boolean empty) {
		                       super.updateItem(item, empty);
		                       if (item.isBefore(
		                               startDatePicker.getValue().plusDays(1))
		                           ) {
		                               setDisable(true);
		                               setStyle("-fx-background-color: #ffc0cb;");
		                       }
		                       long p = ChronoUnit.DAYS.between(
		                               startDatePicker.getValue(), item
		                       );
		                       setTooltip(new Tooltip(
		                           "You're about to stay for " + p + " days")
		                       );
		                   }
		               };
		           }
		       };
		endDatePiker.setDayCellFactory(dayCellFactory);
		endDatePiker.setValue(startDatePicker.getValue().plusDays(1));
		startDatePicker.setPrefWidth(209);
		endDatePiker.setPrefWidth(209);
		hBox.getChildren().addAll(startDatePicker,endLabel,endDatePiker);
		promotionGridPane.add(startLabel, 0, 5);
		promotionGridPane.add(hBox, 1, 5);
	}
	
	
	
}
