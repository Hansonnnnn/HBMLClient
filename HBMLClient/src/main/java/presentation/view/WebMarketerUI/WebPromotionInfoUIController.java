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


}
