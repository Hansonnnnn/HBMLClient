package presentation.view.WebMarketerUI;

import businesslogic.hotelInfobl.helper.RegionHelper;
import businesslogic.promotionbl.PromotionWebMarketerImpl;
import businesslogicservice.hotelinfoblservice.HotelRegionHelper;
import businesslogicservice.promotionblservice.PromotionWebMarketerService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.PromotionFilter;
import presentation.view.application.MyDialog;
import vo.PromotionVO;
import vo.RegionVO;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LENOVO on 2016/12/7.
 */
public class RegionPromotionUIController {

    @FXML private TableView<regionPromotion> regionPromotionTableView;
    @FXML private TableColumn proviceTableColumn;
    @FXML private TableColumn cityTableColumn;
    @FXML private TableColumn regionTableColumn;
    @FXML private TableColumn memberGradeTableColumn;
    @FXML private TableColumn discountTableColumn;
    @FXML private TableColumn operationTableColumn;

    @FXML private ComboBox provinceBox;
    @FXML private ComboBox cityBox;
    @FXML private ComboBox regionBox;
    @FXML private ComboBox<String> gradeBox;
    @FXML private ComboBox<String> discountBox;

    private ObservableList<String> gradeData;
    private ObservableList<String> discountData;
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
    private Stage stage;
    private PromotionWebMarketerService promotionWebMarketerService;
    private HotelRegionHelper hotelRegionHelper;
    public void init(Stage stage){
        this.stage=stage;
        helper = new RegionHelper();
        promotionWebMarketerService=new PromotionWebMarketerImpl();
        hotelRegionHelper=new RegionHelper();
        gradeData=FXCollections.observableArrayList();
        discountData=FXCollections.observableArrayList();
        //初始化折扣选择框的值
        for(int i=1;i<100;i++){
            discountData.add(String.valueOf(i));
            if(i<=7){
                gradeData.add(String.valueOf(i));
            }
        }
        gradeBox.setItems(gradeData);
        discountBox.setItems(discountData);
        initProvinceBox();
        initTableView();
    }

    /**
     * 判断促销策略信息是否填写完整
     */
    private boolean isPromotionInfoFull(){
        boolean provinceFull=(!provinceBox.getValue().equals("")&&(provinceBox.getValue()!=null));
        boolean cityFull=(!cityBox.getValue().equals("")&&(cityBox.getValue()!=null));
        boolean regionFull=(!regionBox.getValue().equals("")&&(regionBox.getValue()!=null));
        boolean gradeFull=(!gradeBox.getValue().equals("")&&(gradeBox.getValue()!=null));
        boolean discountFull=(!discountBox.getValue().equals("")&&(discountBox.getValue()!=null));
        return provinceFull&&cityFull&&regionFull&&gradeFull&&discountFull;
    }

    /**
     * 点击确认添加按钮，添加商圈促销策略信息，并刷新促销策略显示表格
     */
    @FXML
    private void confirm(){
        try{
            if(isPromotionInfoFull()){
                int regionID = regionNameMap.get(regionBox.getValue());
                System.out.println(regionID+" "+discountBox.getValue()+" "+gradeBox.getValue());
                PromotionVO newPromotion = new PromotionVO(regionID,Integer.parseInt(discountBox.getValue()),Integer.parseInt(gradeBox.getValue()),Integer.parseInt(gradeBox.getValue()));
                promotionWebMarketerService.addWebPromotion(newPromotion);
                initTableView();
                provinceBox.setValue("省");
                cityBox.setValue("市");
                regionBox.setValue("商圈");
                gradeBox.setValue("会员等级");
                discountBox.setValue("折扣优惠(%)");
            }else{
                new MyDialog(stage,"请将促销策略信息填写完整",0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 从数据库读入省的信息
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

    /**
     * 根据所选省的名称，读入该省包含的市的名称
     */
    private void initCityBox(){
        List<String> cityNameList = helper.getCities(provinceName);
        cityShowList = FXCollections.observableArrayList();
        cityShowList.addAll(cityNameList);
        defaultList = FXCollections.observableArrayList();
        defaultList.add("");
        cityBox.setItems(cityShowList);
    }

    /**
     * 根据所选市的名称，读入该市商圈的名称
     */
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
     * 初始化regionPromotionTableView.从数据库拿商圈促销策略信息，显示到tableview上;
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
        PromotionFilter promotionFilter=new PromotionFilter();
        promotionFilter.add("name","=","10");
        try{
            if(promotionWebMarketerService.getWebPromotionList(promotionFilter)!=null){
                for(PromotionVO promotionVO:promotionWebMarketerService.getWebPromotionList(promotionFilter).values()){
                    RegionVO regionVO=hotelRegionHelper.getSpecificRegion(promotionVO.getRegion());
                    regionPromotionData.add(new regionPromotion(promotionVO.getPromotionID(),regionVO.getProvince(),
                            regionVO.getCity(),regionVO.getRegionName(),promotionVO.getMinRankAvailable(),promotionVO.getDiscount()));
                }
            }else{
                System.out.println("没促销数据");
            }
            regionPromotionTableView.setItems(regionPromotionData);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 在商圈促销策略列表中添加删除按钮，点击删除按钮，删除相应的促销策略
     */
    public class RegionPromotionButtonCell extends TableCell<regionPromotion,Boolean>{
        private Button deleteButton=new Button();
        private ImageView deleteImageView=new ImageView(new Image(getClass().getResourceAsStream("webmarketerimages/delete.png")));
        public RegionPromotionButtonCell(){
            deleteButton.setStyle("-fx-background-color: transparent");
            deleteImageView.setFitHeight(35);
            deleteImageView.setFitWidth(35);
            deleteButton.setGraphic(deleteImageView);
            deleteButton.setOnAction((ActionEvent e)->{
                try{
                    int seletedIndex=getTableRow().getIndex();
                    regionPromotion promotion=(regionPromotion)regionPromotionTableView.getItems().get(seletedIndex);
                    promotionWebMarketerService.deleteWebPromotion(promotion.getPromotionId());
                    initTableView();
                    regionPromotionTableView.refresh();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            });


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

    /**
     * 为添加列表数据的商圈promotion类
     */
    public class regionPromotion{
        int promotionId;
        private String provice;
        private String city;
        private String region;
        private int memberGrade;
        private int discount;
        public regionPromotion(int promotionId,String provice,String city,String region,int memberGrade,int discount){
            this.promotionId=promotionId;
            this.provice=provice;
            this.city=city;
            this.region=region;
            this.memberGrade=memberGrade;
            this.discount=discount;
        }

        public int getPromotionId() {
            return promotionId;
        }

        public void setPromotionId(int promotionId) {
            this.promotionId = promotionId;
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
