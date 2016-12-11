package presentation.view.HotelManagerUI;

import  java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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



/**
 * Created by LENOVO on 2016/11/26.
 */
public class HotelInfoUIController {

    @FXML private TextField hotelNameTextField;
    @FXML private ComboBox hotelRegionComboBox;
    @FXML private TextField hotelAddressTextField;
    @FXML private TextArea hotelIntroTextArea;

    @FXML private ImageView hotelImageView;
    @FXML private Button addImageButton;

    private VBox infoVBox;
    private Stage stage;
    private Desktop desktop ;
    private FileChooser fileChooser;
    private ObservableList regionData;

    public void init(Stage stage,VBox infoVBox){
        this.infoVBox=infoVBox;
        initComboBox();
    }


    /**
     * 点击编辑按钮，编辑酒店信息
     */
    @FXML
    private void editHotelInfo(){
        hotelNameTextField.setEditable(true);
        hotelRegionComboBox.setDisable(false);
        hotelAddressTextField.setEditable(true);
        hotelIntroTextArea.setEditable(true);
        addImageButton.setDisable(false);
    }

    /**
     * 点击确认修改，保存酒店信息
     */
    @FXML
    private void confirmHotelInfo(){
        hotelNameTextField.setEditable(false);
        hotelRegionComboBox.setDisable(true);
        hotelAddressTextField.setEditable(false);
        hotelIntroTextArea.setEditable(false);
        addImageButton.setDisable(true);
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
     * 初始化hotelRegionComboBox中的数据
     */
    private void initComboBox(){
        regionData= FXCollections.observableArrayList();
        regionData.add("徐家汇");
        regionData.add("中南海");
        regionData.add("故宫");
        regionData.add("中山陵");
        hotelRegionComboBox.setItems(regionData);
    }
}
