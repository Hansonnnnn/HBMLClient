package presentation.view.WebMarketerUI;


import java.security.KeyStore.PrivateKeyEntry;

import javax.xml.validation.ValidatorHandler;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreditScene extends Scene{
	
	/*
	 * 网状布局
	 */
	private GridPane creditGridPane;
	
	private Label idLabel;
	
	private TextField idTextField;
	
	private Label rechargeLabel;
	
	private TextField rechargeTextField;
	
	private HBox hBox;
	
	private Label yuanLabel;
	
	private Button confirmButton;
	
	private HBox confirmHBox;
	
	public CreditScene(Group root,Stage stage,Scene beforeScene,WebMarker webMarker,Scene loginScene) {
		super(root);
		creditGridPane=new GridPane();
		creditGridPane.setVgap(10);
		creditGridPane.setHgap(10);
		
		webMarker.addManageLabel(creditGridPane,2,330);
		webMarker.addUserWindow(creditGridPane, "信用值充值",beforeScene,loginScene,stage,2);
		
		idLabel=new Label("        用户编号 ");
		idTextField=new TextField();
		creditGridPane.add(idLabel, 0, 2);
		creditGridPane.add(idTextField, 1, 2);
		
		rechargeLabel=new Label("        充值金额 ");
		hBox=new HBox();
		rechargeTextField=new TextField();
		yuanLabel=new Label("元");
		hBox.getChildren().addAll(rechargeTextField,yuanLabel);
		creditGridPane.add(rechargeLabel, 0, 3);
		creditGridPane.add(hBox, 1, 3);
		
		confirmHBox=new HBox();
		confirmButton=new Button("确  认  充  值");
		confirmButton.setId("confirmButton");
		confirmButton.setPrefWidth(200);
		confirmHBox.getChildren().add(confirmButton);
		confirmHBox.setAlignment(Pos.CENTER);
		creditGridPane.add(confirmHBox, 0, 4,2,1);
		
//		VBox vBox=new VBox();
//		vBox.setId("vBox");
//		creditGridPane.add(vBox, 0, 5,2,1);
		
		this.getStylesheets().add(CreditScene.class.getResource("credit.css").toExternalForm());
		root.getChildren().add(creditGridPane);
	}

}
