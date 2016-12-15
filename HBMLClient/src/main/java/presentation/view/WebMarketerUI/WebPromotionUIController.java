package presentation.view.WebMarketerUI;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

/**
 * Created by LENOVO on 2016/12/2.
 */
public class WebPromotionUIController {



    private VBox infoVBox;
    private VBox thisVBox;
    public void init(VBox infoVBox,VBox thisVBox){
        this.infoVBox=infoVBox;
        this.thisVBox=thisVBox;
    }

    /**
     * 点击添加新促销策略按钮，跳转至对应界面
     */
    @FXML
    private void toAddWebPromotion(){
        infoVBox.getChildren().remove(0);
        infoVBox.getChildren().add(new AddWebPromotionUI(infoVBox,thisVBox));
    }
}
