package presentation.view.WebMarketerUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

        regionPromotionData= FXCollections.observableArrayList();
        regionPromotionData.add(new regionPromotion("江苏省","南京市","仙林",2,70));
        regionPromotionData.add(new regionPromotion("湖南省","长沙市","雨花区",2,70));
        regionPromotionTableView.setItems(regionPromotionData);
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
