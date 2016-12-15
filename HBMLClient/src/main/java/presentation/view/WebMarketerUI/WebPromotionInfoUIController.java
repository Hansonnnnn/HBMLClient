package presentation.view.WebMarketerUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import presentation.view.HotelManagerUI.HotelPromotionUIController;
import presentation.view.HotelManagerUI.PromotionInfoUI;
import presentation.view.WebManagerUI.WebMarketerInfoUI;

/**
 * Created by LENOVO on 2016/12/15.
 */
public class WebPromotionInfoUIController {

    private VBox infoVBox;
    public void init(VBox infoVBox){
        this.infoVBox=infoVBox;
    }

    /**
     * 点击返回按钮，返回上一个界面
     */
    @FXML
    private void back(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new WebPromotionUI(infoVBox));
    }

    /**
     * 在酒店促销策略列表添加查看策略信息按钮
     */
    public class WebPromotionInfoButtonCell extends TableCell<HotelPromotionUIController.HotelPromotionInfo,Boolean> {
        private HBox operationHBox=new HBox();
        private Button deleteButton=new Button();
        private Button viewButton=new Button();
        private ImageView viewImageView=new ImageView(new Image(getClass().getResourceAsStream("ManagerImages/view1.png")));
        private ImageView deleteImageView=new ImageView(new Image(getClass().getResourceAsStream("ManagerImages/delete.png")));
        public WebPromotionInfoButtonCell(VBox infoVBox,VBox beforeVBox){
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
                infoVBox.getChildren().remove(0);
                infoVBox.getChildren().add(new WebPromotionInfoUI(infoVBox));
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
