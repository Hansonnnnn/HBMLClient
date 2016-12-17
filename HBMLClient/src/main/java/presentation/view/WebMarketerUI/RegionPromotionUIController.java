package presentation.view.WebMarketerUI;

import businesslogic.hotelInfobl.helper.RegionHelper;
import businesslogicservice.hotelinfoblservice.HotelRegionHelper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import vo.RegionVO;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @FXML private ComboBox provinceBox;
    @FXML private ComboBox cityBox;
    @FXML private ComboBox regionBox;
    @FXML private ComboBox gradeBox;
    @FXML private ComboBox discountBox;

    private ObservableList gradeData;
    private ObservableList discountData;
    private ObservableList regionPromotionData;
    private ObservableList<String> provinceShowList;
    private ObservableList<String> cityShowList;
    private ObservableList<String> regionNameShowList ;
    private Map<String, Integer> regionNameMap ;
    private HotelRegionHelper helper;
    private ObservableList<String> defaultList;
    private String provinceName;
    private String cityName;
    private int regionID;
    public void init(){
        helper = new RegionHelper();
        gradeData=FXCollections.observableArrayList();
        discountData=FXCollections.observableArrayList();
        for(int i=1;i<100;i++){
            discountData.add(i);
            if(i<=7){
                gradeData.add(i);
            }
        }
        gradeBox.setItems(gradeData);
        discountBox.setItems(discountData);
        initProvinceBox();
        initTableView();
    }

    /**
     * 初始化数据
     */
    private void initProvinceBox(){
        List<String> provinceMap = helper.getProvinces();
        provinceShowList = FXCollections.observableArrayList();
        provinceShowList.addAll(provinceMap);
        provinceBox.setItems(provinceShowList);
        defaultList = FXCollections.observableArrayList();
        defaultList.add("");
        provinceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                provinceName = provinceShowList.get(newValue.intValue());
                cityBox.setItems(defaultList);
                regionBox.setItems(defaultList);
                initCityBox();
            }
        });
        cityBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue()>=0) {
                    cityName = cityShowList.get(newValue.intValue());
                    regionBox.setItems(defaultList);
                    initRegionBox();
                }
            }
        });
        regionBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue()>=0) {
                    regionID = regionNameMap.get(regionNameShowList.get(newValue.intValue()));
                }
            }
        });
    }

    private void initCityBox(){
        List<String> cityNameList = helper.getCities(provinceName);
        cityShowList = FXCollections.observableArrayList();
        cityShowList.addAll(cityNameList);
        defaultList = FXCollections.observableArrayList();
        defaultList.add("");
        cityBox.setItems(cityShowList);
    }

    private void initRegionBox() {
        Map<Integer, RegionVO> regionMap = helper.getRegions(cityName);
        regionNameMap = new LinkedHashMap<>();
        for (int key : regionMap.keySet()) {
            regionNameMap.put(regionMap.get(key).getRegionName(), key);
        }
        regionNameShowList = FXCollections.observableArrayList();
        regionNameShowList.addAll(regionNameMap.keySet());
        regionBox.setItems(regionNameShowList);
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
