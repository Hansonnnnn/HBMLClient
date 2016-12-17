package presentation.view.WebMarketerUI;

import businesslogic.promotionbl.PromotionWebMarketerImpl;
import businesslogicservice.promotionblservice.PromotionWebMarketerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import model.DateHelper;
import model.DiscountType;
import model.PromotionFilter;
import model.PromotionType;
import presentation.view.HotelManagerUI.HotelPromotionUIController;
import vo.PromotionVO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LENOVO on 2016/12/2.
 */
public class WebPromotionUIController {
    @FXML private TableView webPromotionTableView;
    @FXML private TableColumn nameColumn;
    @FXML private TableColumn startTimeColumn;
    @FXML private TableColumn endTimeColumn;
    @FXML private TableColumn memberGradeColumn;
    @FXML private TableColumn operationColumn;

    private VBox infoVBox;
    private VBox thisVBox;
//    private ObservableList webPromotionData;
    private PromotionWebMarketerService promotionWebMarketerService;
    public void init(VBox infoVBox,VBox thisVBox) throws Exception{
        this.infoVBox=infoVBox;
        this.thisVBox=thisVBox;
        promotionWebMarketerService=new PromotionWebMarketerImpl();
        initTableView();
    }

    /**
     * 点击添加新促销策略按钮，跳转至对应界面
     */
    @FXML
    private void toAddWebPromotion(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new AddWebPromotionUI(infoVBox,thisVBox));
    }

    /**
     * 初始化webPromotionTableView
     */
    private void initTableView() throws Exception{
        DateHelper dateHelper=new DateHelper();
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        startTimeColumn.setCellValueFactory(new PropertyValueFactory<>("startDateString"));
        endTimeColumn.setCellValueFactory(new PropertyValueFactory<>("endDateString"));
        memberGradeColumn.setCellValueFactory(new PropertyValueFactory<>("minRankAvailable"));
        operationColumn.setCellFactory(new Callback<TableColumn<PromotionVO,Boolean>, TableCell<PromotionVO,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new WebPromotionInfoButtonCell(infoVBox);
            }
        });
        ObservableList webPromotionData=FXCollections.observableArrayList();
        if(promotionWebMarketerService.getWebPromotionList(new PromotionFilter())!=null){
            for (PromotionVO promotionVO:promotionWebMarketerService.getWebPromotionList(new PromotionFilter()).values()) {
                webPromotionData.add(promotionVO);
            }
        }else{
            System.out.println("数据库促销数据为空");
        }
        webPromotionTableView.setItems(webPromotionData);
//        webPromotionData= FXCollections.observableArrayList();
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//        Date date=simpleDateFormat.parse("1998-11-22");
//        String startDate=dateHelper.dateToString(date);

//        webPromotionData.add(new PromotionVO(1111, PromotionType.WebPromotion,0,"双十一促销",null,date,date,3,7, DiscountType.DaZhe,0,80));
//        webPromotionTableView.setItems(webPromotionData);
    }

    /**
     * 在酒店促销策略列表添加查看策略信息按钮
     */
    public class WebPromotionInfoButtonCell extends TableCell<PromotionVO,Boolean> {
        private HBox operationHBox=new HBox();
        private Button deleteButton=new Button();
        private Button viewButton=new Button();
        private ImageView viewImageView=new ImageView(new Image(getClass().getResourceAsStream("webmarketerimages/view1.png")));
        private ImageView deleteImageView=new ImageView(new Image(getClass().getResourceAsStream("webmarketerimages/delete.png")));
        public WebPromotionInfoButtonCell(VBox infoVBox){
            operationHBox.getChildren().addAll(viewButton,deleteButton);
            viewImageView.setFitWidth(35);
            viewImageView.setFitHeight(35);
            deleteImageView.setFitWidth(35);
            deleteImageView.setFitHeight(35);
            viewButton.setGraphic(viewImageView);
            viewButton.setStyle("-fx-background-color: transparent");
            deleteButton.setGraphic(deleteImageView);
            deleteButton.setStyle("-fx-background-color: transparent");
            viewButton.setOnAction((ActionEvent e)->{
                int seletedIndex=getTableRow().getIndex();
                PromotionVO promotionVO=(PromotionVO)webPromotionTableView.getItems().get(seletedIndex);
                infoVBox.getChildren().remove(0);
                infoVBox.getChildren().add(new WebPromotionInfoUI(infoVBox,promotionVO));
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
}
