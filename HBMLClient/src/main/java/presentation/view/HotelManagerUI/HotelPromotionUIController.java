package presentation.view.HotelManagerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Created by LENOVO on 2016/11/27.
 */
public class HotelPromotionUIController {

    @FXML private TableView hotelPromotionTableView;
    @FXML private TableColumn promotionNameTableColumn;
    @FXML private TableColumn promotionStartTableColumn;
    @FXML private TableColumn promotionEndTableColumn;
    @FXML private TableColumn memberLevelTableColumn;
    @FXML private TextField nametextField;

    private Stage stage;
    private Scene beforeScene;
    private Scene loginScene;
    private Scene thisScene;
    private ObservableList promotionData;

    public void init(Stage stage,Scene beforeScene,Scene thisScene,Scene loginScene){
        this.stage=stage;
        this.beforeScene=beforeScene;
        this.loginScene=loginScene;
        this.thisScene=thisScene;
        initTableView();
    }

    /**
     * 点击返回按钮，返回到上一个界面
     */
    @FXML
    private void back(){
        stage.setScene(beforeScene);
    }

    /**
     * 点击注销按钮，返回到登录界面
     */
    @FXML
    private void backToLogin(){
        stage.setScene(loginScene);
    }

    private void initTableView(){
        promotionNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("promotionName"));
        promotionStartTableColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        promotionEndTableColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        memberLevelTableColumn.setCellValueFactory(new PropertyValueFactory<>("memberLevel"));

        promotionData=FXCollections.observableArrayList();
        promotionData.add(new HotelPromotionInfo("双十一","2016.11.11 00:00","2016.11.12 00:00",5));
        promotionData.add(new HotelPromotionInfo("双十二","2016.12.12 00:00","2116.12.13 00:00",5));
        promotionData.add(new HotelPromotionInfo("团购满减","2015.1.5 00:00","2015.1.6 00:00",0));
        promotionData.add(new HotelPromotionInfo("新年甩卖","2016.1.31 00:00","2016.2.15 00:00",0));

        if(hotelPromotionTableView.getSelectionModel().getSelectedItems()!=null) {
            hotelPromotionTableView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
                nametextField.setText(((HotelPromotionInfo)hotelPromotionTableView.getSelectionModel().getSelectedItem()).getPromotionName());
            });
        }
        hotelPromotionTableView.setItems(promotionData);
    }

    /**
     * 跳转至促销策略详细信息界面
     */
    @FXML
    private void toPromotionInfo(){
        stage.setScene(new PromotionInfoUI(new Group(),stage,thisScene,loginScene));
    }

    /**
     * 跳转至制定新促销策略界面
     */
    @FXML
    private void toNewPromotion(){
        stage.setScene(new NewPromotionUI(new Group(),stage,thisScene,loginScene));
    }

    public class HotelPromotionInfo{
        String promotionName;
        String startTime;
        String endTime;
        int memberLevel;

        public HotelPromotionInfo(String promotionName, String startTime, String endTime, int memberLevel){
            this.promotionName=promotionName;
            this.startTime=startTime;
            this.endTime=endTime;
            this.memberLevel=memberLevel;
        }

        public int getMemberLevel() {
            return memberLevel;
        }

        public void setMemberLevel(int memberLevel) {
            this.memberLevel = memberLevel;
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
