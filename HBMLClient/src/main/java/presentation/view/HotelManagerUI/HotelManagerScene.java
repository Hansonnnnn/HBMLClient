package presentation.view.HotelManagerUI;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HotelManagerScene extends Scene {

	/*
	 * 纵向布局
	 */
    private VBox vBox;

	/*
	 * 头标题节点的List
	 */
    private ArrayList<Node> nodes;

	/*
	 * 酒店管理标签
	 */
    private Label managerLabel;

	/*
	 * 存放酒店管理人员操作按钮的list
	 */
    private ArrayList<Button> buttonLists;

//	private Image backImage=new Image(getClass().getResourceAsStream("back.png"));


    public HotelManagerScene(Group root, Stage stage, Scene beforeScene) {
        super(root);
        vBox = new VBox();
        vBox.setSpacing(20);
        vBox.setPrefSize(500, 500);

        nodes = new ArrayList<>();
        managerLabel = new Label("HBMS酒店管理系统");
        managerLabel.setStyle("-fx-font-size:25px");
        nodes.add(managerLabel);
        vBox.getChildren().add(addHeadTitle("张三", beforeScene, beforeScene, nodes, false, stage));


        buttonLists = new ArrayList<>();
        buttonLists.add(new Button("订单浏览/执行"));
        buttonLists.add(new Button("录入可用客房"));
        buttonLists.add(new Button("更新入住/退房消息"));
        buttonLists.add(new Button("录入酒店信息"));
        buttonLists.add(new Button("制定促销策略"));

        for (int i = 0; i < buttonLists.size(); i++) {
            toLarger(buttonLists.get(i));
            vBox.getChildren().add(addButtonBorder(buttonLists.get(i)));
        }

        addOperationEvent(buttonLists, stage, beforeScene);
        vBox.getChildren().add(addBelowAcross());
        root.getChildren().add(vBox);
    }

    public VBox addHeadTitle(String name, Scene beforeScene, Scene managerScene,
                             ArrayList<Node> nodes, boolean judge, Stage stage) {
        VBox titleVBox = new VBox();
        titleVBox.setSpacing(10);

        HBox blankHBox = new HBox();
        blankHBox.getStyleClass().add("blankHBox");
        blankHBox.setPadding(new Insets(0, 0, 0, 10));
        blankHBox.setAlignment(Pos.CENTER_LEFT);
        for (int i = 0; i < nodes.size(); i++) {
            blankHBox.getChildren().add(nodes.get(i));
        }

        BorderPane borderPane = new BorderPane();
        Image backImage = new Image(getClass().getResourceAsStream("back.png"));
        Image cancelImage = new Image(getClass().getResourceAsStream("cancel.png"));
        Image userImage = new Image(getClass().getResourceAsStream("user.png"));

        Button backButton = new Button();
        backButton.setGraphic(new ImageView(backImage));
        backButton.getStyleClass().add("transButton");
        backButton.setVisible(judge);
        toLarger(backButton);
        backButton.setOnAction((ActionEvent e) -> {
            stage.setScene(beforeScene);
        });

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_RIGHT);
        Button userButton = new Button();
        userButton.setGraphic(new ImageView(userImage));
        userButton.getStyleClass().add("transButton");
        Label nameLabel = new Label(name + ",欢迎您");
        nameLabel.setStyle("-fx-font-size:17px");
        Button cancelButton = new Button();
        cancelButton.setGraphic(new ImageView(cancelImage));
        cancelButton.getStyleClass().add("transButton");

        toLarger(cancelButton);
        cancelButton.setOnAction((ActionEvent e) -> {
            stage.setScene(managerScene);
        });

        hBox.getChildren().addAll(userButton, nameLabel, cancelButton);
        borderPane.setLeft(backButton);
        borderPane.setRight(hBox);
        titleVBox.getChildren().addAll(blankHBox, borderPane);
        this.getStylesheets().add(HotelManagerScene.class.getResource("manager.css").toExternalForm());

        return titleVBox;
    }

    /**
     * 实现鼠标移动节点上，节点放大
     *
     * @param node 需要放大的节点
     */
    public void toLarger(Node node) {
        node.setOnMouseEntered((MouseEvent e) -> {
            node.setScaleX(1.2);
            node.setScaleY(1.2);
        });

        node.setOnMouseExited((MouseEvent e) -> {
            node.setScaleX(1);
            node.setScaleY(1);
        });
    }


    /**
     * 实现设置按钮的样式，并当鼠标移动到按钮上时，添加蓝色边界
     *
     * @param button
     * @return
     */
    public HBox addButtonBorder(Button button) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        button.setPrefSize(250, 70);
        //为按钮添加css，当鼠标移动到按钮上时，按钮边界变蓝色
        button.getStyleClass().add("managerButton");
        hBox.getChildren().add(button);
        return hBox;
    }

	/*
	 * 在界面下方添加灰色分隔行
	 */
    public HBox addBelowAcross() {
        HBox hBox = new HBox();
        hBox.getStyleClass().add("blankHBox");
        hBox.setPrefHeight(40);
        return hBox;

    }

    public void addOperationEvent(ArrayList<Button> buttons, Stage stage, Scene loginScene) {
        buttons.get(0).setOnAction((ActionEvent e) -> {
            stage.setScene(new orderBrowseScene(new Group(), stage, this, this, loginScene));
        });
        buttons.get(1).setOnAction((ActionEvent e)->{
            stage.setScene(new InputRoomUI(new Group(),stage,this,loginScene));
        });
        buttons.get(2).setOnAction((ActionEvent e)->{
            stage.setScene(new UpdateRoomUI(new Group(),stage,this,loginScene));
        });
        buttons.get(3).setOnAction((ActionEvent e)->{
            stage.setScene(new HotelInfoUI(new Group(),stage,this,loginScene));
        });

    }
}