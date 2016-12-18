package presentation.view.WebManagerUI;

import businesslogic.hotelInfobl.helper.RegionHelper;
import businesslogicservice.hotelinfoblservice.HotelRegionHelper;
import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import presentation.view.application.MyDialog;
import vo.RegionVO;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LENOVO on 2016/11/29.
 */
public class AddHotelUIController {

    @FXML private Button starButton1;
    @FXML private Button starButton2;
    @FXML private Button starButton3;
    @FXML private Button starButton4;
    @FXML private Button starButton5;
    @FXML private ImageView starImageView1;
    @FXML private ImageView starImageView2;
    @FXML private ImageView starImageView3;
    @FXML private ImageView starImageView4;
    @FXML private ImageView starImageView5;

    @FXML private TextField nameTextField;
    @FXML private ComboBox provinceBox;
    @FXML private ComboBox cityBox;
    @FXML private ComboBox regionBox;
    @FXML private TextField addressTextField;
    @FXML private TextField staffAccountTextField;
    @FXML private TextField staffPasswordTextField;
    @FXML private TextField staffNameTextField;
    @FXML private TextField staffPhoneTextField;


    private ArrayList<ImageView> imageViews;
    private ObservableList<String> provinceShowList;
    private ObservableList<String> cityShowList;
    private ObservableList<String> regionNameShowList ;
    private Map<String, Integer> regionNameMap ;
    private HotelRegionHelper helper;
    private ObservableList<String> defaultList;
    private String provinceName;
    private String cityName;
    private int regionID;
    private int star;
    private Image starImage=new Image(getClass().getResourceAsStream("webmanagerimages/star.png"));
    private Image blueStarImage=new Image(getClass().getResourceAsStream("webmanagerimages/bluestar.png"));
    private Stage stage;
    public void init(Stage stage){
        this.stage=stage;
        helper = new RegionHelper();
        star=0;
        initstar();
        initProvinceBox();
    }
    /**
     * 点击确认按钮
     */
    @FXML
    private void confirm(){
        try{
            boolean hotelInfoJudge=(!nameTextField.getText().equals(""))&&(nameTextField.getText()!=null)
                    &&(!addressTextField.getText().equals(""))&&(addressTextField.getText()!=null)&&
                    (star!=0)&&(provinceBox.getValue()!=null) &&(cityBox.getValue()!=null)&&
                    (regionBox.getValue()!=null);
            boolean staffInfoJudge=(!staffAccountTextField.getText().equals(""))&&(staffAccountTextField.getText()!=null)
                    &&(!staffPasswordTextField.getText().equals(""))&&(staffPasswordTextField.getText()!=null)&&
                    (!staffNameTextField.getText().equals(""))&&(staffNameTextField.getText()!=null)&&
                    (!staffPhoneTextField.getText().equals(""))&&(staffPhoneTextField.getText()!=null);
            if(hotelInfoJudge&&staffInfoJudge){

            }else if((!hotelInfoJudge)&&(staffInfoJudge)){
                new MyDialog(stage,"请将酒店基本信息填写完整",0);
            }else if(hotelInfoJudge&&(!staffInfoJudge)){
                new MyDialog(stage,"请将酒店工作人员基本信息填写完整",0);
            }else{
                new MyDialog(stage,"请将基本信息填写完整",0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
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


    private void initstar(){
        imageViews=new ArrayList<>();
        imageViews.add(starImageView1);
        imageViews.add(starImageView2);
        imageViews.add(starImageView3);
        imageViews.add(starImageView4);
        imageViews.add(starImageView5);

        starButton1.setOnAction((ActionEvent e)->{
            star=1;
            for(int j=0;j<=0;j++){
                imageViews.get(j).setImage(blueStarImage);
            }
            for(int k=0+1;k<imageViews.size();k++){
                imageViews.get(k).setImage(starImage);
            }
        });
        starButton2.setOnAction((ActionEvent e)->{
            star=2;
            for(int j=0;j<=1;j++){
                imageViews.get(j).setImage(blueStarImage);
            }
            for(int k=1+1;k<imageViews.size();k++){
                imageViews.get(k).setImage(starImage);
            }
        });
        starButton3.setOnAction((ActionEvent e)->{
            star=3;
            for(int j=0;j<=2;j++){
                imageViews.get(j).setImage(blueStarImage);
            }
            for(int k=2+1;k<imageViews.size();k++){
                imageViews.get(k).setImage(starImage);
            }
        });
        starButton4.setOnAction((ActionEvent e)->{
            star=4;
            for(int j=0;j<=3;j++){
                imageViews.get(j).setImage(blueStarImage);
            }
            for(int k=3+1;k<imageViews.size();k++){
                imageViews.get(k).setImage(starImage);
            }
        });
        starButton5.setOnAction((ActionEvent e)->{
            star=5;
            for(int j=0;j<=4;j++){
                imageViews.get(j).setImage(blueStarImage);
            }
            for(int k=4+1;k<imageViews.size();k++){
                imageViews.get(k).setImage(starImage);
            }
        });
    }
}


