package presentation.view.HotelManagerUI;

import businesslogic.promotionbl.PromotionStaffImpl;
import businesslogicservice.promotionblservice.PromotionStaffService;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import model.PromotionFilter;
import vo.PromotionVO;
import vo.UserVO;

/**
 * Created by LENOVO on 2016/11/27.
 */
public class HotelPromotionUIController {

    @FXML private TableView hotelPromotionTableView;
    @FXML private TableColumn promotionNameTableColumn;
    @FXML private TableColumn promotionStartTableColumn;
    @FXML private TableColumn promotionEndTableColumn;
    @FXML private TableColumn operationTableColumn;
    @FXML private ComboBox customerDiscountBox;
    @FXML private ComboBox companyDiscountBox;
    @FXML private VBox hotelPromotionVBox;
    @FXML private VBox otherPromotionVBox1;
    @FXML private Label sliderLabel;

    private ObservableList promotionData;
    private VBox infoVBox;
    private VBox thisVBox;
    private Stage stage;
    private UserVO userVO;
    private PromotionStaffService promotionStaffService;
    public void init(VBox infoVBox, VBox thisVBox, Stage stage, UserVO userVO){
        this.infoVBox=infoVBox;
        this.thisVBox=thisVBox;
        this.stage=stage;
        this.userVO=userVO;
        promotionStaffService=new PromotionStaffImpl();
        initTableView();
    }

    /**
     * 初始化hotelPromotionTableView
     */
    private void initTableView(){
        promotionNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        promotionStartTableColumn.setCellValueFactory(new PropertyValueFactory<>("startDateString"));
        promotionEndTableColumn.setCellValueFactory(new PropertyValueFactory<>("endDateString"));
        operationTableColumn.setCellFactory(new Callback<TableColumn<PromotionVO,Boolean>, TableCell<PromotionVO,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new PromotionInfoButtonCell(infoVBox,thisVBox);
            }
        });

        promotionData=FXCollections.observableArrayList();
        PromotionFilter promotionFilter=new PromotionFilter();
        promotionFilter.add("region","=",userVO.getHotelid());
        if(promotionStaffService.getHotelPromotionList(promotionFilter)!=null){
            for (PromotionVO promotionVO:promotionStaffService.getHotelPromotionList(promotionFilter).values()) {
                promotionData.add(promotionVO);
            }
        }else{
            System.out.println("数据库促销数据为空");
        }
        hotelPromotionTableView.setItems(promotionData);
    }

    /**
     * 点击酒店活动优惠按钮,显示优惠策略列表
     */
    @FXML
    private void toHotelPromotion(){
        hotelPromotionVBox.setVisible(true);
        otherPromotionVBox1.setVisible(false);
        moveOperationButtonBackground(sliderLabel,35);
    }

    /**
     * 点击其他促销策略按钮，显示生日和企业优惠界面
     */
    @FXML
    private void toOtherPromotion(){
        otherPromotionVBox1.setVisible(true);
        hotelPromotionVBox.setVisible(false);
        moveOperationButtonBackground(sliderLabel,165);
    }

    /**
     * 设置按钮下边界滑动效果
     */
    private void moveOperationButtonBackground(Label label, double x){
        Timeline timeline=new Timeline();
        timeline.setAutoReverse(false);
        KeyValue newX=new KeyValue(label.layoutXProperty(),x);
        KeyFrame kf=new KeyFrame(Duration.millis(300),newX);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }


    /**
     * 跳转至制定新促销策略界面
     */
    @FXML
    private void toNewPromotion(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new NewPromotionUI(infoVBox,thisVBox,userVO,stage));
    }

    /**
     * 在酒店促销策略列表添加查看策略信息按钮
     */
    public class PromotionInfoButtonCell extends TableCell<PromotionVO,Boolean>{
        private HBox operationHBox=new HBox();
        private Button deleteButton=new Button();
        private Button viewButton=new Button();
        private ImageView viewImageView=new ImageView(new Image(getClass().getResourceAsStream("ManagerImages/view1.png")));
        private ImageView deleteImageView=new ImageView(new Image(getClass().getResourceAsStream("ManagerImages/delete.png")));
        public PromotionInfoButtonCell(VBox infoVBox,VBox beforeVBox){
            operationHBox.getChildren().addAll(viewButton,deleteButton);
            viewButton.setGraphic(viewImageView);
            viewButton.setStyle("-fx-background-color: transparent");
            deleteButton.setGraphic(deleteImageView);
            deleteButton.setStyle("-fx-background-color: transparent");
            viewButton.setOnAction((ActionEvent e)->{
                int selectedIndex=getTableRow().getIndex();
                PromotionVO promotionVO=(PromotionVO)hotelPromotionTableView.getItems().get(selectedIndex);
                infoVBox.getChildren().remove(0);
                infoVBox.getChildren().add(new PromotionInfoUI(infoVBox,beforeVBox,promotionVO));
            });
        }

        @Override
        protected void updateItem(Boolean t,boolean empty){
            super.updateItem(t,empty);
            if(empty){
                setGraphic(null);
                setText(null);
            }else{
                setGraphic(operationHBox);
                setText(null);
            }
        }
    }
}
