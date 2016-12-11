package presentation.view.HotelManagerUI;

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

/**
 * Created by LENOVO on 2016/11/27.
 */
public class HotelPromotionUIController {

    @FXML private TableView hotelPromotionTableView;
    @FXML private TableColumn promotionNameTableColumn;
    @FXML private TableColumn promotionStartTableColumn;
    @FXML private TableColumn promotionEndTableColumn;
    @FXML private TableColumn operationTableColumn;

    @FXML private VBox hotelPromotionVBox;
//    @FXML private VBox otherPromotionVBox1;

    private ObservableList promotionData;
    private VBox infoVBox;
    private VBox thisVBox;
    public void init(VBox infoVBox,VBox thisVBox){
        this.infoVBox=infoVBox;
        this.thisVBox=thisVBox;
        initTableView();
    }

    /**
     * 初始化hotelPromotionTableView
     */
    private void initTableView(){
        promotionNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("promotionName"));
        promotionStartTableColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        promotionEndTableColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        operationTableColumn.setCellFactory(new Callback<TableColumn<HotelPromotionInfo,Boolean>, TableCell<HotelPromotionInfo,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new PromotionInfoButtonCell(infoVBox,thisVBox);
            }
        });

        promotionData=FXCollections.observableArrayList();
        promotionData.add(new HotelPromotionInfo("双十一","2016.11.11 00:00","2016.11.12 00:00"));
        promotionData.add(new HotelPromotionInfo("双十二","2016.12.12 00:00","2116.12.13 00:00"));
        promotionData.add(new HotelPromotionInfo("团购满减","2015.1.5 00:00","2015.1.6 00:00"));
        promotionData.add(new HotelPromotionInfo("新年甩卖","2016.1.31 00:00","2016.2.15 00:00"));
        hotelPromotionTableView.setItems(promotionData);
    }

    /**
     * 点击酒店活动优惠按钮,显示优惠策略列表
     */
    @FXML
    private void toHotelPromotion(){
        hotelPromotionVBox.setVisible(true);
//        otherPromotionVBox1.setVisible(false);
    }

    /**
     * 点击其他促销策略按钮，显示生日和企业优惠界面
     */
    @FXML
    private void toOtherPromotion(){
//        otherPromotionVBox1.setVisible(true);
        hotelPromotionVBox.setVisible(false);
    }


    /**
     * 跳转至制定新促销策略界面
     */
    @FXML
    private void toNewPromotion(){
        infoVBox.getChildren().remove(0);
//        infoVBox.getChildren().add()
    }

    /**
     * 在酒店促销策略列表添加查看策略信息按钮
     */
    public class PromotionInfoButtonCell extends TableCell<HotelPromotionInfo,Boolean>{
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
                infoVBox.getChildren().remove(0);
                infoVBox.getChildren().add(new PromotionInfoUI(infoVBox,beforeVBox));
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

    public class HotelPromotionInfo{
        String promotionName;
        String startTime;
        String endTime;
        public HotelPromotionInfo(String promotionName, String startTime, String endTime){
            this.promotionName=promotionName;
            this.startTime=startTime;
            this.endTime=endTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getPromotionName() {
            return promotionName;
        }

        public void setPromotionName(String promotionName) {
            this.promotionName = promotionName;
        }
    }
}
