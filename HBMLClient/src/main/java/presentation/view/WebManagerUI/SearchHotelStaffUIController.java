package presentation.view.WebManagerUI;

import businesslogic.hotelInfobl.HotelWebManagerImpl;
import businesslogicservice.hotelinfoblservice.HotelWebManagerService;
import businesslogicservice.userblservice.UserStaffService;
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
import vo.HotelVO;
import vo.UserVO;

import javax.xml.soap.Text;

/**
 * Created by LENOVO on 2016/11/29.
 */
public class SearchHotelStaffUIController {

    @FXML private TextField seekStaffIdTextField;
    @FXML private Label tipLabel;
    @FXML private TableView hotelTableView;
    @FXML private TableColumn hotelIdTableColumn;
    @FXML private TableColumn hotelNameTableColumn;
    @FXML private TableColumn operationTableColumn;

    private VBox infoVBox;
    private VBox thisVBox;
    private ObservableList hotelData;
    private HotelWebManagerService hotelWebManagerService;
    private UserStaffService userStaffService;
    private Stage stage;
    public void init(VBox infoVBox,VBox thisVBox,Stage stage){
        this.infoVBox=infoVBox;
        this.thisVBox=thisVBox;
        this.stage=stage;
        hotelWebManagerService=new HotelWebManagerImpl();
        initTableView();
    }

    /**
     * 点击搜索按钮，显示酒店工作人员信息
     */
    @FXML
    private void seekStaffInfo(){
        try{
            if((!seekStaffIdTextField.getText().equals(""))&&(seekStaffIdTextField!=null)){
                UserVO userVO=userStaffService.getUserData(seekStaffIdTextField.getText());
                if(userVO!=null){
                    infoVBox.getChildren().remove(0);
                    infoVBox.getChildren().add(new HotelStaffInfoUI(infoVBox,thisVBox,stage,userVO));
                }else{
                    tipLabel.setVisible(true);
                }
            }else{
                tipLabel.setVisible(true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initTableView(){
        hotelNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        hotelIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        operationTableColumn.setCellFactory(new Callback<TableColumn<HotelVO,Boolean>, TableCell<HotelVO,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new HotelTableViewOperationCell(infoVBox,thisVBox);
            }
        });

        hotelData= FXCollections.observableArrayList();
        if(hotelWebManagerService.getAllHotel()!=null){
            for(HotelVO hotelVO:hotelWebManagerService.getAllHotel().values()){
                hotelData.add(hotelVO);
            }
        }
        hotelTableView.setItems(hotelData);
    }


    public class HotelTableViewOperationCell extends TableCell<HotelVO,Boolean>{
        private HBox operationHbox=new HBox();
        private Button viewHotelStaffInfoButton=new Button();
        private Button deleteButton=new Button();
        private Tooltip viewTooltip=new Tooltip("查看酒店工作人员的信息");
        private Tooltip deleteTooltip=new Tooltip("删除酒店");
        private ImageView viewImageView=new ImageView(new Image(getClass().getResourceAsStream("webmanagerimages/view.png")));
        private ImageView delteImageView=new ImageView(new Image(getClass().getResourceAsStream("webmanagerimages/delete.png")));
        private VBox infoVBox;
        private VBox beforeVBox;
        public HotelTableViewOperationCell(VBox infoVBox,VBox beforeVBox){
            this.infoVBox=infoVBox;
            this.beforeVBox=beforeVBox;
            operationHbox.getChildren().addAll(viewHotelStaffInfoButton,deleteButton);
            deleteButton.setStyle("-fx-background-color: transparent");
            viewHotelStaffInfoButton.setStyle("-fx-background-color: transparent");
            delteImageView.setFitHeight(35);
            delteImageView.setFitWidth(35);
            viewImageView.setFitHeight(35);
            viewImageView.setFitWidth(35);
            deleteButton.setGraphic(delteImageView);
            viewHotelStaffInfoButton.setGraphic(viewImageView);
            viewTooltip.setStyle("-fx-background-color:#0e932e;-fx-text-fill:#ffffff");
            deleteTooltip.setStyle("-fx-background-color:#d81e06;-fx-text-fill:#ffffff");
            viewHotelStaffInfoButton.setTooltip(viewTooltip);
            deleteButton.setTooltip(deleteTooltip);
            buttonAction();
        }

        private void buttonAction(){

            viewHotelStaffInfoButton.setOnAction((ActionEvent e)->{
                try{
                    int selectedIndex=getTableRow().getIndex();
                    HotelVO hotelVO=(HotelVO)hotelTableView.getItems().get(selectedIndex);
                    UserVO userVO=userStaffService.getUserData(hotelVO.getAccountName());
                    infoVBox.getChildren().remove(0);
                    infoVBox.getChildren().add(new HotelStaffInfoUI(infoVBox,beforeVBox,stage,userVO));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            });
            deleteButton.setOnAction((ActionEvent e)->{
                int selectedIndex=getTableRow().getIndex();
                HotelVO hotelVO=(HotelVO)hotelTableView.getItems().get(selectedIndex);
                hotelWebManagerService.deleteHotel(hotelVO.getId());
                initTableView();
            });
        }

        @Override
        protected  void updateItem(Boolean t,boolean empty){
            super.updateItem(t,empty);
            if(empty){
                setGraphic(null);
                setText(null);
            }else{
                setGraphic(operationHbox);
                setText(null);
            }
        }
    }


}
