package presentation.view.HotelManagerUI;

import  java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import businesslogic.hotelInfobl.HotelStaffImpl;
import businesslogic.hotelInfobl.HotelWebManagerImpl;
import businesslogic.hotelInfobl.helper.RegionHelper;
import businesslogicservice.hotelinfoblservice.HotelRegionHelper;
import businesslogicservice.hotelinfoblservice.HotelStaffService;
import businesslogicservice.hotelinfoblservice.HotelWebManagerService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import vo.HotelVO;
import vo.RegionVO;
import vo.UserVO;


/**
 * Created by LENOVO on 2016/11/26.
 */
public class HotelInfoUIController {

    @FXML private TextField hotelNameTextField;
    @FXML private ComboBox starComboBox;
    @FXML private ComboBox provinceBox;
    @FXML private ComboBox cityBox;
    @FXML private ComboBox regionBox;
    @FXML private TextField hotelAddressTextField;
    @FXML private TextArea hotelIntroTextArea;

    @FXML private ImageView hotelImageView;
    @FXML private Button addImageButton;

    private VBox infoVBox;
    private Stage stage;
    private Desktop desktop ;
    private FileChooser fileChooser;
    private ObservableList regionData;
    private UserVO userVO;
    private ObservableList<Integer> starData;
    private ObservableList<String> provinceShowList;
    private ObservableList<String> cityShowList;
    private ObservableList<String> regionNameShowList ;
    private Map<String, Integer> regionNameMap ;
    private HotelRegionHelper helper;
    private ObservableList<String> defaultList;
    private String provinceName;
    private String cityName;
    private int regionID;
    private HotelStaffService hotelStaffService;
    private HotelWebManagerService hotelWebManagerService;
    public void init(Stage stage, VBox infoVBox, UserVO userVO){
        this.infoVBox=infoVBox;
        this.userVO=userVO;
        helper=new RegionHelper();
        for(int i=1;i<=5;i++){
            starData.add(i);
        }
        starComboBox.setItems(starData);
        hotelStaffService=new HotelStaffImpl();
        hotelWebManagerService=new HotelWebManagerImpl();
        initComboBox();
    }


    /**
     * 点击编辑按钮，编辑酒店信息
     */
    @FXML
    private void editHotelInfo(){
        hotelNameTextField.setDisable(false);
        starComboBox.setDisable(false);
        provinceBox.setDisable(false);
        cityBox.setDisable(false);
        regionBox.setDisable(false);
        hotelAddressTextField.setDisable(false);
        hotelIntroTextArea.setDisable(false);
    }

    /**
     * 点击确认修改，保存酒店信息
     */
    @FXML
    private void confirmHotelInfo(){
        hotelNameTextField.setDisable(true);
        starComboBox.setDisable(true);
        provinceBox.setDisable(true);
        cityBox.setDisable(true);
        regionBox.setDisable(true);
        hotelAddressTextField.setDisable(true);
        hotelIntroTextArea.setDisable(true);
//        HotelVO hotelVO=new HotelVO(hotelNameTextField.getText(),starComboBox.getValue(),);
    }

    /**
     * 点击加号按钮，添加酒店图片
     */
    @FXML
    private void addImage(){
        desktop=Desktop.getDesktop();
        fileChooser=new FileChooser();
        File choicefile=fileChooser.showOpenDialog(stage);
        fileChooser.setTitle("选择酒店图片");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG","*.JPG"),
                new FileChooser.ExtensionFilter("PNG","*PNG")
        );
        if(choicefile!=null){
            try{
                String path="C:/Users/LENOVO/Desktop/picture/";
                String fileName=path+choicefile.getName().toString();
                File file=new File(fileName);
                if(!file.exists()){
                    File newfile=new File(path);
                    newfile.mkdirs();
                    FileInputStream input=new FileInputStream(choicefile);
                    FileOutputStream output=new FileOutputStream(fileName);

                    byte[] b=new byte[1824*5];
                    int length;
                    while((length=input.read(b))!=-1){
                        output.write(b,0,length);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                Image image=new Image("file:///"+fileName);
                hotelImageView.setImage(image);

            }catch (Exception e){
                e.printStackTrace();
            }
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

    /**
     * 初始化酒店信息
     */
    private void initComboBox(){
        HotelVO hotelVO=hotelWebManagerService.getHotelInfo(userVO.getHotelid());
        hotelNameTextField.setText(hotelVO.getName());
    }
}
