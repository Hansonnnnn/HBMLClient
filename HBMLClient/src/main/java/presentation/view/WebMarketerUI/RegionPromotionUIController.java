package presentation.view.WebMarketerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 * Created by LENOVO on 2016/12/7.
 */
public class RegionPromotionUIController {

    @FXML private TableView regionPromotionTableView;
    @FXML private TableColumn proviceTableColumn;
    @FXML private TableColumn cityTableColumn;
    @FXML private TableColumn regionTableColumn;
    @FXML private TableColumn memberGradeTableColumn;
    @FXML private TableColumn discountTableColumn;
    @FXML private TableColumn operationTableColumn;


    private ObservableList regionPromotionData;
    public void init(){
        initTableView();
    }

    /**
     * 初始化regionPromotionTableView;
     */
    private void initTableView(){
        proviceTableColumn.setCellValueFactory(new PropertyValueFactory<>("provice"));
        cityTableColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        regionTableColumn.setCellValueFactory(new PropertyValueFactory<>("region"));
        memberGradeTableColumn.setCellValueFactory(new PropertyValueFactory<>("memberGrade"));
        discountTableColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        operationTableColumn.setCellFactory(new Callback<TableColumn<regionPromotion,Boolean>, TableCell<regionPromotion,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new RegionPromotionButtonCell();
            }
        });

        regionPromotionData= FXCollections.observableArrayList();
        regionPromotionData.add(new regionPromotion("江苏省","南京市","仙林",2,70));
        regionPromotionData.add(new regionPromotion("湖南省","长沙市","雨花区",2,70));
        regionPromotionTableView.setItems(regionPromotionData);
    }

    public class RegionPromotionButtonCell extends TableCell<regionPromotion,Boolean>{
        private Button deleteButton=new Button();
        private ImageView deleteImageView=new ImageView(new Image(getClass().getResourceAsStream("webmarketerimages/delete.png")));
        public RegionPromotionButtonCell(){
            deleteButton.setStyle("-fx-background-color: transparent");
            deleteImageView.setFitHeight(35);
            deleteImageView.setFitWidth(35);
            deleteButton.setGraphic(deleteImageView);
        }

        @Override
        protected  void updateItem(Boolean t,boolean empty){
            super.updateItem(t,empty);
            if(empty){
                setGraphic(null);
                setText(null);
            }else{
                setGraphic(deleteButton);
                setText(null);
            }
        }
    }

    public class regionPromotion{
        private String provice;
        private String city;
        private String region;
        private int memberGrade;
        private int discount;
        public regionPromotion(String provice,String city,String region,int memberGrade,int discount){
            this.provice=provice;
            this.city=city;
            this.region=region;
            this.memberGrade=memberGrade;
            this.discount=discount;
        }

        public String getProvice() {
            return provice;
        }

        public void setProvice(String provice) {
            this.provice = provice;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public int getMemberGrade() {
            return memberGrade;
        }

        public void setMemberGrade(int memberGrade) {
            this.memberGrade = memberGrade;
        }

        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }
    }
}
